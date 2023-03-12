package com.cansult.wuziqi;

import java.awt.Graphics;

import javax.swing.JFrame;

/*
 *  五子棋游戏：	1.显示游戏界面(棋盘，棋子，功能按钮)： java.awt    javax.swing
 *           	2.监听器：设计界面程序的交互功能
 *           	3.画笔：在界面程序中显示自定义内容
 *  
 *  练习：	1.完善棋盘的绘制
 *      	2.让棋子落在棋盘的交点，黑白交替出现
 *      	3.判断输赢问题？
 *      	4.功能按钮..
 */
public class GameUI {
	
	public static final int dChessman = 40, numLine = 10, dCtC = 50, oX = 50, oY = 50;

//1.显示界面
	public void showUI() {
//窗体
		JFrame jf = new JFrame();
		jf.setSize(1000, 1000);
		jf.setTitle("五子棋游戏");
//居中显示
		jf.setLocationRelativeTo(null);
//退出进程
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//设置可见
		jf.setVisible(true);

//3.画笔：自定义内容显示在哪个组件上，画笔就从该组件上获取
//从窗体上获取画笔对象，一定要在窗体显示可见之后
		Graphics g = jf.getGraphics();

//2.监听器
//a.事件源：当前动作所发生的组件(swing)
//b.监听器：鼠标监听器方法:addMouseListener()
//c.绑定事件处理类

//给窗体添加鼠标监听器方法
//数据类型：1.基本类型(8个)  2.引用类型(自定义类型)：类(class),接口(interface),数组
//接口不能直接创建对象：重新定义类继承接口 重写接口中的抽象方法
		GameMouse mouse = new GameMouse(g, dChessman, dCtC, numLine, oX, oY);
		jf.addMouseListener(mouse);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <= numLine; i++)
			g.drawLine(oX, oY + i * dCtC, oX + numLine * dCtC, oY + i * dCtC);
		
		for (int i = 0; i <= numLine; i++)
			g.drawLine(oX + i * dCtC, oY, oX + i * dCtC, oY + numLine * dCtC);
	}

//主函数
	public static void main(String[] args) {
		GameUI ui = new GameUI();
		ui.showUI();

	}

}