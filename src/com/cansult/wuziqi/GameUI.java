package com.cansult.wuziqi;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GameUI {
	
	public static final int dChessman = 40, numLine = 10, dCtC = 50, oX = 50, oY = 50;
	public static Client wbc;

	public static void main(String[] args) {
//窗体
		JFrame jf = new JFrame();
		jf.setSize(1000, 1000);
		jf.setTitle("五子棋");
//居中显示
		jf.setLocationRelativeTo(null);
//退出进程
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//设置可见
		jf.setVisible(true);

		Graphics g = jf.getGraphics();
		
		try {
			wbc = new Client();
			wbc.connect("localhost", 8088);
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		g.setColor(Color.black);
		
		for (int i = 0; i <= numLine; i++)
			g.drawLine(oX, oY + i * dCtC, oX + numLine * dCtC, oY + i * dCtC);
		
		for (int i = 0; i <= numLine; i++)
			g.drawLine(oX + i * dCtC, oY, oX + i * dCtC, oY + numLine * dCtC);
		
		int blackWhite = wbc.readMsg();
		
		System.out.println(blackWhite);
		
		if (blackWhite == 1) {
			int x = wbc.readMsg(), y = wbc.readMsg();
			g.fillOval(x, y, dChessman, dChessman);
		}

		GameMouse mouse = new GameMouse(wbc, g, dChessman, dCtC, numLine, oX, oY, blackWhite);
		jf.addMouseListener(mouse);

		
	}

}
