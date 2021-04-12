package com.cybersoft.dslk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		String[] teamTacGia1 = { "tac gia 1", "tac gia 2", "tac gia 3", "tac gia 4", "tac gia 5" };
		String[] teamTacGia2 = { "tac gia 6", "tac gia 7", "tac gia 8" };
		String[] teamTacGia3 = { "tac gia 9", "tac gia 10", "tac gia 11", "tac gia 12" };
		String[] teamTacGia4 = { "tac gia 1", "tac gia 2", "tac gia 3", "tac gia 8", "tac gia 11" };

		Sach sach1 = new Sach("Nhap mon lap trinh", teamTacGia1, "Cybersoft", 1999);
		Sach sach2 = new Sach("Ky Thuat Lap Trinh", teamTacGia2, "Cyberlearn", 2000);
		Sach sach3 = new Sach("Lap trinh OOP", teamTacGia3, "Cyberlearn", 2001);
		Sach sach4 = new Sach("Phat trien ung dung Web", teamTacGia4, "Cybersoft Acedamy", 2002);
		Sach sach5 = new Sach("Phan trien ung dung di dong", teamTacGia2, "Cyberlearn", 2000);

		CustomLinkedList customLinkedList = new CustomLinkedList();
		customLinkedList.insert(sach1);
		customLinkedList.insert(sach2);
		customLinkedList.insert(sach3);
		customLinkedList.insert(sach4);
		customLinkedList.insert(sach5);
		customLinkedList.show();

		do {
			System.out.println();
			System.out.println("1 : Cho biet so luong quyen sach cua tac gia");
			System.out.println(
					"2 : Trong năm YYYY (nhập từ bàn phím), nhà xuất bản ABC (nhập từ bàn phím) đã phát hành những quyển sách nào");

			System.out.println("0 : Thoat");
			System.out.print("Option: ");
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case 0:
				break;
			case 1:

				System.out.print("Ten tac gia ban muon tim: ");
				String tenTacGia = sc.nextLine();
				System.out.println("So luong quyen sach: " + soLuongSachCuaTacGia(customLinkedList, tenTacGia));
				break;

			case 2:
				System.out.print("Nam xuat ban: ");
				int namXuatBan = Integer.parseInt(sc.nextLine());
				System.out.print("Nha xuat ban: ");
				String nhaXuatBan = sc.nextLine();

				List<Sach> list = timSachTheoNamXuatBanVaNhaXuatBan(customLinkedList, namXuatBan, nhaXuatBan);
				if (list.size() == 0) {
					System.out.println("Khong co sach");
				} else {
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).toString());
					}
				}

				break;

			default:
				System.out.println("Error : Moi nhap lai lua chon");
				break;
			}

		} while (option == 1 || option == 2);

//		TEST
//		System.out.println(soLuongSachCuaTacGia(customLinkedList, "tac gia 1"));
//		System.out.println("==========");
//		List<Sach> list = timSachTheoNamXuatBanVaNhaXuatBan(customLinkedList, 2000, "Cyberlearn");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}

	}

	public static List<Sach> timSachTheoNamXuatBanVaNhaXuatBan(CustomLinkedList customLinkedList, int namXuatBan,
			String nhaXuatBan) {
		List<Sach> danhSachSach = new ArrayList<Sach>();
		Node<Sach> temp = customLinkedList.head;

		while (temp.next != null) {
			if (temp.data.getNamXuatBan() == namXuatBan && temp.data.getNhaSuatBan().equals(nhaXuatBan)) {
				danhSachSach.add(temp.data);
			}
			temp = temp.next;

			// last item
			if (temp.next == null) {
				if (temp.data.getNamXuatBan() == namXuatBan && temp.data.getNhaSuatBan().equals(nhaXuatBan)) {
					danhSachSach.add(temp.data);
				}
			}
		}
		return danhSachSach;
	}

	public static int soLuongSachCuaTacGia(CustomLinkedList customLinkedList, String tenTacGia) {
		int count = 0;
		Node<Sach> temp = customLinkedList.head;

		while (temp.next != null) {
			if (kiemTraTacGiaTonTai(temp.data, tenTacGia)) {
				count++;
			}

			temp = temp.next;

			// last item
			if (temp.next == null) {
				if (kiemTraTacGiaTonTai(temp.data, tenTacGia)) {
					count++;
				}
			}

		}
		return count;
	}

	private static boolean kiemTraTacGiaTonTai(Sach sach, String tenTacGia) {
		if (sach != null) {
			String[] teamTacGia = sach.getTacGia();
			for (int i = 0; i < teamTacGia.length; i++) {
				if (teamTacGia[i].toUpperCase().equals(tenTacGia.toUpperCase())) {
					return true;
				}
			}
		}
		return false;
	}
}
