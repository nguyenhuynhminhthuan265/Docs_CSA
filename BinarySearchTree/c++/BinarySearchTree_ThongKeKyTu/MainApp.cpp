#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;
struct NODE {
	char iKey;
	NODE* pLeft;
	NODE* pRight;
};

void Init(NODE*&TREE) {
	TREE = NULL;
}
static int countLeft = 0;
static int countRight = 0;
void Insert(NODE *&pRoot, char x) {

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
		else if (x > pRoot->iKey) {
			Insert(pRoot->pRight, x);
			countRight++;
		}

	}

}
void CreateTree(NODE*&pRoot) {
	string Data;

	cout << "Nhap vao du lieu : " << endl;
	getline(cin, Data);
	for (int i = 0; i < Data.length(); i++) {
		Insert(pRoot, Data[i]);
	}


}

void NLR(NODE *pTree) {
	if (pTree != NULL) {
		cout << pTree->iKey;
		NLR(pTree->pLeft);
		NLR(pTree->pRight);
	}
}

NODE* Search(NODE* pRoot, char x) {
	if (pRoot == NULL) {
		return NULL;
	}
	if (x < pRoot->iKey) {
		Search(pRoot->pLeft, x);
	}
	else {

		if (x > pRoot->iKey) {
			Search(pRoot->pRight, x);
		}
		else {
			// Ghi chú: Trong trường hợp pRoot-> key== x thì return pRoot
			return pRoot;
		}
	}
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

void RemoveNode(NODE *&Tree, char x) {
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



int iDem = 0;
int CountCharOfParagraph(NODE* pRoot, char check) {


	NODE *p = Search(pRoot, check);
	if (p != NULL) {

		iDem++;

		CountCharOfParagraph(p->pLeft, check);
		CountCharOfParagraph(p->pRight, check);
	}


	return iDem;


}
char *SwapChar(NODE *pTree) {
	static char c[100];
	static int i = 0;
	if (pTree != NULL) {
		c[i++] = pTree->iKey;
		SwapChar(pTree->pLeft);
		SwapChar(pTree->pRight);
	}
	return c;
}
int lengthChar(NODE *pTree) {
	static char c[100];
	static int i = 0;
	if (pTree != NULL) {
		c[i++] = pTree->iKey;
		lengthChar(pTree->pLeft);
		lengthChar(pTree->pRight);
	}
	return i;
}
void ChuanHoaMang(char a[], int &n) {
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
void CountEachCharOfParagraph(NODE *pRoot, char *c, int len) {

	for (int j = 0; j < len; j++) {


		cout << endl << c[j] << ": " << CountCharOfParagraph(pRoot, c[j]) << endl;
		iDem = 0;
	}
}
void main() {
	NODE *pTree, *p;
	char x, check;
	Init(pTree);
	CreateTree(pTree);
	NLR(pTree);

	char *c = SwapChar(pTree);
	
	int len = lengthChar(pTree);
	ChuanHoaMang(c, len);
	CountEachCharOfParagraph(pTree, c, len);
	cout << endl << "Nhap ky tu can kiem tra: ";
	cin >> check;
	cout << check << ": " << CountCharOfParagraph(pTree, check) << endl;
	system("pause");
}