package testingGR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetActiveProducts {

	public String[] products() {
		String[] prod = new String[3];
		{
			try {
				//DB connection and find products
				int i = 0;
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ebsqa-scan.grc-network.net:1521/s_appdbtst", "setup", "APPTwe25yZ");
				String sql = ("SELECT PPID FROM (SELECT PPID FROM products where PRODUCT_STATUS = 'A' and Product_line_code = 'MT' ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum < 4");

				CallableStatement callStmt = con.prepareCall(sql);
				callStmt.execute();
				ResultSet rst = callStmt.getResultSet();
				while (rst.next()) {
					String product = rst.getString("PPID");
					prod[i] = product;
					i++;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prod;
	}
}
