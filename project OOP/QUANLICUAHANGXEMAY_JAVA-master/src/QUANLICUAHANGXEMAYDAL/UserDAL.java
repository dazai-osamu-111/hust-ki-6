/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duy
 */
public class UserDAL extends DataAccessHelper {

    private final String GET_LOGIN = "SELECT * FROM Users where [User]=? and MatKhauMoi=?";
    private final String GET_MANV = "SELECT MaUser FROM Users where [User]=? ";
    private final String UPDATE_Password = "UPDATE dbo.Users SET [MatKhauMoi] = ? "
            + " WHERE [User] = ?";
    private String GET_ALL = "SELECT * FROM dbo.Users";
    private final String ADD_DATA = "INSERT INTO dbo.Users([User], MaNhanVien, MatKhauMoi, Quyen)"
            + "VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.Users SET [MaNhanVien] = ? ,[MatKhauMoi] = ? ,[Quyen] = ? "
            + " WHERE [User] = ?";

    public ArrayList<User> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<User> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM Users ";
            if (WHERE.length() != 0) {
                GET_ALL += "WHERE " + WHERE;
            }
            if (ORDER.length() != 0) {
                GET_ALL += "ORDER BY" + ORDER;
            }
        }
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    User nv = new User();
                    nv.setUser(rs.getString("User"));
                    nv.setMaNhanVien(rs.getString("MaNhanVien"));
                    nv.setMatKhauMoi(rs.getString("MatKhauMoi"));
                    nv.setQuyen(rs.getString("Quyen"));
                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        GET_ALL = "SELECT * FROM dbo.Users";
        return objs;
    }
//     private final String ADD_DATA = "INSERT INTO dbo.Users(User, MaNhanVien, MatKhauMoi, Quyen"
//            + "VALUES (?,?,?,?)";

    public boolean AddData(User nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);

            ps.setString(1, nv.getUser());
            ps.setString(2, nv.getMaNhanVien());
            ps.setString(3, nv.getMatKhauMoi());
            ps.setString(4, nv.getQuyen());          
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(User nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//"UPDATE dbo.User SET [DienThoai] = ? ,[TenUser] = ? ,[NgaySinh] = ? ,[GioiTinh] = ?,[DiaChi]=?, [Chucvu]=?,[LuongCoBan]=?,[Ngayvaolam]=?,[Luong]=?"
            //                              + "WHERE [MaUser] = ?";

            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getMatKhauMoi());
            ps.setString(3, nv.getQuyen());
            ps.setString(4, nv.getUser());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean getLogin(String u, String p) {
        boolean check = false;
        try {

            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean update_Password(User nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE_Password);
//UPDATE = "UPDATE dbo.Users SET [NgayNhap] = ? ,[MaUser] = ? ,[MaNhaCungCap] = ? "
//            + " WHERE [MaPN] = ?";

         
            ps.setString(1, nv.getMatKhauMoi());
            ps.setString(2, nv.getUser());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public String Get_MaNhanVien(String Users) throws SQLException {
        String MaNV = "";
        Statement stmt = null;
        getConnect();
        String query = "SELECT MaNhanVien FROM Users where [User]='" + Users + "' ";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            MaNV = rs.getString("MaNhanVien");
        }
        return MaNV;
    }

    public String Get_Quyen(String Users) throws SQLException {
        String Quyen = "";
        Statement stmt = null;
        getConnect();
        String query = "SELECT Quyen FROM Users where [User]='" + Users + "' ";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Quyen = rs.getString("Quyen");
        }
        return Quyen;
    }

}
