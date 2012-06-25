package gui;

import gui.frames.MainFrame;

public class TestMain {
	
	public TestMain() {
		MainFrame.getInstance();
	}
	public static void main(String[] args) {
		new TestMain();
	}
}
