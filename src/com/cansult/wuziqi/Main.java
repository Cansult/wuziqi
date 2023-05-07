package com.cansult.wuziqi;

public class Main {
	static int dChessman = 40, numLine = 10, dCtC = 50, oX = 50, windowSize = 1000;
	static String serverIp = "localhost";
	static int serverPort = 8088;
	static GameMouse gameMouse;
	static GameUI gameWindow;
	
	static void vic(int x) {
		if (x == -1) gameWindow.win(1);
		if (x == -2) gameWindow.win(0);
	}

	public static void main(String[] args) throws Exception{
		bool hasClick = new bool();
		hasClick.ok = false;
		gameMouse = new GameMouse(hasClick);
//窗体
		gameWindow = new GameUI(dChessman, numLine, dCtC, oX, windowSize, gameMouse);
		gameWindow.init();
		Client wbc;
		wbc = new Client();
		wbc.connect(serverIp, serverPort);
		System.out.println("Success");

		
		int blackWhite = wbc.readMsg();
//		int blackWhite = 0;
	
		System.out.println(blackWhite);
		
		for (int i = 0; ; i++) {
			int x, y;
			if (i % 2 == blackWhite) {
				hasClick.ok = false;
				while (true) {
					Thread.sleep(100);
					
					if (hasClick.ok) {
						x = gameWindow.trueX(gameMouse.x);
						y = gameWindow.trueY(gameMouse.y);
						wbc.sendMsg(x);
						wbc.sendMsg(y);
						System.out.println(x + " " + y);
						
						if (wbc.readMsg() == 1)
							break;
					}
				}
				gameWindow.drawChessman(x, y, i % 2);
				int z = wbc.readMsg();
				if (z < 0) {
					vic(z);
					break;
				}
			}
			else {
//				System.out.println("gg");
				x = wbc.readMsg();
				y = wbc.readMsg();
				gameWindow.drawChessman(x, y, i % 2);
				int z = wbc.readMsg();
				if (z < 0) {
					vic(z);
					break;
				}
			}
		}
		
		while(true);
	}

}
