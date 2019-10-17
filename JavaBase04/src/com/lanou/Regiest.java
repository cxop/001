package com.lanou;

import java.util.Random;
import java.util.Scanner;

public class Regiest {
 /**
 * @param args
 */
public static void main(String[] args) {
	 //存储用户信息
	String[][] users = new String[100][2];
	//开奖号码
	int[] end = {1,2,3,4,5,6,7};
	//储存多注的数组
	int[][] allLottery = new int[5][7];
	//用来记录是否登陆成功
	boolean isLogin = false;
	//从控制台输入工具
	Scanner sc = new Scanner(System.in);
	//随机数
	Random random = new Random();
	//退出
	boolean isLoop = true;
	
	//判断是否注册
	boolean isRegiest = true;
	System.out.println("---------------------------欢迎来到 一念天堂  购购乐!-----------------------");
		while (isLoop) {
			System.out.println("1.注册");
			System.out.println("2.登陆");
			System.out.println("3.机选");
			System.out.println("4.手选");
			System.out.println("5.查看开奖结果");
			System.out.println("6.开奖");
			System.out.println("7.退出");
			System.out.println("请选择");
			int choose = sc.nextInt();
		
			switch (choose) {
			case 1:
				isRegiest = true;
				String name = null; String password=null;
				//注册
				while(isRegiest) {
					System.out.println("请输入账号:");
					name = sc.next();
					System.out.println("请输入密码:");
					password = sc.next();
					//1.判断是否已经注册过
					for (int i = 0; i < users.length; i++) {
						if (users[i][0]!=null && users[i][1].equals(name)) {
							System.out.println("用户名已存在");
							isRegiest = true;
							break;
						}else {
							isRegiest = false;
						}
				}
				}	
				System.out.println("注册成功");
				//2.储存用账号和密码
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
					System.out.println("请注册");
					break;
				}
				isLogin = false;
				//登录
				while(!isLogin) {
					System.out.println("请输入账号");
					name = sc.next();
					System.out.println("请输入密码");
					password = sc.next();
					for (int i = 0; i < users.length; i++) {
						if (users[i][0]!=null && users[i][0].equals(name) && users[i][1].equals(password)) {
							System.out.println("登录成功");
							isLogin = true;
							break;
						}
					}	
					if (isLogin==false) {
						System.out.println("密码错误");
					}
				}
				break;
			case 3:
				//机选
				//判断是否登录
				if (isLogin==false) {
					System.out.println("请先登录");
					break;
				}
				//输入购买注数
				System.out.println("请输入要购买的注数");
				int count = sc.nextInt();
				for (int i = 0; i < count; i++) {
					//先生成单注
					int[] one = new int[7];  //储存单注
					
					//6次机会 i--回到上次循环
					for (int j = 0; j <6; j++) {
						boolean isExits = false;
						int t = random.nextInt(33)+1;
						//判断  t不在数组中  双重循环内用到boolean, 外层别忘记复原变量的初始值
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
					//红球处理完毕
					one[6] = random.nextInt(16)+1;
					//冒泡排序
					for (int j = 0; j < 6; j++) {
						for (int k = 0; k < 6-j-1; k++) {
							if (one[k]>one[k+1]) {
								int temp=one[k];
								one[k] = one[k+1];
								one[k+1]=temp;
							}
						}
					}

					//放入二位数组
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
				//判断是否登录
				/*if (isLogin==false) {
					System.out.println("请先登录");
					break;
				}*/
				//手选

					//先生成单注
					int[] one = new int[7];  //储存单注
					boolean isExits = false;
					
					//加一个判断， 范围1-33
					for (int j = 0; j <6; j++) {
						System.out.println("请输入红球6个号码数");
						int t = sc.nextInt();
						int temp = t;
						if (t>33 || t<1) {
							System.out.println("输入超出范围,请输入1-33之间的数字");
							j--;
							continue;
						}
					
						//判断  t不在数组中
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
					//红球处理完毕
					System.out.println("请输入1注蓝球注数");
					one[6] = sc.nextInt();
					while(one[6]>16 || one[6]<1) {
						System.out.println("输入有误,范围在[1-16]之间");
						System.out.println("请重新输入");
						one[6] = sc.nextInt();
					}

					//冒泡排序
					for (int j = 0; j < 6; j++) {
						for (int k = 0; k < 6-j-1; k++) {
							if (one[k]>one[k+1]) {
								int temp=one[k];
								one[k] = one[k+1];
								one[k+1]=temp;
							}
						}
					}

					//放入二位数组
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
					System.out.println("请先登录");
					break;
				}
				//查看所选号码
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
				//开奖
				
				for (int i = 0; i < 5; i++) {
					int counts = 0;
					for (int j = 0; j < 7; j++) {
						for (int k = 0; k < 7; k++) {
							if (allLottery[i][j]==end[k]) {
								counts++;
							}
						}
					}

					//判断是否中奖
					if (counts>=3) {
						switch (counts) {
						case 7:
							System.out.println("第"+(i+1)+"注"+"特等奖");
							break;
						case 6:
							System.out.println("第"+(i+1)+"注"+"一等奖");
							break;
						case 5:
							System.out.println("第"+(i+1)+"注"+"二等奖");
							break;
						case 4:
							System.out.println("第"+(i+1)+"注"+"三等奖");
							break;
						case 2:
							System.out.println("第"+(i+1)+"注"+"鼓励奖");
							break;
							default:
								System.out.println("第"+(i+1)+"注  没中奖哦");
								break;
						}
					}else {
						System.out.println("下次可定能中奖");
					}
				}
				break;
			case 7:
				//退出
				isLoop = false;
				System.out.println("回家取钱吧! 下个百万富翁就是你!!!");
				break;
			}
	}
}
}
