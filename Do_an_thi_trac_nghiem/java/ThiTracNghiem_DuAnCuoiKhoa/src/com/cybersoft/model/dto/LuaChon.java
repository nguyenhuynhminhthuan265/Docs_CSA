package com.cybersoft.model.dto;

import java.util.Scanner;

public class LuaChon {
	private String luaChon;
	private String noiDungLuaChon;

	public LuaChon() {

	}

	public LuaChon(String luaChon, String noiDungLuaChon) {

		this.luaChon = luaChon;
		this.noiDungLuaChon = noiDungLuaChon;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getNoiDungLuaChon() {
		return noiDungLuaChon;
	}

	public void setNoiDungLuaChon(String noiDungLuaChon) {
		this.noiDungLuaChon = noiDungLuaChon;
	}

	@Override
	public String toString() {
		return luaChon + ": " + noiDungLuaChon + "\n";
	}

}
