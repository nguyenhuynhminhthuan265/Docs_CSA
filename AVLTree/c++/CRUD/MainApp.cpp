#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <conio.h>
#include <string>
using namespace std;
struct TuDien {
	string mean;
	string vocab;
};
struct AVLNODE {
	TuDien iKey;
	int bal;
	AVLNODE* pLeft;
	AVLNODE* pRight;
	int height;

};


AVLNODE* CreateNode(TuDien Data) {
	AVLNODE* pNode;
	pNode = new AVLNODE;
	if (pNode == NULL) {
		return NULL;
	}
	pNode->iKey = Data;
	pNode->pLeft = NULL;
	pNode->pRight = NULL;
	pNode->bal = 0;
	return pNode;
}


AVLNODE* LeftRotate(AVLNODE*& P) {
	AVLNODE* Q;
	Q = P->pRight;
	P->pRight = Q->pLeft;
	Q->pLeft = P;
	P = Q;
	return Q;
}

AVLNODE* RightRotate(AVLNODE*& P) {
	AVLNODE* Q;
	Q = P->pLeft;
	P->pLeft = Q->pRight;
	Q->pRight = P;
	P = Q;
	return Q;
}

void LeftBalance(AVLNODE*& P)
{
	switch (P->pLeft->bal) {
	case 1: //mất cân bằng trái trái
		RightRotate(P);
		P->bal = 0;
		P->pRight->bal = 0;
		break;
	case 2: //Ghi chú: cho biết đây là trường hợp mất cân bằng nào?
		LeftRotate(P->pLeft);
		RightRotate(P);
		switch (P->bal) {
		case 0:
			P->pLeft->bal = 0;
			P->pRight->bal = 0;
			break;
		case 1:
			P->pLeft->bal = 0;
			P->pRight->bal = 2;
			break;
		case 2:
			P->pLeft->bal = 1;
			P->pRight->bal = 0;
			break;
		} P
			->bal = 0;
		break;
	}
}

void RightBalance(AVLNODE*& P)
{
	switch (P->pRight->bal) {
	case 1: //Ghi chú: cho biết đây là trường hợp mất cân bằng nào?
		RightRotate(P->pRight);
		LeftRotate(P);
		switch (P->bal) {
		case 0:
			P->pLeft->bal = 0;
			P->pRight->bal = 0;
			break;
		case 1:
			P->pLeft->bal = 1;
			P->pRight->bal = 0;
			break;
		case 2:
			P->pLeft->bal = 0;
			P->pRight->bal = 2;
			break;
		} P
			->bal = 0;
		break;
	case 2: //Ghi chú: cho biết đây là trường hợp mất cân bằng nào?
		LeftRotate(P);
		P->bal = 0;
		P->pLeft->bal = 0;
		break;
	}
}
int InsertNode(AVLNODE*& tree, TuDien x)
{
	int res;
	if (tree == NULL) {
		tree = CreateNode(x);
		if (tree == NULL) {
			return -1;
		}
		return 2;
	}
	else {
		if (tree->iKey.vocab == x.vocab) {
			return 0; //khóa này đã tồn tại trong cây
		}
		else if (tree->iKey.vocab > x.vocab) {
			res = InsertNode(tree->pLeft, x);
			if (res < 2) {
				return res;
			}
			switch (tree->bal) {

			case 0:
				tree->bal = 1;
				return 2;
			case 1:
				LeftBalance(tree);
				return 1;
			case 2:
				tree->bal = 0;
				return 1;
			}
		}
		else {
			res = InsertNode(tree->pRight, x);
			if (res < 2) {
				return res;
			}
			switch (tree->bal) {
			case 0:
				tree->bal = 2;
				return 2;
			case 1:
				tree->bal = 0;
				return 1;
			case 2:
				RightBalance(tree);
				return 1;
			}
		}
	}
}
void Traverse(AVLNODE* t)
{
	if (t != NULL)
	{
		Traverse(t->pLeft);
		cout << "Khoa: " << t->iKey.vocab << ": " << t->iKey.mean << ", can bang: " << t->bal << endl;
		Traverse(t->pRight);
	}
}
void RemoveAll(AVLNODE*& t)
{
	if (t != NULL) {
		RemoveAll(t->pLeft);
		RemoveAll(t->pRight);
		delete t;
	}
}
static int soPhepSoSanh = 0;
AVLNODE* Search(AVLNODE* pRoot, TuDien x) {
	if (pRoot == NULL || pRoot->iKey.vocab == x.vocab)
		return pRoot;


	if (pRoot->iKey.vocab < x.vocab)
		return Search(pRoot->pRight, x);


	return Search(pRoot->pLeft, x);
}

string ChuanHoaChuoi(string str) {
	int n = str.length();
	char* s = new char[str.size() + 1];
	strcpy(s, str.c_str());


	for (int i = 0; i < n; i++)
	{
		if ((s[i] == ' ') && (s[i + 1] == ' '))
		{

			for (int j = i; j < n; j++)
			{
				s[j] = s[j + 1];
			}
			n--;
			i--;
		}
	}
	str = s;
	return str + " ";
}

//int soLuong = 0;
//int ThongKe(AVLNODE *pRoot, TuDien x) {
//
//	AVLNODE *p;
//	p = Search(pRoot, x);
//	if (p != NULL) {
//
//		soLuong++;
//		ThongKe(p->pLeft, x);
//		ThongKe(p->pRight, x);
//	}
//
//	return soLuong;
//}
//
//string *SwapString(AVLNODE *pTree) {
//	static string str[100];
//	static int i = 0;
//	if (pTree != NULL) {
//		str[i++] = pTree->iKey;
//		SwapString(pTree->pLeft);
//		SwapString(pTree->pRight);
//	}
//	return str;
//}
//int lengthString(AVLNODE *pTree) {
//	static string str[100];
//	static int i = 0;
//	if (pTree != NULL) {
//		str[i++] = pTree->iKey;
//		lengthString(pTree->pLeft);
//		lengthString(pTree->pRight);
//	}
//	return i;
//}
//void ChuanHoaMang(string *a, int &n) {
//	for (int i = 0; i < n; i++) {
//		for (int j = i + 1; j < n; j++) {
//			if (a[i] == a[j]) {
//				for (int k = j; k < n; k++) {
//					a[k] = a[k + 1];
//				}
//				n--;
//				j--;
//			}
//
//		}
//	}
//
//}
void CreateTree(AVLNODE*& pRoot) {
	TuDien Data;
	//TuDien temp;
	freopen("D:\\Cybersoft_Mentor\\Uu_tien\\CplusPlus_AVL\\folder_file\\TuDien.txt", "rt", stdin);
	string temp1;
	while (getline(cin, temp1)) {
		temp1 = ChuanHoaChuoi(temp1);
		Data.vocab = temp1.substr(0, temp1.find(" "));
		Data.mean = temp1.substr(temp1.find(" ") + 1, temp1.length() - temp1.find(" "));
		InsertNode(pRoot, Data);

	}




}

void main()
{
	AVLNODE* tree, * p;
	TuDien x;
	string b;
	tree = NULL;
	CreateTree(tree);
	cout << endl << "Cay AVL vua tao: " << endl;
	Traverse(tree);
	cin.ignore();
	cout << "Tu tieng Anh ban muon search: " << endl;
	getline(cin, b);
	p = Search(tree, x);
	if (p != NULL) {
		cout << x.vocab << ": " << p->iKey.mean << endl;
	}
	RemoveAll(tree);


	_getch();
}