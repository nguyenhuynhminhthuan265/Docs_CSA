package com.cybersoft.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cybersoft.model.dto.LuaChon;
import com.cybersoft.model.entity.CauHoi;
import com.cybersoft.model.entity.DiemThi;
import com.cybersoft.model.entity.LopHoc;
import com.cybersoft.model.entity.MonHoc;
import com.cybersoft.model.entity.SinhVien;
import com.cybersoft.node.BSTCauHoi;
import com.cybersoft.node.NodeMonHoc;
import com.cybersoft.node.NodeSinhVien;
import com.cybersoft.node.generic.Node;

public class TruongHoc {
	NodeMonHoc dsMonHoc;
	List<LopHoc> dsLopHoc;
	BSTCauHoi dsCauHoi;
	NodeSinhVien dsSinhVienToanTruong;
	static List<Integer> used = new ArrayList<>();

	public TruongHoc() {
		dsMonHoc = new NodeMonHoc();
		dsLopHoc = new ArrayList<LopHoc>();
		dsCauHoi = new BSTCauHoi();
		dsSinhVienToanTruong = new NodeSinhVien();
	}

	public NodeMonHoc generateMonHoc() {

		dsMonHoc.insert(new MonHoc(1, "Toán"));
		dsMonHoc.insert(new MonHoc(2, "Lý"));
		dsMonHoc.insert(new MonHoc(3, "Hóa"));
		dsMonHoc.insert(new MonHoc(4, "Anh Văn"));

		return dsMonHoc;
	}

	public List<LopHoc> generateLopHoc() {

		dsLopHoc.add(new LopHoc(1, "Lop A"));
		dsLopHoc.add(new LopHoc(2, "Lop B"));
		dsLopHoc.add(new LopHoc(3, "Lop C"));
		dsLopHoc.add(new LopHoc(4, "Lop D"));
		dsLopHoc.add(new LopHoc(5, "Lop E"));

		return dsLopHoc;
	}

	public BSTCauHoi generateCauHoi() {
		BSTCauHoi bstCauHoi = new BSTCauHoi();
		List<LuaChon> list = new ArrayList<LuaChon>();
		list.add(new LuaChon("A", "CAU TRA LOI A"));
		list.add(new LuaChon("B", "CAU TRA LOI B"));
		list.add(new LuaChon("C", "CAU TRA LOI C"));
		list.add(new LuaChon("D", "CAU TRA LOI D"));
		CauHoi cauHoi1 = new CauHoi(generateID(), 4, "Cau hoi 1", list, list.get(0));
		CauHoi cauHoi2 = new CauHoi(generateID(), 4, "Cau hoi 2", list, list.get(1));
		CauHoi cauHoi3 = new CauHoi(generateID(), 4, "Cau hoi 3", list, list.get(2));
		CauHoi cauHoi4 = new CauHoi(generateID(), 4, "Cau hoi 4", list, list.get(3));
		CauHoi cauHoi5 = new CauHoi(generateID(), 4, "Cau hoi 5", list, list.get(0));
		CauHoi cauHoi6 = new CauHoi(generateID(), 4, "Cau hoi 6", list, list.get(1));
		bstCauHoi.insert(cauHoi1);
		bstCauHoi.insert(cauHoi2);
		bstCauHoi.insert(cauHoi3);
		bstCauHoi.insert(cauHoi4);
		bstCauHoi.insert(cauHoi5);
		bstCauHoi.insert(cauHoi6);

		CauHoi cauHoi7 = new CauHoi(generateID(), 3, "Cau hoi 1", list, list.get(2));
		CauHoi cauHoi8 = new CauHoi(generateID(), 3, "Cau hoi 2", list, list.get(3));
		CauHoi cauHoi9 = new CauHoi(generateID(), 3, "Cau hoi 3", list, list.get(0));
		CauHoi cauHoi10 = new CauHoi(generateID(), 3, "Cau hoi 4", list, list.get(1));
		CauHoi cauHoi11 = new CauHoi(generateID(), 3, "Cau hoi 5", list, list.get(2));
		CauHoi cauHoi12 = new CauHoi(generateID(), 3, "Cau hoi 6", list, list.get(3));
		bstCauHoi.insert(cauHoi7);
		bstCauHoi.insert(cauHoi8);
		bstCauHoi.insert(cauHoi9);
		bstCauHoi.insert(cauHoi10);
		bstCauHoi.insert(cauHoi11);
		bstCauHoi.insert(cauHoi12);

		capNhatCauHoiMonHoc(cauHoi1);
		capNhatCauHoiMonHoc(cauHoi2);
		capNhatCauHoiMonHoc(cauHoi3);
		capNhatCauHoiMonHoc(cauHoi4);
		capNhatCauHoiMonHoc(cauHoi5);
		capNhatCauHoiMonHoc(cauHoi6);
		capNhatCauHoiMonHoc(cauHoi7);
		capNhatCauHoiMonHoc(cauHoi8);
		capNhatCauHoiMonHoc(cauHoi9);
		capNhatCauHoiMonHoc(cauHoi10);
		capNhatCauHoiMonHoc(cauHoi11);
		capNhatCauHoiMonHoc(cauHoi12);

		return bstCauHoi;

	}

	public void capNhatDiemSinhVien(int maSV, DiemThi diemThi) {
		SinhVien sinhVien = this.findByUsername(maSV);
		if (sinhVien != null) {
			sinhVien.getDsDiemThi().insert(diemThi);
		}
		
	}

	private void capNhatCauHoiMonHoc(CauHoi cauHoi) {

		Node<MonHoc> temp = dsMonHoc.head;

		while (temp.next != null) {
			if (temp.data.getMaMH() == cauHoi.getMaMH()) {
				temp.data.getIdCauHoi().add(cauHoi.getId());
			}
			temp = temp.next;
			if (temp.next == null) {
				if (temp.data.getMaMH() == cauHoi.getMaMH()) {
					temp.data.getIdCauHoi().add(cauHoi.getId());
				}
			}
		}

	}

	public LopHoc findByMaLop(int maLop) {
		for (LopHoc lopHoc : dsLopHoc) {
			if (lopHoc.getMaLop() == maLop) {
				return lopHoc;
			}
		}

		return null;
	}

	public List<CauHoi> danhSachCauHoiTheoMonHoc(int maMonHoc) {
		List<CauHoi> list = new ArrayList<CauHoi>();
		MonHoc monHoc = this.findByMonHoc(maMonHoc);
		if (monHoc != null) {
			if (!monHoc.getIdCauHoi().isEmpty()) {
				for (int i = 0; i < monHoc.getIdCauHoi().size(); i++) {
					list.add(this.dsCauHoi.search(monHoc.getIdCauHoi().get(i)));
				}
			}

		}

		return list;
	}

	public MonHoc findByMonHoc(int maMonHoc) {
		Node<MonHoc> temp = dsMonHoc.head;
		MonHoc item;
		while (temp.next != null) {

			if (temp.data.getMaMH() == maMonHoc) {
				return temp.data;
			}
			temp = temp.next;
			if (temp.next == null) {

				if (temp.data.getMaMH() == maMonHoc) {
					return temp.data;
				}
			}
		}

		return null;
	}

	public MonHoc findByMonHoc(MonHoc monHoc) {
		Node<MonHoc> temp = dsMonHoc.head;
		MonHoc item;
		while (temp.next != null) {
			item = new MonHoc(temp.data.getMaMH(), temp.data.getTenMH());
			if (item.getMaMH() == monHoc.getMaMH()
					|| item.getTenMH().trim().toUpperCase().equals(monHoc.getTenMH().trim().toUpperCase())) {
				return item;
			}
			temp = temp.next;
			if (temp.next == null) {
				item = new MonHoc(temp.data.getMaMH(), temp.data.getTenMH());
				if (item.getMaMH() == monHoc.getMaMH()
						|| item.getTenMH().trim().toUpperCase().equals(monHoc.getTenMH().trim().toUpperCase())) {
					return item;
				}
			}
		}

		return null;
	}

	public SinhVien findByUsername(int maSV) {
		Node<SinhVien> currentNode = dsSinhVienToanTruong.head;
		if (currentNode == null) {
			System.out.println("Truong chua co ds sinh vien");
		} else {
			while (currentNode != null) {
				if (currentNode.data.getMaSV() == maSV) {
					return currentNode.data;
				}
				currentNode = currentNode.next;
			}
		}
		return null;
	}

	public static int generateID() {

		Random randomGenerator = new Random();
		boolean generating = true;
		int counting = 0;
		int upperbound = 100;
		while (generating) {
			int testNum = randomGenerator.nextInt(upperbound) + 1;
			if (!used.contains(testNum)) {
				used.add(testNum);
				counting++;
//				System.out.println(testNum);
				return testNum;
			}
			if (counting >= upperbound) {
//				generating = false;
				upperbound *= 2;
			}
		}

		return -1;
	}
}
