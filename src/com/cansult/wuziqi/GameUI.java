package com.cansult.wuziqi;

import java.awt.Graphics;

import javax.swing.JFrame;

public class GameUI {
	
	public static final int dChessman = 40, numLine = 10, dCtC = 50, oX = 50, oY = 50;

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

		Graphics g = jf.getGraphics();

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
