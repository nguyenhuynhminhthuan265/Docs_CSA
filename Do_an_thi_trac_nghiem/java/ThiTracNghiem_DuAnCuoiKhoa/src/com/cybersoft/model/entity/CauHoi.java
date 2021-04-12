package com.cybersoft.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cybersoft.model.dto.LuaChon;

public class CauHoi {
	private int id;
	private int maMH;
	private String noiDung;
	private List<LuaChon> luaChon; // A,B,C,D
	private LuaChon dapAn;

	public CauHoi() {
		luaChon = new ArrayList<LuaChon>(4);
	}

	public CauHoi(int maMH, String noiDung) {
		this.maMH = maMH;
		this.noiDung = noiDung;
	}

	public CauHoi(int id, int maMH, String noiDung) {

		this.id = id;
		this.maMH = maMH;
		this.noiDung = noiDung;
	}

	public CauHoi(int id, int maMH, String noiDung, List<LuaChon> luaChon, LuaChon dapAn) {

		this.id = id;
		this.maMH = maMH;
		this.noiDung = noiDung;
		this.luaChon = luaChon;
		this.dapAn = dapAn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public List<LuaChon> getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(List<LuaChon> luaChon) {
		this.luaChon = luaChon;
	}

	public LuaChon getDapAn() {
		return dapAn;
	}

	public void setDapAn(LuaChon dapAn) {
		this.dapAn = dapAn;
	}

	public void input(Scanner scan) {
		System.out.print("Nhap MA MON HOC: ");
		this.maMH = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap NOI DUNG CAU HOI: ");
		this.noiDung = scan.nextLine();
		System.out.println("Nhap cac tuy chon: ");

		int indexASCII = 65; // A;
		for (int i = 0; i < 4; i++) {
			System.out.print((char) indexASCII + ": ");
			LuaChon tmp = new LuaChon();
			tmp.setLuaChon((char) indexASCII + "");
			tmp.setNoiDungLuaChon(scan.nextLine());
			this.luaChon.add(tmp);
			indexASCII++;
		}

		boolean flag = true;
		do {

			System.out.print("DAP AN: (chi can nhap A,B,C,D hoac a,b,c,d): ");
			String temp = scan.nextLine();
			for (int i = 0; i < luaChon.size(); i++) {
				if (luaChon.get(i).getLuaChon().toLowerCase().equals(temp.toLowerCase())) {
					this.dapAn = luaChon.get(i);
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("DAP AN khong ton tai. Moi nhap lai");
			}
		} while (flag);

	}

	@Override
	public String toString() {
		return "CauHoi [id=" + id + ", maMH=" + maMH + ", noiDung=" + noiDung + "]\n" + luaChon;
	}

}
