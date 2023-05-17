package com.cansult.wuziqi;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouse implements MouseListener {

	boolean hasClick;
	int x, y;
	
	GameMouse() {
		hasClick = false;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		x = e.getX();
		y = e.getY();
		hasClick = true;
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
