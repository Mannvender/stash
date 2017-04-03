package Game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {
	public static final int BOARD_SIZE = 3;
	boolean crossTurn = true;
	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	public static enum status {
		incomplete, Xwins, Owins, Tie
	}

	public TTT() {
		super.setTitle("Tic Tack Toe");
		super.setSize(600, 600);
		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		Font font = new Font("Comic Sans", 1, 145);
		super.setLayout(grid);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");
				button.setFont(font);
				button.addActionListener(this);
				buttons[row][col] = button;
				super.add(button);
			}
		}

		super.setResizable(false);
		super.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		makemove(clickedButton);
		status gs = this.getStatus();
		if (gs != status.incomplete) {
			this.declareWinnner(gs);

			int choice = JOptionPane.showConfirmDialog(this, "Restart ?");
			if (choice == JOptionPane.YES_OPTION) {
				for (int row = 0; row < BOARD_SIZE; row++) {
					for (int col = 0; col < BOARD_SIZE; col++) {
						JButton b = buttons[row][col];
						b.setText("");
					}
				}
				crossTurn = true;
			} else {
				super.dispose();
			}
		}

	}

	private void declareWinnner(status gs) {
		if (gs == status.Xwins) {
			JOptionPane.showMessageDialog(this, "X Wins");
		} else if (gs == status.Owins) {
			JOptionPane.showMessageDialog(this, "O wins");
		} else {
			JOptionPane.showMessageDialog(this, "its a TIE");
		}
	}

	private status getStatus() {
		// test in rows
		int row = 0, col = 0;
		String text1 = "";
		while (row < BOARD_SIZE) {
			col = 0;

			while (col < BOARD_SIZE - 1) {
				text1 = buttons[row][col].getText();
				String text2 = buttons[row][col + 1].getText();
				if (!text1.equals(text2) || text2.length() == 0) {
					break;
				}

				col++;
			}
			if (col == BOARD_SIZE - 1) {
				if (text1.equals("X")) {
					return status.Xwins;
				} else {
					return status.Owins;
				}

			}

			row++;

		}
		// test in cols.
		row = 0;
		col = 0;
		while (col < BOARD_SIZE) {
			row = 0;
			while (row < BOARD_SIZE - 1) {
				text1 = buttons[row][col].getText();
				String text2 = buttons[row + 1][col].getText();
				if (!text1.equals(text2) || text2.length() == 0) {
					break;
				}

				row++;
			}
			if (row == BOARD_SIZE - 1) {
				if (text1.equals("X")) {
					return status.Xwins;
				} else {
					return status.Owins;
				}

			}

			col++;

		}
		// test in diag1
		row = 0;
		col = 0;

		while (row < BOARD_SIZE - 1) {
			text1 = buttons[row][col].getText();
			String text2 = buttons[row + 1][col + 1].getText();
			if (!text1.equals(text2) || text2.length() == 0) {
				break;
			}
			col++;
			row++;
		}
		if (row == BOARD_SIZE - 1) {
			if (text1.equals("X")) {
				return status.Xwins;
			} else {
				return status.Owins;
			}

		}
		// test in diag2
		row = BOARD_SIZE - 1;
		col = 0;
		while (row > 0) {
			text1 = buttons[row][col].getText();
			String text2 = buttons[row - 1][col + 1].getText();
			if (!text1.equals(text2) || text2.length() == 0) {
				break;
			}

			row--;
			col++;
		}
		if (row == 0) {
			if (text1.equals("X")) {
				return status.Xwins;
			} else {
				return status.Owins;
			}

		}

		String s = new String();
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {

				s = buttons[row][col].getText();
				if (s.length() == 0) {
					return status.incomplete;
				}
			}
		}
		return status.Tie;
	}

	private void makemove(JButton clickedButton) {
		if (clickedButton.getText().length() > 0) {
			JOptionPane.showMessageDialog(this, "Invalid move.");
			return;
		}
		if (crossTurn) {
			clickedButton.setText("X");
		} else {
			clickedButton.setText("0");
		}
		crossTurn = !crossTurn;

	}

}
