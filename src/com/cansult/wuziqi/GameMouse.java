package com.cansult.wuziqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouse implements MouseListener {

	public Graphics gr;
	public Client wbc;
	public boolean vic;
	public int dChessman, dCtC, numLine, oX, oY, cnt, blackWhite;
	
	public void setcol() {
		if (blackWhite % 2 == 1)
			gr.setColor(Color.white);
		else
			gr.setColor(Color.black);
	}

	public GameMouse(Client web, Graphics g, int d, int dt, int nl, int ox, int oy, int bw) {
		wbc = web;
		gr = g;
		dChessman = d;
		dCtC = dt;
		numLine = nl;
		oX = ox;
		oY = oy;
		blackWhite = bw;
		setcol();
	}
	
	public void changecol() {
		if (blackWhite % 2 != 1)
			gr.setColor(Color.white);
		else
			gr.setColor(Color.black);
	}
	
	public boolean ifVic() {
		int re = wbc.readMsg();
		if (re < 0) {
			vic = true;
			Font font = new Font("华文行楷", Font.BOLD, 26); // 创建字体对象
	        gr.setFont(font); // 设置字体
			if (re == -1) gr.drawString("White Wins", 800, 800);
			else if (re == -2) gr.drawString("Black Wins", 800, 800);
			return true;
		}
		else return false;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");

		if (vic) return ;
		int x = e.getX();
		int y = e.getY();

//绘制棋子
		int leX = (x - oX) / dCtC, leY = (y - oY) / dCtC;
		if (Math.abs(leX * dCtC + oX - x) > Math.abs((leX + 1) * dCtC + oX - x))
			++leX;
		if (Math.abs(leY * dCtC + oY - y) > Math.abs((leY + 1) * dCtC + oY - y))
			++leY;
		if (leX <= numLine && leY <= numLine && leX >= 0 && leY >= 0) {
			wbc.sendMsg(leX);
			wbc.sendMsg(leY);
			if (wbc.readMsg() == 1) {
				gr.fillOval(leX * dCtC + oX - dChessman / 2, leY * dCtC + oY - dChessman / 2, dChessman, dChessman);
				
				if (ifVic()) return ;
				int nleX = wbc.readMsg(), nleY = wbc.readMsg();
				
				changecol();
				gr.fillOval(nleX * dCtC + oX - dChessman / 2, nleY * dCtC + oY - dChessman / 2, dChessman, dChessman);
				setcol();
				
				if (ifVic()) return ;
			}
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
