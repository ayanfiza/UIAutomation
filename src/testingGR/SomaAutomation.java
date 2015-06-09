package testingGR;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;

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
//Test
	
	Font f = new Font("Arial", Font.ITALIC, 12);           //Font

	private JTextField textPassword;
	private JTextField textPriceTableCode;
	private JTextField textShippingTableCode;
	private JTextField textSomaUser;
	private JPasswordField somaPasswordField;
	ResetSnapshotDB runSQL = new ResetSnapshotDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frame.setBounds(100, 100, 774, 403);
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textProductLine.setBounds(122, 61, 200, 20);
		frame.getContentPane().add(textProductLine);
		textProductLine.setColumns(10);

		JRadioButton kitCustBtn = new JRadioButton("Kit Cust");
		kitCustBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textIntend.setText("Kit Customization");
			}
		});
		kitCustBtn.setBounds(463, 35, 78, 23);
		frame.getContentPane().add(kitCustBtn);

		JRadioButton catBtn = new JRadioButton("Catalog");
		catBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textIntend.setText("Catalog Offers");
			}
		});
		catBtn.setBounds(543, 35, 68, 23);
		frame.getContentPane().add(catBtn);

		JRadioButton catBtnPls = new JRadioButton("Catalog Plus");
		catBtnPls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		catBtnPls.setBounds(613, 35, 98, 23);
		frame.getContentPane().add(catBtnPls);

		
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(kitCustBtn);
		bG.add(catBtn);
		bG.add(catBtnPls);
		JButton btnPriceTable = new JButton("Do The Magic"); // Creating
																// Price
																// Table and
																// shipping
																// table and
																// Customizaiton
																// Offer
		btnPriceTable.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				WebDriver driver = null;
				String browser = textBrowser.getText();
				String productLine = textProductLine.getText();
				String intend = textIntend.getText();
				String pass = textPassword.getText();
				String priceTabelCode1 = textPriceTableCode.getText();
				String shippingTableCode1 = textShippingTableCode.getText();
				String somaUser = textSomaUser.getText();
				String somaPass = somaPasswordField.getText();
				if (somaUser.equals("") && somaPass.equals("")) {
					textOutput.setFont(f);
					textOutput.setForeground(Color.RED);
					textOutput
							.setText("Please insert a valid\nUsername and Passoword for SOMA");
				} else {
					if (pass.equals("do the magic")) {
						if (catBtnPls.isSelected() && priceTabelCode1.equals("")
								&& shippingTableCode1.equals("")) 						// Catalog Plus
						{
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
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
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCatalog Code:  " + catalogCode
										+ "\nPromotional Template:  " + ptCode
										+ "\nSourcekey Code:  " + skCode);
							} catch (InterruptedException e1) {
								textOutput.setText(e1.getMessage());

							}
						}
						else if (catBtn.isSelected() && priceTabelCode1.equals("")
								&& shippingTableCode1.equals("")) 						// Catalog
						{
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
								driver = new PriceTableCreation(driver)
										.createPriceTable(productLine, intend);
								driver = new ShippingTableCreation(driver)
										.createShippingTable();
								driver = new CreateCatalog(driver).catalog(
										productLine, priceTableCode,
										shippingTableCode);
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCatalog Code:  " + catalogCode);
							} catch (InterruptedException e1) {
								textOutput.setText(e1.getMessage());

							}
						}
						else if (kitCustBtn.isSelected()
								&& priceTabelCode1.equals("")
								&& shippingTableCode1.equals("")) // Customization
																	// Offer
						{
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
								driver = new PriceTableCreation(driver)
										.createPriceTable(productLine, intend);
								driver = new ShippingTableCreation(driver)
										.createShippingTable();
								String customizationOfferCode = new CreateCustomizatinoOffer(
										driver).customizationOffer(productLine,
										priceTableCode, shippingTableCode);
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCustomizaitnoOfferCode:  "
										+ customizationOfferCode);
							} catch (InterruptedException e1) {
								textOutput.setText(e1.getMessage());

							}
						} else if (catBtnPls.isSelected()							//Catalog Plus with Price n shipping preselected
								&& !priceTabelCode1.equals("")
								&& !shippingTableCode1.equals("")) {
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
								String priceTableCode = priceTabelCode1;
								String shippingTableCode = shippingTableCode1;
								driver = new CreateCatalogFresh(driver)
										.catalog(productLine, priceTableCode,
												shippingTableCode);
								driver = new CreatingPromotionalTemplate(driver)
										.promotionalTemplate(productLine,
												catalogCode);
								String skCode = new CreatingSourceKey(driver)
										.sourceKey(productLine, ptCode);
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCatalog Code:  " + catalogCode
										+ "\nPromotional Template:  " + ptCode
										+ "\nSourcekey Code:  " + skCode);
							} catch (Exception e1) {
								textOutput.setText(e1.getMessage());

							}

						}
						else if (catBtn.isSelected() && !priceTabelCode1.equals("")
								&& !shippingTableCode1.equals("")) 						// Catalog with Price n shipping preselected
						{
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
								String priceTableCode = priceTabelCode1;
								String shippingTableCode = shippingTableCode1;
								driver = new CreateCatalogFresh(driver)
										.catalog(productLine, priceTableCode,
												shippingTableCode);
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCatalog Code:  " + catalogCode);
							} catch (Exception e11) {
								textOutput.setText(e11.getMessage());

							}
						}
						else if (kitCustBtn.isSelected()							//Customization Offer with Price n shipping preselected
								&& !priceTabelCode1.equals("")
								&& !shippingTableCode1.equals("")) {
							try {
								driver = new BasePage(driver).login(browser,
										somaUser, somaPass);
								String priceTableCode = priceTabelCode1;
								String shippingTableCode = shippingTableCode1;
								String customizationOfferCode = new CreateCustomizatinoOfferFresh(
										driver).customizationOffer(productLine,
										priceTableCode, shippingTableCode);
								textOutput.setFont(f);
								textOutput.setForeground(Color.BLACK);
								textOutput.setText("PriceTableCode:  "
										+ priceTableCode
										+ "\nShippingTableCode:  "
										+ shippingTableCode
										+ "\nCustomizaitnoOfferCode:  "
										+ customizationOfferCode);
							} catch (Exception e1) {
								textOutput.setText(e1.getMessage());

							}

						}

					} else if (!pass.equals("do the magic")) {
						textOutput.setFont(f);
						textOutput.setForeground(Color.RED);
						textOutput.setText("Password is empty or incorrect!!!");
					}
				}
			}
		});
		btnPriceTable.setBounds(456, 146, 155, 23);
		frame.getContentPane().add(btnPriceTable);

		textIntend = new JTextField();
		textIntend.addActionListener(new ActionListener() { // Intend
					@Override
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
		textBrowser.setText("Firefox");
		textBrowser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		textBrowser.setColumns(10);
		textBrowser.setBounds(122, 28, 200, 20);
		frame.getContentPane().add(textBrowser);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(30, 142, 68, 30);
		frame.getContentPane().add(lblPassword);

		textPassword = new JPasswordField(); // Password
		textPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textPassword.setColumns(10);
		textPassword.setBounds(122, 146, 200, 20);
		frame.getContentPane().add(textPassword);

		
		textOutput = new TextArea();

		textOutput.addComponentListener(new ComponentAdapter() {      //output
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		textOutput.setBounds(391, 193, 320, 139);
		frame.getContentPane().add(textOutput);

		JLabel lblChooseOne = new JLabel("Choose one");
		lblChooseOne.setBounds(393, 28, 87, 30);
		frame.getContentPane().add(lblChooseOne);

		JLabel lblPricetable = new JLabel("PriceTable?");
		lblPricetable.setBounds(393, 61, 68, 30);
		frame.getContentPane().add(lblPricetable);

		textPriceTableCode = new JTextField(); // priceTable code
		textPriceTableCode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textPriceTableCode.setColumns(10);
		textPriceTableCode.setBounds(531, 69, 180, 20);
		frame.getContentPane().add(textPriceTableCode);

		JLabel lblShippingtable = new JLabel("ShippingTable?");
		lblShippingtable.setBounds(393, 101, 87, 30);
		frame.getContentPane().add(lblShippingtable);

		textShippingTableCode = new JTextField();
		textShippingTableCode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // ShippingTable Code
			}
		});
		textShippingTableCode.setColumns(10);
		textShippingTableCode.setBounds(531, 109, 180, 20);
		frame.getContentPane().add(textShippingTableCode);

		textSomaUser = new JTextField();
		textSomaUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // somauser
			}
		});
		textSomaUser.setColumns(10);
		textSomaUser.setBounds(144, 193, 125, 20);
		frame.getContentPane().add(textSomaUser);

		JLabel lblSomaUser = new JLabel("Soma User :");
		lblSomaUser.setBounds(30, 193, 217, 30);
		frame.getContentPane().add(lblSomaUser);

		somaPasswordField = new JPasswordField();
		somaPasswordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // somapass
			}
		});
		somaPasswordField.setColumns(10);
		somaPasswordField.setBounds(144, 234, 125, 20);
		frame.getContentPane().add(somaPasswordField);

		JLabel lblSomaPassword = new JLabel("Soma Password :");
		lblSomaPassword.setBounds(30, 229, 217, 30);
		frame.getContentPane().add(lblSomaPassword);
		
		JButton btnRefreshSnapshotDb = new JButton("Refresh Snapshot DB !!!");
		btnRefreshSnapshotDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {       
				String pass = textPassword.getText();  // Snapshot DB refresh
				if (pass.equals("do the magic"))
				{
					textOutput.setFont(f);
					textOutput.setForeground(Color.BLACK);
				runSQL.JDBCConnection();
				textOutput.setText("Snapshot DB refreshed");
				}
				else
				{
					
					textOutput.setFont(f);
					textOutput.setForeground(Color.RED);
					textOutput.setText("Password is empty or incorrect!!!");
				}
			}
		});
		btnRefreshSnapshotDb.setBounds(30, 286, 239, 23);
		frame.getContentPane().add(btnRefreshSnapshotDb);
		


	}
}
