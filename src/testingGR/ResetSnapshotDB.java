package testingGR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ResetSnapshotDB {
	Connection connection = null;

	public void JDBCConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@ebsqa-scan.grc-network.net:1521/s_appdbtst",
					"SETUPSNAPSHOT", "APPTA7gSap");
			String jobquery = "DECLARE P_TENANT_ID NUMBER; BEGIN P_TENANT_ID := 1; K_GET_SNAPSHOT.P_FULL_RUN(P_TENANT_ID => P_TENANT_ID);END;";
			CallableStatement callStmt = connection.prepareCall(jobquery);
			callStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
