package com.lanou;

import java.util.Random;
import java.util.Scanner;

public class Regiest {
 /**
 * @param args
 */
public static void main(String[] args) {
	 //�洢�û���Ϣ
	String[][] users = new String[100][2];
	//��������
	int[] end = {1,2,3,4,5,6,7};
	//�����ע������
	int[][] allLottery = new int[5][7];
	//������¼�Ƿ��½�ɹ�
	boolean isLogin = false;
	//�ӿ���̨���빤��
	Scanner sc = new Scanner(System.in);
	//�����
	Random random = new Random();
	//�˳�
	boolean isLoop = true;
	
	//�ж��Ƿ�ע��
	boolean isRegiest = true;
	System.out.println("---------------------------��ӭ���� һ������  ������!-----------------------");
		while (isLoop) {
			System.out.println("1.ע��");
			System.out.println("2.��½");
			System.out.println("3.��ѡ");
			System.out.println("4.��ѡ");
			System.out.println("5.�鿴�������");
			System.out.println("6.����");
			System.out.println("7.�˳�");
			System.out.println("��ѡ��");
			int choose = sc.nextInt();
		
			switch (choose) {
			case 1:
				isRegiest = true;
				String name = null; String password=null;
				//ע��
				while(isRegiest) {
					System.out.println("�������˺�:");
					name = sc.next();
					System.out.println("����������:");
					password = sc.next();
					//1.�ж��Ƿ��Ѿ�ע���
					for (int i = 0; i < users.length; i++) {
						if (users[i][0]!=null && users[i][1].equals(name)) {
							System.out.println("�û����Ѵ���");
							isRegiest = true;
							break;
						}else {
							isRegiest = false;
						}
				}
				}	
				System.out.println("ע��ɹ�");
				//2.�������˺ź�����
				for (int i = 0; i < users.length; i++) {
					if (users[i][0]==null) {
						users[i][0] = name;
						users[i][1] = password;
						break;
					}
				}
				
			
				break;
			case 2:
				if (isRegiest==true) {
					System.out.println("��ע��");
					break;
				}
				isLogin = false;
				//��¼
				while(!isLogin) {
					System.out.println("�������˺�");
					name = sc.next();
					System.out.println("����������");
					password = sc.next();
					for (int i = 0; i < users.length; i++) {
						if (users[i][0]!=null && users[i][0].equals(name) && users[i][1].equals(password)) {
							System.out.println("��¼�ɹ�");
							isLogin = true;
							break;
						}
					}	
					if (isLogin==false) {
						System.out.println("�������");
					}
				}
				break;
			case 3:
				//��ѡ
				//�ж��Ƿ��¼
				if (isLogin==false) {
					System.out.println("���ȵ�¼");
					break;
				}
				//���빺��ע��
				System.out.println("������Ҫ�����ע��");
				int count = sc.nextInt();
				for (int i = 0; i < count; i++) {
					//�����ɵ�ע
					int[] one = new int[7];  //���浥ע
					
					//6�λ��� i--�ص��ϴ�ѭ��
					for (int j = 0; j <6; j++) {
						boolean isExits = false;
						int t = random.nextInt(33)+1;
						//�ж�  t����������  ˫��ѭ�����õ�boolean, �������Ǹ�ԭ�����ĳ�ʼֵ
						for (int k = 0; k < 6; k++) {
							if (t==one[k]) {
								isExits =true;
								break;
							}
						}
						if (isExits==false) {
							one[j] = t;
						}else {
							j--;
						}
					}
					//���������
					one[6] = random.nextInt(16)+1;
					//ð������
					for (int j = 0; j < 6; j++) {
						for (int k = 0; k < 6-j-1; k++) {
							if (one[k]>one[k+1]) {
								int temp=one[k];
								one[k] = one[k+1];
								one[k+1]=temp;
							}
						}
					}

					//�����λ����
					for (int j = 0; j < 5; j++) {
						if (allLottery[j][0]==0) {
							for (int k = 0; k <7; k++) {
								allLottery[j][k] = one[k];
							}
							break;
						}
						
					}
					
				}
				break;
			case 4:
				//�ж��Ƿ��¼
				/*if (isLogin==false) {
					System.out.println("���ȵ�¼");
					break;
				}*/
				//��ѡ

					//�����ɵ�ע
					int[] one = new int[7];  //���浥ע
					boolean isExits = false;
					
					//��һ���жϣ� ��Χ1-33
					for (int j = 0; j <6; j++) {
						System.out.println("���������6��������");
						int t = sc.nextInt();
						int temp = t;
						if (t>33 || t<1) {
							System.out.println("���볬����Χ,������1-33֮�������");
							j--;
							continue;
						}
					
						//�ж�  t����������
						for (int k = 0; k < 6; k++) {
							if (t==one[k]) {
								isExits =true;
								break;
							}
						}
						if (isExits==false) {
							one[j] = t;
						}else {
							j--;
						}
					}
					//���������
					System.out.println("������1ע����ע��");
					one[6] = sc.nextInt();
					while(one[6]>16 || one[6]<1) {
						System.out.println("��������,��Χ��[1-16]֮��");
						System.out.println("����������");
						one[6] = sc.nextInt();
					}

					//ð������
					for (int j = 0; j < 6; j++) {
						for (int k = 0; k < 6-j-1; k++) {
							if (one[k]>one[k+1]) {
								int temp=one[k];
								one[k] = one[k+1];
								one[k+1]=temp;
							}
						}
					}

					//�����λ����
					for (int j = 0; j < 5; j++) {
						if (allLottery[j][0]==0) {
							for (int k = 0; k <7; k++) {
								allLottery[j][k] = one[k];
							}
							break;
						}
					}
				
				break;	
			case 5:
				if (isLogin==false) {
					System.out.println("���ȵ�¼");
					break;
				}
				//�鿴��ѡ����
				for (int i = 0; i < 5; i++) {
					if (allLottery[i][0]!=0) {
					for (int j = 0; j < 7; j++) {
						if (allLottery[i][j]<10) {
							System.out.print("0"+allLottery[i][j]+" ");
						}else {
						System.out.print(allLottery[i][j]+" ");
					}}
					System.out.println();
					}
					
				}
				break;
			case 6:
				//����
				
				for (int i = 0; i < 5; i++) {
					int counts = 0;
					for (int j = 0; j < 7; j++) {
						for (int k = 0; k < 7; k++) {
							if (allLottery[i][j]==end[k]) {
								counts++;
							}
						}
					}

					//�ж��Ƿ��н�
					if (counts>=3) {
						switch (counts) {
						case 7:
							System.out.println("��"+(i+1)+"ע"+"�صȽ�");
							break;
						case 6:
							System.out.println("��"+(i+1)+"ע"+"һ�Ƚ�");
							break;
						case 5:
							System.out.println("��"+(i+1)+"ע"+"���Ƚ�");
							break;
						case 4:
							System.out.println("��"+(i+1)+"ע"+"���Ƚ�");
							break;
						case 2:
							System.out.println("��"+(i+1)+"ע"+"������");
							break;
							default:
								System.out.println("��"+(i+1)+"ע  û�н�Ŷ");
								break;
						}
					}else {
						System.out.println("�´οɶ����н�");
					}
				}
				break;
			case 7:
				//�˳�
				isLoop = false;
				System.out.println("�ؼ�ȡǮ��! �¸������̾�����!!!");
				break;
			}
	}
}
}
