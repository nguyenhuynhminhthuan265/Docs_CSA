#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;
struct NODE {
	string iKey;
	NODE* pLeft;
	NODE* pRight;
};

void Init(NODE*&TREE) {
	TREE = NULL;
}
static int countLeft = 0;
static int countRight = 0;
void Insert(NODE *&pRoot, string x) {
	
	if (pRoot == NULL) {
		NODE *q;
		q = new NODE;
		q->iKey = x;
		q->pLeft = q->pRight = NULL;
		pRoot = q;
	}
	else {

		if (x <= pRoot->iKey) {
			Insert(pRoot->pLeft, x);
			countLeft++;
		}
		else if (x >= pRoot->iKey) {
			Insert(pRoot->pRight, x);
			countRight++;
		}

	}

}
string ChuanHoaChuoi(string str) {
	int n = str.length();
	char *s = new char[str.size() + 1];
	strcpy(s, str.c_str());


	for (int i = 0; i<n; i++)
	{
		if ((s[i] == ' ') && (s[i + 1] == ' '))
		{
			
			for (int j = i; j<n; j++)
			{
				s[j] = s[j + 1];
			}
			n--;	
			i--;	
		}
	}
	str = s;
	return str+" ";
}
void CreateTree(NODE*&pRoot) {
	string Data;
	string temp;

	cout << "Nhap vao du lieu: " << endl;
	getline(cin, Data);
	Data = ChuanHoaChuoi(Data);
	for (int i = 0; Data.length()>1; i++) {
		temp = Data.substr(0, Data.find(" "));
		Data = Data.substr(Data.find(" ") + 1, Data.length() - Data.find(" "));
		Insert(pRoot, temp);
	}

	
}

void NLR(NODE *pTree) {
	if (pTree != NULL) {
		cout << pTree->iKey;
		NLR(pTree->pLeft);
		NLR(pTree->pRight);
	}
}

NODE* Search(NODE* pRoot, string x) {
	if (pRoot == NULL || pRoot->iKey == x)
		return pRoot;

	
	if (pRoot->iKey < x)
		return Search(pRoot->pRight, x);

	
	return Search(pRoot->pLeft, x);
}

int Height(NODE *pNode) {
	if (pNode == NULL) {
		return 0;
	}
	int HL, HR;
	HL = Height(pNode->pLeft);
	HR = Height(pNode->pRight);
	if (HL > HR) {
		return (1 + HL);
	}
	return (1 + HR);
}
void SearchStandFor(NODE* &Tree, NODE *&q) {
	if (Tree->pRight) {
		SearchStandFor(Tree->pRight, q);
	}
	else {
		q->iKey = Tree->iKey;
		q = Tree;
		Tree = Tree->pLeft;
	}
}

void RemoveNode(NODE *&Tree, string x) {
	NODE *p;
	if (Tree = NULL) {
		cout << x << " khong co trong cay" << endl;
	}
	else {
		if (x < Tree->iKey) {
			RemoveNode(Tree->pLeft, x);
		}
		else {
			if (x > Tree->iKey) {
				RemoveNode(Tree->pLeft, x);
			}
			else {
				p = Tree;
				if (p->pRight == NULL) {
					Tree = p->pLeft;
				}
				else {
					if (p->pLeft == NULL) {
						Tree = p->pRight;
					}
					else {
						SearchStandFor(Tree->pLeft, p);
					}
					delete p;
				}
			}
		}
	}
}

 int soLuong = 0;
int ThongKe(NODE *pRoot, string x) {
	
	 NODE *p;
	 p = Search(pRoot, x);
	if (p != NULL) {
		
			soLuong++;
			ThongKe(p->pLeft, x);
			ThongKe(p->pRight, x);
	}

	return soLuong;
}

string *SwapString(NODE *pTree) {
	static string str[100];
	static int i = 0;
	if (pTree != NULL) {
		str[i++]= pTree->iKey;
		SwapString(pTree->pLeft);
		SwapString(pTree->pRight);
	}
	return str;
}
int lengthString(NODE *pTree) {
	static string str[100];
	static int i = 0;
	if (pTree != NULL) {
		str[i++] = pTree->iKey;
		lengthString(pTree->pLeft);
		lengthString(pTree->pRight);
	}
	return i;
}
void ChuanHoaMang(string *a, int &n) {
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (a[i] == a[j]) {
				for (int k = j; k < n; k++) {
					a[k] = a[k + 1];
				}
				n--;
				j--;
			}
			
		}
	}

}
void main() {
	NODE *pTree, *p;
	/*string check="div   thuan minh  tuan      lon   ",x;
	check=ChuanHoaChuoi(check);
	
	cout << check << endl;*/
	Init(pTree);
	CreateTree(pTree);
	NLR(pTree);
	
	
	string *str = SwapString(pTree);
	
	int len = lengthString(pTree);
	ChuanHoaMang(str, len);
	for (int j = 0; j < len; j++) {
		

		cout << endl << str[j] << ": " << ThongKe(pTree, str[j]) << endl;
		soLuong = 0;
	}
	
	system("pause");
}