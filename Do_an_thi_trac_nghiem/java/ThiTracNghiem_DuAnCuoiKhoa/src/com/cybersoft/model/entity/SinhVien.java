package com.cybersoft.model.entity;

import java.util.Scanner;

import com.cybersoft.node.NodeDiemThi;
import com.cybersoft.node.generic.*;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private String password;
	private String phai;
	CustomLinkedList<DiemThi> dsDiemThi;

	public SinhVien() {
		
	}

	public SinhVien(int maSV, String hoTen, String password, String phai, CustomLinkedList<DiemThi> dsDiemThi) {

		this.maSV = maSV;
		this.hoTen = hoTen;
		this.password = password;
		this.phai = phai;
		this.dsDiemThi = dsDiemThi;
	}

	public SinhVien(int maSV, String hoTen, String password, String phai) {

		this.maSV = maSV;
		this.hoTen = hoTen;
		this.password = password;
		this.phai = phai;
		this.dsDiemThi = new NodeDiemThi();
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public CustomLinkedList<DiemThi> getDsDiemThi() {
		return dsDiemThi;
	}

	public void setDsDiemThi(CustomLinkedList<DiemThi> dsDiemThi) {
		this.dsDiemThi = dsDiemThi;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", password=" + password + ", phai=" + phai + "]";
	}

	public void input(Scanner sc) {
		System.out.print("Ma Sinh Vien: ");
		this.setMaSV(Integer.parseInt(sc.nextLine()));
		System.out.print("Ho ten Sinh Vien: ");
		this.setHoTen(sc.nextLine());
		this.setPassword("123456");
		System.out.print("Gioi tinh: ");
		this.setPhai(sc.nextLine());
	}

}
