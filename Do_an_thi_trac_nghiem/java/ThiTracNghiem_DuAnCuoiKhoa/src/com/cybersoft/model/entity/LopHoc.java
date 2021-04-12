package com.cybersoft.model.entity;

import java.util.Scanner;

import com.cybersoft.node.NodeSinhVien;
import com.cybersoft.node.generic.*;

public class LopHoc {
	private int maLop;
	private String tenLop;
	CustomLinkedList<SinhVien> dsSinhVien;

	public LopHoc() {
		dsSinhVien = new NodeSinhVien();
	}

	public LopHoc(int maLop, String tenLop, CustomLinkedList<SinhVien> dsSinhVien) {

		this.maLop = maLop;
		this.tenLop = tenLop;
		this.dsSinhVien = dsSinhVien;
	}

	public LopHoc(int maLop, String tenLop) {

		this.maLop = maLop;
		this.tenLop = tenLop;
		this.dsSinhVien = new NodeSinhVien();

	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public CustomLinkedList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(CustomLinkedList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public SinhVien themSinhVien(SinhVien sinhVien, NodeSinhVien dsSinhVienToanTruong) {
		dsSinhVien.insert(sinhVien);
		dsSinhVienToanTruong.insert(sinhVien);
		return sinhVien;
	}

	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + "]";
	}

	public void print() {
		System.out.println();
		System.out.println("\t\t\t" + toString());
		dsSinhVien.show();

	}

	public void input(Scanner sc) {
		System.out.print("Ma Lop: ");
		this.setMaLop(Integer.parseInt(sc.nextLine()));

		System.out.print("Ten Lop: ");
		this.setTenLop(sc.nextLine());
	}

}
