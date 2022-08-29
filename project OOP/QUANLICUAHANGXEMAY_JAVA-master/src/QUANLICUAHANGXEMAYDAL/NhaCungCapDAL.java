/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duy
 */
public class NhaCungCapDAL extends DataAccessHelper {

    private String GET_ALL = "SELECT * FROM dbo.NhaCungCap";
    private final String ADD_DATA = "INSERT INTO NhaCungCap(MaNhaCC, TenNhaCC, DiaChi, DienThoai, Email)"
            + "VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.NhaCungCap SET [TenNhaCC] = ? ,[DiaChi] = ? ,[DienThoai] = ? ,[Email] = ?"
            + " WHERE [MaNhaCC] = ?";
    private final String DELETE = "DELETE FROM dbo.NhaCungCap WHERE MaNhaCC = ?";

    public ArrayList<NhaCungCap> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<NhaCungCap> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM NhaCungCap ";
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
                    NhaCungCap nv = new NhaCungCap();
                    nv.setMaNhaCungCap(rs.getString("MaNhaCC"));
                    nv.setTenNhaCungCap(rs.getString("TenNhaCC"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setDienThoai(rs.getString("DienThoai"));
                    nv.setEmail(rs.getString("Email"));
                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        GET_ALL = "SELECT * FROM dbo.NhaCungCap";
        return objs;
    }
    //  "INSERT INTO NhaCungCap(DienThoai, MaNhaCungCap, TenNhaCungCap, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" +

    public boolean AddData(NhaCungCap nv) {
        //private final String ADD_DATA="INSERT INTO NhaCungCap(DienThoai, MaNhaCungCap, TenNhaCungCap, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" 
        //      +"VALUES (?,?,?,?,?,?,?,?,?,?)";
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, nv.getMaNhaCungCap());
            ps.setString(2, nv.getTenNhaCungCap());
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getDienThoai());
            ps.setString(5, nv.getEmail());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(NhaCungCap nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//"UPDATE dbo.NhaCungCap SET [TenNhaCC] = ? ,[DiaChi] = ? ,[DienThoai] = ? ,[Email] = ?"
//            + " WHERE [MaNhaCC] = ?";
           
            ps.setString(1, nv.getTenNhaCungCap());
            ps.setString(2, nv.getDiaChi());
            ps.setString(3, nv.getDienThoai());
            ps.setString(4, nv.getEmail());
             ps.setString(5, nv.getMaNhaCungCap());
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

    public boolean deleteData(NhaCungCap nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, nv.getMaNhaCungCap());
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
    public int CountDb()
    {
        int count = 0;
        getConnect();
        String query="SELECT count(*) from dbo.NhaCungCap";
        try {
            PreparedStatement ps=conn.prepareCall(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                count=(int) rs.getLong(1);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        getClose();
        return count;
    }
}
