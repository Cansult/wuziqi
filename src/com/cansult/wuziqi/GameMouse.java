package com.cansult.wuziqi;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouse implements MouseListener {

	bool hasClick;
	int x, y;
	
	GameMouse(bool cb) {
		hasClick = cb;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		x = e.getX();
		y = e.getY();
		hasClick.ok = true;
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
