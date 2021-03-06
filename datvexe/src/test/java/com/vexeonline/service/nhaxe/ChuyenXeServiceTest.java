package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;

import org.hibernate.Transaction;

import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.HanhKhachDTO;
import com.vexeonline.dto.ScheduleDTO;
import com.vexeonline.dto.TicketDTO;
import com.vexeonline.utils.HibernateUtil;

public class ChuyenXeServiceTest {
	
	private static final ChuyenXeService service = new ChuyenXeServiceImpl();
	private static final ScheduleService scheduleService = new ScheduleServiceImpl();
	
	public static void test000() throws Exception {
		for (ChuyenXeDTO chuyenXe : service.getChuyenXes()) {
			System.out.println(chuyenXe);
		}
	}
	
	public static void test001() throws Exception {
		for (ChuyenXeDTO chuyenXe : service.getChuyenXes(2)) {
			System.out.println(chuyenXe);
		}
	}
	
	public static void test002() throws Exception {
		System.out.println(service.getChuyenXe(1, 2));
	}
	
	public static void test003() throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		ScheduleDTO schedule19 = scheduleService.getById(19);
		
		ChuyenXeDTO chuyenXe1 = new ChuyenXeDTO();
		chuyenXe1.setDepartDate(df.parse("10/01/2015"));
		chuyenXe1.setSchedule(schedule19);
		chuyenXe1.setTenTaiXe("Nguyễn Văn Ba");
		chuyenXe1.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
		
		HanhKhachDTO hanhKhach = new HanhKhachDTO("Đặng Quang Hưng", "01662488323", "dqhspcr@gmail.com");
		
		TicketDTO ticket1 = new TicketDTO("A1", hanhKhach);
		chuyenXe1.getTickets().add(ticket1);
		
		TicketDTO ticket2 = new TicketDTO("A2", hanhKhach);
		chuyenXe1.getTickets().add(ticket2);
		
		TicketDTO ticket3 = new TicketDTO("A3", hanhKhach);
		chuyenXe1.getTickets().add(ticket3);
		
		service.insertChuyenXe(chuyenXe1);
	}
		
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			//test003();
			test001();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
