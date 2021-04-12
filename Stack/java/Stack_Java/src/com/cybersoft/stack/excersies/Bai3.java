package com.cybersoft.stack.excersies;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Mô phỏng lại chương trình Reopen lại các tab đã đóng trên trình duyệt
 * vd: chúng ta đang mở các tab: Tab 0, Tab 1, Tab 2, Tab 3
 * Xóa 1 tab bất kỳ
 * Dùng các option từ bàn phím để mô phỏng lại Reopen tab đã đóng (vd: ấn -1 -> Reopen)
 * 
 * */
public class Bai3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> tabs = new LinkedList<String>();
		MyStack<Tab> stackTabClosed = new MyStack<Tab>();

		System.out.println(stackTabClosed.isEmpty());
		int option, indexTabClosed;

		tabs.add("tab 0");
		tabs.add("tab 1");
		tabs.add("tab 2");
		tabs.add("tab 3");
		tabs.add("tab 4");
		tabs.add("tab 5");
		tabs.add("tab 6");

//		0 : Xóa tab
//		-1: Reopen lại tab vừa đóng
		System.out.println(tabs);
		do {
			System.out.println("Xóa tab: 0\tReopen tab: -1");
			System.out.print("option: ");
			option = Integer.parseInt(sc.nextLine());
			if (option != 0 && option != -1) {
				break;
			}
			if (option == 0) {
				System.out.print("index tab cần xóa: ");
				indexTabClosed = Integer.parseInt(sc.nextLine());
				stackTabClosed.push(new Tab(indexTabClosed, tabs.get(indexTabClosed)));
				tabs.remove(indexTabClosed);
				System.out.println(tabs);
			} else if (option == -1) {
				tabs.add(stackTabClosed.peek().getIndex(), stackTabClosed.pop().getName());
				System.out.println(tabs);
			}

		} while (option == 0 || option == -1);

	}

}
