package com.vexeonline.action.khachhang;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.service.nhaxe.VehicleService;
import com.vexeonline.service.nhaxe.VehicleServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = {"validation.excludeMethods","chonChoNgoi, datve, xacNhanVe"})
public class DatVeXe extends ActionSupport  {
	
	private static final long serialVersionUID = 6453306615485591423L;
	
	private static Logger logger = Logger.getLogger(DatVeXe.class);
	
	private static KhachHangService khachHangService = new KhachHangServiceImpl();
	
	@Action(value = "datve",results =  @Result(name = "success", location = "ketquadatve", type = "tiles"))
	public String datVe() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String viTris = request.getParameter("chonCho");
			logger.info(viTris);
			String tenKhachHang = request.getParameter("tenKhachHang");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			int idLichTuyen = Integer.parseInt(request.getParameter("idLichTuyen"));
			Time gioDi = Time.valueOf(request.getParameter("gioDi"));
			Date ngayDi = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy").parse(request.getParameter("ngayDi"));
			
			boolean flag = khachHangService.datVe(viTris, idLichTuyen, ngayDi, gioDi, tenKhachHang, email, sdt);
			request.setAttribute("result", flag);
			logger.info(tenKhachHang + " " + sdt + " " + email);
		} catch (Exception e) {
			logger.error("Error", e);
		}

		return SUCCESS;
	}
	
	@Action(value = "chonchongoi", results = {
			@Result(name = "success", location = "book", type = "tiles"),
			@Result(name = "input", location = "trips", type = "tiles")
	})
	public String chonChoNgoi() {
		Transaction tx = null;
		try {			
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HttpServletRequest request = ServletActionContext.getRequest();
			int idLichTuyen = Integer.parseInt(request.getParameter("idLichTuyen"));
			Date ngayDi = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy").parse(request.getParameter("ngayDi"));
			logger.info(ngayDi);
			Time gioDi = Time.valueOf(request.getParameter("gioDi"));
			int idXe = Integer.parseInt(request.getParameter("idXe"));
			
			List<String> listA = new ArrayList<String>(0);
			List<String> listB = new ArrayList<String>(0);
			List<String> listC = new ArrayList<String>(0);
			List<String> listD = new ArrayList<String>(0);
			List<String> listE = new ArrayList<String>(0);
			
			/*String soDo = khachHangService.listChoByXe(idXe, idLichTuyen, ngayDi, gioDi, listA, listB, listC, listD, listE);*/
			khachHangService.listChoByXe(idXe, idLichTuyen, ngayDi, gioDi, listA, listB, listC, listD, listE);
			
			
			/*logger.info(listA.size() + " " + listB.size());
			request.setAttribute("listA", listA);
			request.setAttribute("listB", listB);
			request.setAttribute("listC", listC);
			request.setAttribute("listD", listD);
			request.setAttribute("listE", listE);*/
			
			VehicleService vehicleService = new VehicleServiceImpl();
			VehicleDTO vehicle = vehicleService.getVehicle(idXe);
			if (vehicle != null) {
				request.setAttribute("seats", vehicle.getType().getSeats());
			}
			
			List<String> emptySeats = new ArrayList<String>();
			emptySeats.addAll(listA);
			emptySeats.addAll(listB);
			emptySeats.addAll(listC);
			emptySeats.addAll(listD);
			emptySeats.addAll(listE);
			Gson gson = new Gson();
			request.setAttribute("emptySeats", gson.toJson(emptySeats));
			
			/*request.setAttribute("soDoViTri", soDo);*/
			tx.commit();
			return SUCCESS;
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			logger.error("Error", e);
			return INPUT;
		}
	}

	@Action(value = "xacnhanve", results = @Result(name = "success", location = "xacnhanve", type = "tiles"))
	public String xacNhanVe() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String maVe = request.getParameter("maVe");

			boolean result = khachHangService.xacNhanVe(maVe);
			request.setAttribute("result", result);

		} catch (Exception e) {
			logger.error("Error", e);
		}

		return SUCCESS;
	}
}
