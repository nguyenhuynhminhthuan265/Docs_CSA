package com.cybersoft.dslk;

import java.util.Arrays;

public class Sach {
	private final int MAX_SIZE_AUTH = 5;
	private String tenSach;
	private String[] tacGia;
	private String nhaSuatBan;
	private int namXuatBan;

	public Sach() {
		tacGia = new String[MAX_SIZE_AUTH];
	}

	public Sach(String tenSach, String[] tacGia, String nhaSuatBan, int namXuatBan) {

		this.tenSach = tenSach;
		this.nhaSuatBan = nhaSuatBan;
		this.namXuatBan = namXuatBan;
		if (tacGia.length > MAX_SIZE_AUTH) {
			System.out.println("Moi sach toi da 5 tac gia");
			for (int i = 0; i < MAX_SIZE_AUTH; i++) {
				this.tacGia[i] = tacGia[i];
			}
			return;
		}
		this.tacGia = tacGia;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String[] getTacGia() {
		return tacGia;
	}

	public void setTacGia(String[] tacGia) {
		if (tacGia.length > MAX_SIZE_AUTH) {
			System.out.println("Moi sach toi da 5 tac gia");
			for (int i = 0; i < MAX_SIZE_AUTH; i++) {
				this.tacGia[i] = tacGia[i];
			}
			return;
		}
		this.tacGia = tacGia;
	}

	public String getNhaSuatBan() {
		return nhaSuatBan;
	}

	public void setNhaSuatBan(String nhaSuatBan) {
		this.nhaSuatBan = nhaSuatBan;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	@Override
	public String toString() {
		return "Sach [tenSach=" + tenSach + ", tacGia=" + Arrays.toString(tacGia) + ", nhaSuatBan=" + nhaSuatBan
				+ ", namXuatBan=" + namXuatBan + "]";
	}

}
