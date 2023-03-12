package com.cansult.wuziqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouse implements MouseListener {
	
	
	public Graphics gr;
	public boolean vic;
	public int dChessman, dCtC, numLine, oX, oY, cnt;
	public int[][] vis = new int[30][30], xy = {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}};

	public GameMouse(Graphics g, int d, int dt, int nl, int ox, int oy) {
		gr = g;
		dChessman = d;
		dCtC = dt;
		numLine = nl;
		oX = ox;
		oY = oy;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		
		int x = e.getX();
		int y = e.getY();


//绘制棋子
		int leX = (x - oX) / dCtC, leY = (y - oY) / dCtC;
		if (Math.abs(leX * dCtC + oX - x) > Math.abs((leX + 1) * dCtC + oX - x)) ++leX;
		if (Math.abs(leY * dCtC + oY - y) > Math.abs((leY + 1) * dCtC + oY - y)) ++leY;
		if (leX <= numLine && leY <= numLine && leX >= 0 && leY >= 0 && vis[leX][leY] == 0 && !vic) {
			gr.fillOval(leX * dCtC + oX - dChessman / 2, leY * dCtC + oY - dChessman / 2, dChessman, dChessman);
			++cnt;
			vis [leX][leY] = cnt % 2 + 1;
			
			for (int i = 0; i < 8; i++) {
				vic = true;
				for (int j = 1; j <= 4; j++) {
					int nx = leX + j * xy[i][0], ny = leY + j * xy[i][1];
					if (nx < 0 || ny < 0 || vis[nx][ny] != vis[leX][leY]) {
						vic = false;
						break;
					}
				}
				if (vic) {
					Font font = new Font("华文行楷", Font.BOLD, 26); // 创建字体对象
			        gr.setFont(font); // 设置字体
					if (cnt % 2 == 1)
						gr.drawString("Black Wins", 800, 800);
					else
						gr.drawString("White Wins", 800, 800);
					break;
				}
			}
			
			
			if (cnt % 2 == 1)
				gr.setColor(Color.white);
			else 
				gr.setColor(Color.black);
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
