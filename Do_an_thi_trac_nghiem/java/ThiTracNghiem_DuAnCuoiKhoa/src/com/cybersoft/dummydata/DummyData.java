package com.cybersoft.dummydata;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.model.entity.CauHoi;
import com.cybersoft.model.entity.LopHoc;
import com.cybersoft.model.entity.MonHoc;
import com.cybersoft.node.BSTCauHoi;
import com.cybersoft.node.NodeMonHoc;

public class DummyData {
	public NodeMonHoc generateMonHoc() {
		NodeMonHoc dsMonHoc = new NodeMonHoc();

		dsMonHoc.insert(new MonHoc(1, "Toán"));
		dsMonHoc.insert(new MonHoc(2, "Lý"));
		dsMonHoc.insert(new MonHoc(3, "Hóa"));
		dsMonHoc.insert(new MonHoc(4, "Anh Văn"));

		return dsMonHoc;
	}

	public List<LopHoc> generateLopHoc() {

		List<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
		dsLopHoc.add(new LopHoc(1, "Lop A"));
		dsLopHoc.add(new LopHoc(2, "Lop B"));
		dsLopHoc.add(new LopHoc(3, "Lop C"));
		dsLopHoc.add(new LopHoc(4, "Lop D"));
		dsLopHoc.add(new LopHoc(5, "Lop E"));

		return dsLopHoc;
	}

	public BSTCauHoi generateCauHoi() {
		BSTCauHoi bstCauHoi = new BSTCauHoi();
		CauHoi cauHoi1 = new CauHoi(4, "Cau hoi 1");
		CauHoi cauHoi2 = new CauHoi(4, "Cau hoi 2");
		CauHoi cauHoi3 = new CauHoi(4, "Cau hoi 3");
		CauHoi cauHoi4 = new CauHoi(4, "Cau hoi 4");
		CauHoi cauHoi5 = new CauHoi(4, "Cau hoi 5");
		CauHoi cauHoi6 = new CauHoi(4, "Cau hoi 6");
		bstCauHoi.insert(cauHoi1);
		bstCauHoi.insert(cauHoi2);
		bstCauHoi.insert(cauHoi3);
		bstCauHoi.insert(cauHoi4);
		bstCauHoi.insert(cauHoi5);
		bstCauHoi.insert(cauHoi6);

		CauHoi cauHoi7 = new CauHoi(3, "Cau hoi 1");
		CauHoi cauHoi8 = new CauHoi(3, "Cau hoi 2");
		CauHoi cauHoi9 = new CauHoi(3, "Cau hoi 3");
		CauHoi cauHoi10 = new CauHoi(3, "Cau hoi 4");
		CauHoi cauHoi11 = new CauHoi(3, "Cau hoi 5");
		CauHoi cauHoi12 = new CauHoi(3, "Cau hoi 6");
		bstCauHoi.insert(cauHoi7);
		bstCauHoi.insert(cauHoi8);
		bstCauHoi.insert(cauHoi9);
		bstCauHoi.insert(cauHoi10);
		bstCauHoi.insert(cauHoi11);
		bstCauHoi.insert(cauHoi12);

		return bstCauHoi;

	}
}
