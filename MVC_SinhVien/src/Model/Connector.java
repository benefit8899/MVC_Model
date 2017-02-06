package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connector {
	public String QUERYGETALLSTUDENT = "SELECT st.student_id, st.student_name,st.student_code, stf.address, stf.average_score, stf.date_of_birth"
			+ " FROM tblstudent st, tblstudent_info stf" + " WHERE st.student_id = stf.student_id";
	public String QUERY2 = "SELECT * FROM users";
	Connection con = null;
	public String dbaddress = "localhost";
	public String dbname = "sinhvien";
	public String us = "root";
	public String pw = "grimreaper";
	public int port = 3306;
	// get result by query
	public List<Student> getResulByQuery(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://"+dbaddress+":"+port+"/"+ dbname, us, pw);

		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Student> ls = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			stu.student_id = rs.getInt(1);
			stu.student_name = rs.getString(2);
			stu.student_code = rs.getString(3);
			stu.address = rs.getString(4);
			stu.average_score = rs.getDouble(5);
			stu.date_of_birth = rs.getDate(6);
			ls.add(stu);

		}
		if (con != null || !con.isClosed()) {
			con.close();
		}
		return ls;
	}
}
