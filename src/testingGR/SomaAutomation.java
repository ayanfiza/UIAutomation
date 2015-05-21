package testingGR;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SomaAutomation {

	private JFrame frame;
	private JTextField textProductLine;
	private JTextField textIntend;
	private JLabel lblBrowser;
	private JTextField textBrowser;

	PriceTableCreation login = new PriceTableCreation();
	ShippingTableCreation shipping = new ShippingTableCreation();
	CreateCustomizatinoOffer customization = new CreateCustomizatinoOffer();
	CreateCatalog catalog = new CreateCatalog();
	private JTextField textOutput;
	private JTextField textPassword;
	private JTextField textCatKit;

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
		lblNewLabel.setBounds(30, 61, 98, 30);
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
																	// Table and
																	// shipping
																	// table and
																	// Customizaiton
																	// Offer
		btnPriceTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String browser = textBrowser.getText();
				String productLine = textProductLine.getText();
				String intend = textIntend.getText();
				String pass = textPassword.getText();
				String catKit = textCatKit.getText();
				if (pass.equals("do the magic")) {
					if (catKit.equals("Cat"))
					{
					try {
						String priceTableCode = login.createPriceTable(browser,
								productLine, intend);
						String shippingTableCode = shipping
								.createShippingTable(browser);
						String catalogCode = catalog
								.catalog(browser, productLine,
										priceTableCode, shippingTableCode);
						textOutput
								.setText("Price Table and Shiping Table is created \n PriceTableCode:  "
										+ priceTableCode
										+ "\n ShippingTableCode: "
										+ shippingTableCode
										+ "\n Catalog Code: "
										+ catalogCode);
					} catch (InterruptedException e1) {
						textOutput.setText(e1.getMessage());

					}
					}
					else if (catKit.equals("KC"))
					{
						try {
							String priceTableCode = login.createPriceTable(browser,
									productLine, intend);
							String shippingTableCode = shipping
									.createShippingTable(browser);
							String customizatinoOfferCode = customization
									.customizationOffer(browser, productLine,
											priceTableCode, shippingTableCode);
							textOutput
									.setText("Price Table and Shiping Table is created \n PriceTableCode:  "
											+ priceTableCode
											+ "\n ShippingTableCode: "
											+ shippingTableCode
											+ "\n CustomizaitnoOfferCode: "
											+ customizatinoOfferCode);
						} catch (InterruptedException e1) {
							textOutput.setText(e1.getMessage());

						}
					}
				} else if (!pass.equals("do the magic")) {
					textOutput.setText("Wrong Password");
				}
			}
		});
		btnPriceTable.setBounds(425, 146, 121, 23);
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

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 142, 68, 30);
		frame.getContentPane().add(lblPassword);

		textPassword = new JPasswordField(); // Password
		textPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textPassword.setColumns(10);
		textPassword.setBounds(168, 146, 200, 20);
		frame.getContentPane().add(textPassword);
		
		textCatKit = new JTextField();
		textCatKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {        //CatKit
			}
		});
		textCatKit.setColumns(10);
		textCatKit.setBounds(448, 28, 98, 20);
		frame.getContentPane().add(textCatKit);
	}
}
