package dao;

import vo.Admin;

import java.sql.*;

public class AdminDAO {

    public Admin getAdminByAdmin(String admin) throws Exception{
        Admin admin1 = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM T_ADMIN WHERE ADMIN ='"+admin+"'";
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()){
            admin1=new Admin();
            admin1.setAdmin(admin);
            admin1.setPassword(rs.getString("PWD"));
        }
        conn.close();
        return admin1;
    }

    public  void updateAdmin(Admin admin) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "UPDATE T_ADMIN SET PWD = ? WHERE ADMIN =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,admin.getPassword());
        ps.setString(2,admin.getAdmin());
        ps.executeQuery();
        conn.close();
    }
}
