package Game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
	private Dimension dimension;

	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		dimension = new Dimension(width, height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.setPreferredSize(dimension);
		frame.setMaximumSize(dimension);
		frame.setMinimumSize(dimension);

		frame.add(game);
		frame.setVisible(true);
		game.start();

	}

}
