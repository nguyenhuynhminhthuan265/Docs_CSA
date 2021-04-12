package com.cybersoft.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cybersoft.model.dto.UserLoginDto;
import com.cybersoft.model.entity.CauHoi;
import com.cybersoft.model.entity.DiemThi;
import com.cybersoft.model.entity.LopHoc;
import com.cybersoft.model.entity.MonHoc;
import com.cybersoft.model.entity.SinhVien;

import com.cybersoft.node.NodeMonHoc;
import com.cybersoft.node.NodeSinhVien;
import com.cybersoft.node.generic.CustomLinkedList;
import com.cybersoft.node.generic.Node;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TruongHoc truongHoc = new TruongHoc();

		truongHoc.dsMonHoc = truongHoc.generateMonHoc();
		truongHoc.dsMonHoc.show();

		truongHoc.dsLopHoc = truongHoc.generateLopHoc();
		themSinhVienVaoLopHoc(truongHoc.dsLopHoc, truongHoc.dsSinhVienToanTruong);

		for (LopHoc lopHoc : truongHoc.dsLopHoc) {
			lopHoc.print();
		}
		System.out.println("\t\t\tDS SINH VIEN TOAN TRUONG");
		truongHoc.dsSinhVienToanTruong.show();

		System.out.println("\t\t\tCAU HOI THI");
		truongHoc.dsCauHoi = truongHoc.generateCauHoi();
		truongHoc.dsCauHoi.LNR(truongHoc.dsCauHoi.root);

		truongHoc.dsMonHoc.show();

		UserLoginDto userLoginDto = filterAuth(truongHoc);
		if (userLoginDto.getUsername().equals("GV") && userLoginDto.getPassword().equals("GV")) {
			toDoGiaoVien(truongHoc, sc);
		} else {
			SinhVien sinhVien = truongHoc.findByUsername(Integer.valueOf(userLoginDto.getUsername()));
			int option;
			do {
				System.out.println("1: Thi trac nghiem");
				System.out.println("2: In bang diem mon hoc cua sinh vien");
				System.out.println("3: In chi tiet cau hoi da thi 1 mon hoc cua sinh vien");
				System.out.println("4: Thoat");
				System.out.print("option: ");
				option = Integer.parseInt(sc.nextLine());
				switch (option) {
				case 1:
					ThiTracNghiem(sc, truongHoc, sinhVien);
					break;
				case 2:
					CustomLinkedList<DiemThi> dsDiemThi = sinhVien.getDsDiemThi();
					dsDiemThi.show("Sinh vien chua thi mon nao");
					break;
				case 3:
					ThiTracNghiem(sc, truongHoc, sinhVien);
					break;

				default:
					break;
				}
			} while (option != 4);

		}
	}

	private static void ThiTracNghiem(Scanner sc, TruongHoc truongHoc, SinhVien sinhVien) {
		System.out.println("Mon Thi: ");
		// Nhập Môn học
		int maMonHoc;
		do {
			System.out.print("Nhap MA MON HOC: ");
			maMonHoc = Integer.parseInt(sc.nextLine());
			if (truongHoc.findByMonHoc(maMonHoc) == null) {
				System.out.println("Mon Hoc khong da ton tai !!! Nhap lai");
			}
		} while (truongHoc.findByMonHoc(maMonHoc) == null);

		System.out.println("So cau hoi thi: ");
		int soCauHoi = Integer.parseInt(sc.nextLine());
		List<CauHoi> list = truongHoc.danhSachCauHoiTheoMonHoc(maMonHoc);

		List<CauHoi> cauHoiThi = new ArrayList<CauHoi>();

		if (!list.isEmpty()) {

			for (int i = 0; i < soCauHoi; i++) {
				int index = (int) (Math.random() * ((list.size() - 0))) + 0;
				cauHoiThi.add(list.get(index));
			}

		}

		for (CauHoi cauHoi : cauHoiThi) {
			System.out.println(cauHoi.toString());
		}

		System.out.println("Tra loi cau hoi bằng cách gõ liên tục đáp án, ví dụ: aabbccd hoặc AABBCCDD ");
		String answer = sc.nextLine();
		String[] arrayAnswer = answer.split("");
		int soCauDung = 0;
		for (int i = 0; i < cauHoiThi.size(); i++) {
			if (cauHoiThi.get(i).getDapAn().getLuaChon().toLowerCase().equals(arrayAnswer[i].toLowerCase())) {
				soCauDung++;
			}
		}
		System.out.println("So cau dung: " + soCauDung);
		float diem = (float) soCauDung * 10 / cauHoiThi.size();
		DiemThi diemThi = new DiemThi(maMonHoc, diem);
		truongHoc.capNhatDiemSinhVien(sinhVien.getMaSV(), diemThi);
		truongHoc.findByUsername(sinhVien.getMaSV()).getDsDiemThi().show("Sinh vien chua thi mon nao");
	}

	private static UserLoginDto filterAuth(TruongHoc truongHoc) {
		Scanner sc = new Scanner(System.in);
		UserLoginDto userLoginDto;
		SinhVien sinhVien;

		do {
			userLoginDto = new UserLoginDto();
			System.out.println("************************Form Login************************");
			System.out.print("Ten Dang Nhap: ");
			userLoginDto.setUsername(sc.nextLine());
			System.out.print("Password: ");
			userLoginDto.setPassword(sc.nextLine());

			if (userLoginDto.getUsername().equals("GV") && userLoginDto.getPassword().equals("GV"))
				break;

			sinhVien = truongHoc.findByUsername(Integer.valueOf(userLoginDto.getUsername()));

			if (userLoginDto.getUsername().trim().length() == 0 || userLoginDto.getPassword().trim().length() == 0) {
				System.out.println("Username Password khong dung!!! Moi nhap lai");
			} else if (sinhVien != null) {
				break;
			} else {
				System.out.println("Username Password khong dung!!! Moi nhap lai");
			}

		} while (userLoginDto.getUsername().trim().length() == 0 || userLoginDto.getPassword().trim().length() == 0);
		return userLoginDto;
	}

	private static void toDoGiaoVien(TruongHoc truongHoc, Scanner sc) {
		int option;
		boolean flag = true;
		do {
			System.out.println("0: Thoat");
			System.out.println("1: Nhap lop");
			System.out.println("2: In danh sach lop");
			System.out.println("3: Nhap sinh vien cua lop");
			System.out.println("4: Nhap mon hoc");
			System.out.println("5: Nhap cau hoi thi");
			System.out.print("Option: ");
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case 0:
				flag = false;
				break;
			case 1:
				// Nhập lớp, in danh sách lớp
				LopHoc lopHoc = new LopHoc();
				do {
					lopHoc.input(sc);
					if (truongHoc.findByMaLop(lopHoc.getMaLop()) != null) {
						System.out.println("Ma Lop da ton tai !!! Nhap lai");
						System.out.println(truongHoc.findByMaLop(lopHoc.getMaLop()).toString());
					}
				} while (truongHoc.findByMaLop(lopHoc.getMaLop()) != null);
				truongHoc.dsLopHoc.add(lopHoc);
				break;
			case 2:
				for (LopHoc item : truongHoc.dsLopHoc) {
					item.print();
				}
				break;
			case 3:
				// Nhập sinh viên của lớp
				int maLop;
				do {
					System.out.print("Nhap Ma Lop cua Sinh Vien: ");
					maLop = Integer.parseInt(sc.nextLine());
					if (truongHoc.findByMaLop(maLop) == null) {
						System.out.println("Ma Lop khong ton tai !!! Nhap lai");
					}
				} while (truongHoc.findByMaLop(maLop) == null);

				SinhVien sinhVien = new SinhVien();
				sinhVien.input(sc);
				truongHoc.findByMaLop(maLop).themSinhVien(sinhVien, truongHoc.dsSinhVienToanTruong);
				break;
			case 4:
				// Nhập Môn học
				MonHoc monHoc = new MonHoc();
				do {
					monHoc.input(sc);
					if (truongHoc.findByMonHoc(monHoc) != null) {
						System.out.println("Mon Hoc da ton tai !!! Nhap lai");
						System.out.println(truongHoc.findByMonHoc(monHoc).toString());
					}
				} while (truongHoc.findByMonHoc(monHoc) != null);
				truongHoc.dsMonHoc.insert(monHoc);
				break;
			case 5:
				// Nhập câu hỏi thi
				CauHoi cauHoi = new CauHoi();
				cauHoi.input(sc);
				cauHoi.setId(TruongHoc.generateID());
				truongHoc.dsCauHoi.insert(cauHoi);
				truongHoc.dsCauHoi.buildTree();
				break;

			default:
				break;
			}
		} while (flag);
	}

	private static void themSinhVienVaoLopHoc(List<LopHoc> dsLopHoc, NodeSinhVien dsSinhVienToanTruong) {
		dsLopHoc.get(0).themSinhVien(new SinhVien(1, "sv1", "123456", "Nam"), dsSinhVienToanTruong);
		dsLopHoc.get(0).themSinhVien(new SinhVien(2, "sv2", "123456", "Nu"), dsSinhVienToanTruong);
		dsLopHoc.get(0).themSinhVien(new SinhVien(3, "sv3", "123456", "Nam"), dsSinhVienToanTruong);
		dsLopHoc.get(0).themSinhVien(new SinhVien(4, "sv4", "123456", "Nu"), dsSinhVienToanTruong);
		dsLopHoc.get(0).themSinhVien(new SinhVien(5, "sv5", "123456", "Nam"), dsSinhVienToanTruong);

		dsLopHoc.get(1).themSinhVien(new SinhVien(6, "sv6", "123456", "Nu"), dsSinhVienToanTruong);
		dsLopHoc.get(1).themSinhVien(new SinhVien(7, "sv7", "123456", "Nam"), dsSinhVienToanTruong);
		dsLopHoc.get(1).themSinhVien(new SinhVien(8, "sv8", "123456", "Nu"), dsSinhVienToanTruong);
		dsLopHoc.get(1).themSinhVien(new SinhVien(9, "sv9", "123456", "Nam"), dsSinhVienToanTruong);
		dsLopHoc.get(1).themSinhVien(new SinhVien(10, "sv10", "123456", "Nam"), dsSinhVienToanTruong);
	}

}
