package com.vexeonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class DanhGia implements Serializable {

	private static final long serialVersionUID = -2657494317065945255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idDanhGia;

	@Column(nullable = false, length = 1000)
	private String noiDung;

	@Column(nullable = false)
	private float diem;

	private boolean trangThai;
	
	@Column(nullable = false)
	private Date ngayDi;
	
	@Column(nullable = false)
	private Date ngayDanhGia;

	@ManyToOne
	@JoinColumn(nullable = false)
	private HanhKhach hanhKhach;

	@ManyToOne
	@JoinColumn(nullable = false)
	private NhaXe nhaXe;

	public int getIdDanhGia() {
		return idDanhGia;
	}

	public void setIdDanhGia(int idDanhGia) {
		this.idDanhGia = idDanhGia;
	}

	@RequiredStringValidator(key = "require.noiDungDanhGia", trim = true)
	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@RequiredFieldValidator(key = "require.DiemDanhGia")
	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	public HanhKhach getHanhKhach() {
		return hanhKhach;
	}

	public void setHanhKhach(HanhKhach hanhKhach) {
		this.hanhKhach = hanhKhach;
	}

	public boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public Date getNgayDanhGia() {
		return ngayDanhGia;
	}

	public void setNgayDanhGia(Date ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}

}
