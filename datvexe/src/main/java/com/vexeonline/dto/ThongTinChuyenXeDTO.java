package com.vexeonline.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

public class ThongTinChuyenXeDTO implements Serializable {
	private static final long serialVersionUID = 2596991614311901006L;
	private String tenNhaXe;
	private List<String> tienIchs;
	private String loaiXe;
	private String tenBenDi;
	private String tenBenDen;
	private Time gioDi;
	private double tongThoiGian;
	private long soChoConLai;
	private int soCho;
	private double rating;
	private int idNhaXe;
	private int idLichTuyen;
	private int giaVe;
	private int idXe;

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public List<String> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<String> tienIchs) {
		this.tienIchs = tienIchs;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getTenBenDi() {
		return tenBenDi;
	}

	public void setTenBenDi(String tenBenDi) {
		this.tenBenDi = tenBenDi;
	}

	public String getTenBenDen() {
		return tenBenDen;
	}

	public void setTenBenDen(String tenBenDen) {
		this.tenBenDen = tenBenDen;
	}

	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	public double getTongThoiGian() {
		return tongThoiGian;
	}

	public void setTongThoiGian(double tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	public long getSoChoConLai() {
		return soChoConLai;
	}

	public void setSoChoConLai(long l) {
		this.soChoConLai = l;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(int idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public int getIdLichTuyen() {
		return idLichTuyen;
	}

	public void setIdLichTuyen(int idLichTuyen) {
		this.idLichTuyen = idLichTuyen;
	}

	public int getIdXe() {
		return idXe;
	}

	public void setIdXe(int idXe) {
		this.idXe = idXe;
	}

	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}

}
