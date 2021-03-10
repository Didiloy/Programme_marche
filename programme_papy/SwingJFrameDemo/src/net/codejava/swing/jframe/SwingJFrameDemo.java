package net.codejava.swing.jframe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * This program demonstrates how to work with JFrame in Swing.
 * @author www.codejava.net
 *
 */
public class SwingJFrameDemo extends JFrame {
	private JLabel label = new JLabel("Enter your e-mail: ");
	private JTextField textField = new JTextField(20);
	private JButton button = new JButton("OK");

	public SwingJFrameDemo() {
		super("Demo program for JFrame");

		// sets layout manager
		setLayout(new GridBagLayout());

		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(10, 10, 10, 10);
		constraint.gridx = 0;
		constraint.gridy = 0;

		add(label, constraint);

		constraint.gridx = 1;
		add(textField, constraint);

		constraint.gridx = 0;
		constraint.gridwidth = 2;
		constraint.gridy = 1;

		add(button, constraint);

		// adds menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);

		menuBar.add(menuFile);

		// adds menu bar to the frame
		setJMenuBar(menuBar);

		// adds window event listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				int reply = JOptionPane.showConfirmDialog(SwingJFrameDemo.this,
						"Are you sure you want to quit?",
						"Exit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (reply == JOptionPane.YES_OPTION) {
					dispose();
				} else {
					return;
				}
			}
		});

		// sets icon image
		String iconPath = "/net/codejava/swing/jframe/android.png";
		Image icon = new ImageIcon(getClass().getResource(iconPath)).getImage();
		setIconImage(icon);

		pack();

		// centers on screen
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingJFrameDemo();
			}
		});
	}
}