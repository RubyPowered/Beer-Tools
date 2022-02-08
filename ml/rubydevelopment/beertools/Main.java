package ml.rubydevelopment.beertools;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ml.rubydevelopment.beertools.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
		// Some prerequisites
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MainWindow();
		
	}

}
