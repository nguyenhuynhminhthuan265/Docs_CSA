package com.cybersoft.model.entity;

public class DiemThi {
	private int maMH;
	private float diem;

	public DiemThi() {
		// TODO Auto-generated constructor stub
	}

	public DiemThi(int maMH, float diem) {

		this.maMH = maMH;
		this.diem = diem;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "DiemThi [maMH=" + maMH + ", diem=" + diem + "]";
	}

}
