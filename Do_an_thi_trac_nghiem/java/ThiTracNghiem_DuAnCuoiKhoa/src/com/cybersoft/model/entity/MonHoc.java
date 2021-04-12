package com.cybersoft.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonHoc {
	private int maMH;
	private String tenMH;
	List<Integer> idCauHoi = new ArrayList<Integer>();

	public MonHoc() {

	}

	public List<Integer> getIdCauHoi() {
		return idCauHoi;
	}

	public void setIdCauHoi(List<Integer> idCauHoi) {
		this.idCauHoi = idCauHoi;
	}

	public MonHoc(int maMH, String tenMH) {

		this.maMH = maMH;
		this.tenMH = tenMH;
	}

	public MonHoc(int maMH, String tenMH, List<Integer> idCauHoi) {
	
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.idCauHoi = idCauHoi;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public void input(Scanner sc) {
		System.out.print("Nhap Ma Mon Hoc: ");
		this.maMH = Integer.parseInt(sc.nextLine());

		System.out.println("Nhap Ten Mon Hoc: ");
		this.tenMH = sc.nextLine();
	}

	@Override
	public String toString() {
		return "MonHoc [maMH=" + maMH + ", tenMH=" + tenMH + ", idCauHoi=" + idCauHoi + "]";
	}

}
