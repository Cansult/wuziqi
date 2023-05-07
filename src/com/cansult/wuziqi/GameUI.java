package com.cansult.wuziqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;

public class GameUI {
	
	private int dChessman, numLine, dCtC, oX, oY, windowSize;
	private JFrame gameWindow;
	private Graphics pen;
	
	GameUI(int dc, int nl, int dt, int o, int ws, GameMouse gm) {
		dChessman = dc;
		numLine = nl;
		dCtC = dt;
		oX = oY = o;
		windowSize = ws;
		gameWindow = new JFrame();
		gameWindow.addMouseListener(gm);
		
	}
	void init() {
//窗体
		gameWindow.setSize(windowSize, windowSize);
		gameWindow.setTitle("五子棋");
//居中显示
		gameWindow.setLocationRelativeTo(null);
//退出进程
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//设置可见
		gameWindow.setVisible(true);

		pen = gameWindow.getGraphics();
		pen.setColor(Color.black);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <= numLine; i++)
			pen.drawLine(oX, oY + i * dCtC, oX + numLine * dCtC, oY + i * dCtC);
		
		for (int i = 0; i <= numLine; i++)
			pen.drawLine(oX + i * dCtC, oY, oX + i * dCtC, oY + numLine * dCtC);
	}
	
	int trueX(int x) {
		int reX = (x - oX) / dCtC;
		if (Math.abs(reX * dCtC + oX - x) > Math.abs((reX + 1) * dCtC + oX - x))
			++reX;
		if (reX <= numLine && reX >= 0)
			return reX;
		return -1;
	}
	
	int trueY(int y) {
		int reY = (y - oY) / dCtC;
		if (Math.abs(reY * dCtC + oY - y) > Math.abs((reY + 1) * dCtC + oY - y))
			++reY;
		if (reY <= numLine && reY >= 0)
			return reY;
		return -1;
	}
	
	void drawChessman(int x, int y, int color) {
		if (color == 0) pen.setColor(Color.black);
		if (color == 1)	pen.setColor(Color.white);
		pen.fillOval(x * dCtC + oX - dChessman / 2, y * dCtC + oY - dChessman / 2, dChessman, dChessman);
	}
	
	void win(int x) {
		Font font = new Font("华文行楷", Font.BOLD, 26); // 创建字体对象
        pen.setFont(font); // 设置字体
		if (x == 1) pen.drawString("White Wins", 800, 800);
		else if (x == 0) pen.drawString("Black Wins", 800, 800);

	}
}
