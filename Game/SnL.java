package Game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnL extends JFrame implements ActionListener {
	public static final int BOARD_Width = 10;
	public static final int BOARD_Length = 10;
	boolean Zturn = true;
	int xrow = BOARD_Width - 1, xcol = BOARD_Length - 3, zrow = BOARD_Width - 1, zcol = BOARD_Length - 3;
	private JButton[][] buttons = new JButton[BOARD_Width][BOARD_Length];

	public SnL() {
		super.setTitle("Snakes And Ladders");
		super.setSize(1000, 700);
		GridLayout grid = new GridLayout(BOARD_Width, BOARD_Length);
		Font font = new Font("Comic Sans", 1, 10);
		super.setLayout(grid);
		for (int row = 0; row < BOARD_Width; row++) {
			for (int col = 0; col < BOARD_Length; col++) {
				if (row == BOARD_Width - 1 && col == BOARD_Length - 2
						|| row == BOARD_Width - 1 && col == BOARD_Length - 1) {
					JButton button = new JButton("");
					button.setFont(font);
					buttons[row][col] = button;
					super.add(button);

				} else {
					JButton button = new JButton("");
					button.setFont(font);
					buttons[row][col] = button;
					super.add(button);
				}

			}
		}
		// roll dice option
		// Listener only provided to roll button
		// System.out.println(BOARD_Length - 1);
		JButton b = buttons[BOARD_Width - 1][BOARD_Length - 1];
		b.setText("roll");
		b.addActionListener(this);
		// initial player positions
		JButton ini = buttons[BOARD_Width - 1][BOARD_Length - 3];
		ini.setText("plyrX plyrZ");
		super.setResizable(false);
		super.setVisible(true);

		// setting snakes
		this.setSNAKES();

		// setting ladders
		this.setLadders();

		JOptionPane.showMessageDialog(this,
				"rules - 1.everybody start from bottom \n 2.every move takes you to left of row \n 3.after reaching the top you must get 1 to win \n 4.ladders can take you anywhere in the same coloumn in upward dir \n 5.snakes behave as ladders but downwards \n 6.sometimes you can eat snakes but its not your choice");

	}

	private void setLadders() {

		int[] Xcord = { 0, 0, 2, 3, BOARD_Width - 4 };
		int[] Ycord = { 1, BOARD_Length - 2, 2, BOARD_Length - 4, 3 };
		JButton Sbutton = new JButton("");

		for (int i = 0; i < Xcord.length; i++) {
			Sbutton = buttons[Xcord[i]][Ycord[i]];
			Sbutton.setText("S");
		}

	}

	private void setSNAKES() {

		int[] Xcord = { BOARD_Width - 1, BOARD_Width - 3, BOARD_Width - 5, 2 };
		int[] Ycord = { BOARD_Length - 5, 0, 7, 4 };
		JButton Sbutton = new JButton("");

		for (int i = 0; i < Xcord.length; i++) {
			Sbutton = buttons[Xcord[i]][Ycord[i]];
			Sbutton.setText("L");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		int dice = rolldice(clickedButton);
		move(dice, Zturn);
	}

	private void move(int dice, boolean zturn) {
		JButton buttonInitial = new JButton();
		JButton buttonfinal = new JButton();

		if (zrow == 0 && zcol == 0 && dice == 1 || xrow == 0 && xcol == 0 && dice == 1) {
			this.declareWinner();
		}

		if (zturn) {
			buttonInitial = buttons[zrow][zcol];
			String text = buttonInitial.getText();

			// removing from first place

			if (zcol - dice < 0 && zrow == 0) {
				Zturn = !Zturn;

			} else {
				if (text.length() == 6) {
					buttonInitial.setText("");
				} else {
					if (text.substring(0, 6).equals("plyrZ ")) {
						buttonInitial.setText(text.substring(6) + " ");
					} else {
						buttonInitial.setText(text.substring(0, 6));
					}
				}
			}

			// now placing at new place
			if (zcol - dice < 0 && zrow == 0) {
				// Zturn = !Zturn;

			} else {
				if (zcol - dice >= 0) {
					zcol = zcol - dice;
				} else {
					zrow = zrow - 1;
					int nxtcolmove = dice - (zcol) - 1;
					zcol = (BOARD_Length - 1) - nxtcolmove;
				}
				buttonfinal = buttons[zrow][zcol];
				String s = buttonfinal.getText();

				if (s.equals("S")) {
					int temp = BOARD_Width - zrow - 1;
					Random rand2 = new Random();
					int newrow = rand2.nextInt(temp) + (1);
					zrow = zrow + newrow - 1;
					buttonfinal = buttons[zrow][zcol];
					s = buttonfinal.getText();

				}

				if (s.equals("L")) {
					int temp = zrow - 1;
					Random rand2 = new Random();
					int newrow = rand2.nextInt(temp) + (1);
					zrow = newrow;
					buttonfinal = buttons[zrow][zcol];
					s = buttonfinal.getText();
				}

				if (s.length() == 0) {
					buttonfinal.setText(s + "plyrZ ");
				} else {
					buttonfinal.setText(s + "plyrZ");
				}
				Zturn = !Zturn;

			}

		} else {
			buttonInitial = buttons[xrow][xcol];
			String text = buttonInitial.getText();

			// removing from first place
			if (xcol - dice < 0 && xrow == 0) {
				Zturn = !Zturn;

			} else {
				if (text.length() == 6) {
					buttonInitial.setText("");
				} else {
					if (text.substring(0, 6).equals("plyrX ")) {
						buttonInitial.setText(text.substring(6) + " ");
					} else {
						buttonInitial.setText(text.substring(0, 6));
					}
				}

			}

			// now placing at new place

			if (xcol - dice < 0 && xrow == 0) {
				// Zturn = !Zturn;

			} else {
				if (xcol - dice >= 0) {
					xcol = xcol - dice;
				} else {
					xrow = xrow - 1;
					int nxtcolmove = dice - (xcol) - 1;
					xcol = (BOARD_Length - 1) - nxtcolmove;
				}
				buttonfinal = buttons[xrow][xcol];
				String s = buttonfinal.getText();

				if (s.equals("S")) {
					int temp = BOARD_Width - xrow - 1;
					Random rand2 = new Random();
					int newrow = rand2.nextInt(temp) + (1);
					xrow = xrow + newrow - 1;
					buttonfinal = buttons[xrow][xcol];
					s = buttonfinal.getText();

				}

				if (s.equals("L")) {
					int temp = xrow - 1;
					Random rand2 = new Random();
					int newrow = rand2.nextInt(temp) + (1);
					xrow = newrow;
					buttonfinal = buttons[xrow][xcol];
					s = buttonfinal.getText();
				}

				if (s.length() == 0) {
					buttonfinal.setText(s + "plyrX ");
				} else {
					buttonfinal.setText(s + "plyrX");
				}
				Zturn = !Zturn;
			}

		}

	}

	private void declareWinner() {

		JOptionPane.showMessageDialog(this, "there is our winner");
		int choice = JOptionPane.showConfirmDialog(this, "Restart ?");
		if (choice == JOptionPane.YES_OPTION) {

			for (int row = 0; row < BOARD_Width; row++) {
				for (int col = 0; col < BOARD_Length; col++) {
					if (row == BOARD_Width - 1 && col == BOARD_Length - 2
							|| row == BOARD_Width - 1 && col == BOARD_Length - 1) {
						JButton button = buttons[row][col];
						button.setText("");

					} else {
						JButton button = buttons[row][col];
						button.setText("");
					}

				}
			}
			xrow = BOARD_Width - 1;
			xcol = BOARD_Length - 3;
			zrow = BOARD_Width - 1;
			zcol = BOARD_Length - 3;
			JButton b = buttons[BOARD_Width - 1][BOARD_Length - 1];
			b.setText("roll");

			JButton ini = buttons[BOARD_Width - 1][BOARD_Length - 3];
			ini.setText("plyrX plyrZ");

			this.setSNAKES();

			this.setLadders();

		} else {
			this.dispose();
		}

	}

	private int rolldice(JButton clickedButton) {
		Random rand = new Random();
		int n = rand.nextInt(6) + 1;
		JButton b = buttons[BOARD_Width - 1][BOARD_Length - 2];
		b.setText(n + "");
		return n;
	}

}
