package dao;

import vo.Admin;

import java.sql.*;

public class AdminDAO {

    private Connection conn = null;

    public void initConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
    }

    public void closeConnection() throws Exception{
        conn.close();
    }

    public Admin getAdminByAdmin(String admin) throws Exception{
        //根据 admin 获取管理员
        Admin admin1 = null;
        this.initConnection();
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM T_ADMIN WHERE ADMIN ='"+admin+"'";
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()){
            admin1=new Admin();
            admin1.setAdmin(admin);
            admin1.setPassword(rs.getString("PWD"));
        }
        this.closeConnection();
        return admin1;
    }

    public void updateAdmin(Admin admin) throws Exception{
        //重置密码
        this.initConnection();
        String sql = "UPDATE T_ADMIN SET PWD = ? WHERE ADMIN =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,admin.getPassword());
        ps.setString(2,admin.getAdmin());
        ps.executeQuery();
        this.closeConnection();
    }
}
