package com.cybersoft.excersies.qlkho;

import java.util.Scanner;

public class MatHang {
	private String maMatHang;
	private String tenMatHang;

	public MatHang() {

	}

	public MatHang(String maMatHang, String tenMatHang) {

		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public MatHang input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Mã hàng: ");
		this.maMatHang = sc.nextLine();
		System.out.print("Tên mặt hàng: ");
		this.tenMatHang = sc.nextLine();

		return new MatHang(this.maMatHang, this.tenMatHang);

	}

	@Override
	public String toString() {
		return "MatHang [maMatHang=" + maMatHang + ", tenMatHang=" + tenMatHang + "]";
	}

}
