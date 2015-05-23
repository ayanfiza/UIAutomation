package testingGR;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SomaAutomation {

	private JFrame frame;
	private JTextField textProductLine;
	private JTextField textIntend;
	private JLabel lblBrowser;
	private JTextField textBrowser;
	private TextArea textOutput;
	static String priceTableCode;
	static String shippingTableCode;
	static String catalogCode;
	static String ptCode;
	/*
	 * private JRadioButton catBtn; private JRadioButton kitCustBtn;
	 */
	;
	private JTextField textPassword;
	private JTextField textPriceTableCode;
	private JTextField textShippingTableCode;

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
		frame = new JFrame("Play with SOMA UI");
		frame.setBounds(100, 100, 655, 403);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Line");
		lblNewLabel.setBounds(30, 61, 98, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblIntend = new JLabel("Intend");
		lblIntend.setBounds(30, 101, 68, 30);
		frame.getContentPane().add(lblIntend);

		textProductLine = new JTextField(); // Product Line
		textProductLine.setText("IT");
		textProductLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textProductLine.setBounds(122, 61, 200, 20);
		frame.getContentPane().add(textProductLine);
		textProductLine.setColumns(10);

		JRadioButton kitCustBtn = new JRadioButton("Kit Cust");
		kitCustBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textIntend.setText("Kit Customization");
			}
		});
		kitCustBtn.setBounds(463, 35, 78, 23);
		frame.getContentPane().add(kitCustBtn);

		JRadioButton catBtn = new JRadioButton("Catalog");
		catBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIntend.setText("Catalog Offers");
			}
		});
		catBtn.setBounds(543, 35, 68, 23);
		frame.getContentPane().add(catBtn);

		ButtonGroup bG = new ButtonGroup();
		bG.add(kitCustBtn);
		bG.add(catBtn);

		JButton btnPriceTable = new JButton("Do The Magic"); // Creating
																// Price
																// Table and
																// shipping
																// table and
																// Customizaiton
																// Offer
		btnPriceTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebDriver driver = null;
				String browser = textBrowser.getText();
				String productLine = textProductLine.getText();
				String intend = textIntend.getText();
				String pass = textPassword.getText();
				String priceTabelCode1 = textPriceTableCode.getText();
				String shippingTableCode1 = textShippingTableCode.getText();

				if (pass.equals("do the magic")) {
					if (catBtn.isSelected() && priceTabelCode1.equals("")
							&& shippingTableCode1.equals("")) // Catalog
					{
						try {
							driver = new BasePage(driver).login(browser);
							driver = new PriceTableCreation(driver)
									.createPriceTable(productLine, intend);
							driver = new ShippingTableCreation(driver)
									.createShippingTable();
							driver = new CreateCatalog(driver).catalog(
									productLine, priceTableCode,
									shippingTableCode);
							driver = new CreatingPromotionalTemplate(driver)
									.promotionalTemplate(productLine,
											catalogCode);
							String skCode = new CreatingSourceKey(driver)
									.sourceKey(productLine, ptCode);
							textOutput.setText("PriceTableCode:  "
									+ priceTableCode
									+ "\n ShippingTableCode:  "
									+ shippingTableCode + "\n Catalog Code:  "
									+ catalogCode
									+ "\n Promotional Template:  " + ptCode
									+ "\n Sourcekey Code:  " + skCode);
						} catch (InterruptedException e1) {
							textOutput.setText(e1.getMessage());

						}
					} else if (kitCustBtn.isSelected()
							&& priceTabelCode1.equals("")
							&& shippingTableCode1.equals("")) // Customization
																// Offer
					{
						try {
							driver = new BasePage(driver).login(browser);
							driver = new PriceTableCreation(driver)
									.createPriceTable(productLine, intend);
							driver = new ShippingTableCreation(driver)
									.createShippingTable();
							String customizationOfferCode = new CreateCustomizatinoOffer(
									driver).customizationOffer(productLine,
									priceTableCode, shippingTableCode);
							textOutput.setText("PriceTableCode:  "
									+ priceTableCode
									+ "\n ShippingTableCode:  "
									+ shippingTableCode
									+ "\n CustomizaitnoOfferCode:  "
									+ customizationOfferCode);
						} catch (InterruptedException e1) {
							textOutput.setText(e1.getMessage());

						}
					} else if (catBtn.isSelected()
							&& !priceTabelCode1.equals("")
							&& !shippingTableCode1.equals("")) {
						try {
							String priceTableCode = priceTabelCode1;
							String shippingTableCode = shippingTableCode1;
							driver = new CreateCatalog(driver).catalog(
									productLine, priceTableCode,
									shippingTableCode);
							driver = new CreatingPromotionalTemplate(driver)
									.promotionalTemplate(productLine,
											catalogCode);
							String skCode = new CreatingSourceKey(driver)
									.sourceKey(productLine, ptCode);
							textOutput.setText("PriceTableCode:  "
									+ priceTableCode
									+ "\n ShippingTableCode:  "
									+ shippingTableCode + "\n Catalog Code:  "
									+ catalogCode
									+ "\n Promotional Template:  " + ptCode
									+ "\n Sourcekey Code:  " + skCode);
						} catch (Exception e1) {
							textOutput.setText(e1.getMessage());

						}

					} else if (kitCustBtn.isSelected()
							&& !priceTabelCode1.equals("")
							&& !shippingTableCode1.equals("")) {
						try {
							String priceTableCode = priceTabelCode1;
							String shippingTableCode = shippingTableCode1;
							String customizationOfferCode = new CreateCustomizatinoOffer(
									driver).customizationOffer(productLine,
									priceTableCode, shippingTableCode);
							textOutput.setText("PriceTableCode:  "
									+ priceTableCode
									+ "\n ShippingTableCode:  "
									+ shippingTableCode
									+ "\n CustomizaitnoOfferCode:  "
									+ customizationOfferCode);
						} catch (Exception e1) {
							textOutput.setText(e1.getMessage());

						}

					}

				} else if (!pass.equals("do the magic")) {
					textOutput.setText("Wrong Password");
				}
			}
		});
		btnPriceTable.setBounds(10, 191, 155, 23);
		frame.getContentPane().add(btnPriceTable);

		textIntend = new JTextField();
		textIntend.addActionListener(new ActionListener() { // Intend
					public void actionPerformed(ActionEvent e) {
					}
				});
		textIntend.setColumns(10);
		textIntend.setBounds(122, 101, 200, 20);
		frame.getContentPane().add(textIntend);

		lblBrowser = new JLabel("Browser");
		lblBrowser.setBounds(30, 28, 68, 30);
		frame.getContentPane().add(lblBrowser);

		textBrowser = new JTextField(); // Browser
		textBrowser.setText("firefox");
		textBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textBrowser.setColumns(10);
		textBrowser.setBounds(122, 28, 200, 20);
		frame.getContentPane().add(textBrowser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 142, 68, 30);
		frame.getContentPane().add(lblPassword);

		textPassword = new JPasswordField(); // Password
		textPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textPassword.setColumns(10);
		textPassword.setBounds(122, 146, 200, 20);
		frame.getContentPane().add(textPassword);

		textOutput = new TextArea();
		textOutput.setBounds(230, 193, 357, 139);
		frame.getContentPane().add(textOutput);

		JLabel lblChooseOne = new JLabel("Choose one");
		lblChooseOne.setBounds(393, 28, 87, 30);
		frame.getContentPane().add(lblChooseOne);

		JLabel lblPricetable = new JLabel("PriceTable?");
		lblPricetable.setBounds(393, 61, 68, 30);
		frame.getContentPane().add(lblPricetable);

		textPriceTableCode = new JTextField(); // priceTable code
		textPriceTableCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textPriceTableCode.setColumns(10);
		textPriceTableCode.setBounds(490, 69, 121, 20);
		frame.getContentPane().add(textPriceTableCode);

		JLabel lblShippingtable = new JLabel("ShippingTable?");
		lblShippingtable.setBounds(393, 101, 87, 30);
		frame.getContentPane().add(lblShippingtable);

		textShippingTableCode = new JTextField();
		textShippingTableCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ShippingTable Code
			}
		});
		textShippingTableCode.setColumns(10);
		textShippingTableCode.setBounds(490, 109, 121, 20);
		frame.getContentPane().add(textShippingTableCode);

	}
}
