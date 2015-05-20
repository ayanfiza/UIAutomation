package testingGR;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SomaAutomation {

	private JFrame frame;
	private JTextField textProductLine;
	private JTextField textIntend;
	private JLabel lblBrowser;
	private JTextField textBrowser;

	SomaLogin login = new SomaLogin();
	private JTextField textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SomaAutomation window = new SomaAutomation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SomaAutomation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Line");
		lblNewLabel.setBounds(30, 61, 68, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblIntend = new JLabel("Intend");
		lblIntend.setBounds(30, 101, 68, 30);
		frame.getContentPane().add(lblIntend);

		textProductLine = new JTextField(); // Product Line
		textProductLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textProductLine.setBounds(168, 61, 200, 20);
		frame.getContentPane().add(textProductLine);
		textProductLine.setColumns(10);

		JButton btnPriceTable = new JButton("Create Price Table"); // Creating
																	// Price
																	// Table.
		btnPriceTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String browser = textBrowser.getText();
				String productLine = textProductLine.getText();
				String intend = textIntend.getText();
				try {
					String priceTableCode = login.openBrowser(browser,
							productLine, intend);
					textOutput
							.setText("Price Table is created \n PriceTableCode:  "
									+ priceTableCode);
				} catch (InterruptedException e1) {
					textOutput.setText(e1.getMessage());

				}
			}
		});
		btnPriceTable.setBounds(105, 142, 121, 23);
		frame.getContentPane().add(btnPriceTable);

		textIntend = new JTextField();
		textIntend.addActionListener(new ActionListener() { // Intend
					public void actionPerformed(ActionEvent e) {
					}
				});
		textIntend.setColumns(10);
		textIntend.setBounds(168, 101, 200, 20);
		frame.getContentPane().add(textIntend);

		lblBrowser = new JLabel("Browser");
		lblBrowser.setBounds(30, 28, 68, 30);
		frame.getContentPane().add(lblBrowser);

		textBrowser = new JTextField(); // Browser
		textBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textBrowser.setColumns(10);
		textBrowser.setBounds(168, 28, 200, 20);
		frame.getContentPane().add(textBrowser);

		textOutput = new JTextField();
		textOutput.addActionListener(new ActionListener() { // Output
					public void actionPerformed(ActionEvent e) {
					}
				});
		textOutput.setBounds(105, 176, 345, 137);
		frame.getContentPane().add(textOutput);
		textOutput.setColumns(10);
	}
}
