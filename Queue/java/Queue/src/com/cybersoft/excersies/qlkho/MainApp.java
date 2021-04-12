package com.cybersoft.excersies.qlkho;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		KhoHang khoHang;
		int option;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng hàng kho có thể chứa: ");
		khoHang = new KhoHang(Integer.parseInt(sc.nextLine()));

		do {
			System.out.println("======================QL KHO HÀNG======================");
			System.out.println("1: Nhập 1 mặt hàng");
			System.out.println("2: Xuất một mặt hàng");
			System.out.println("3: Xem mặt hàng chuẩn bị xuất");
			System.out.println("4: Xem mặt hàng mới nhập");
			System.out.println("5: Xem các mặt hàng còn trong kho");
			System.out.println("0: THOÁT");
			System.out.print("Option: ");
			option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				khoHang.enqueue(new MatHang().input());
				break;
			case 2:
				if (khoHang.dequeue() != null) {
					System.out.println("Xuất hàng thành công");
				} else {
					System.out.println("Không có hàng");
				}

				break;
			case 3:
				System.out.println(khoHang.peek().toString());
				break;
			case 4:
				System.out.println(
						khoHang.getNewItemPushed() != null ? khoHang.getNewItemPushed().toString() : "KHONG CO HANG");
				break;
			case 5:
				khoHang.print();
				break;

			default:
				break;
			}

		} while (option != 0);

	}
}
