/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.PhieuXuat;
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
public class PhieuXuatDAL extends DataAccessHelper{
     private String GET_ALL = "SELECT  MaPhieuXuat,CONVERT(VARCHAR,NgayXuat,103) as NgayXuat,MaNhanVien,MaKhachHang FROM [PhieuXuat]";
    private final String ADD_DATA = "INSERT INTO PhieuXuat(MaPhieuXuat, NgayXuat, MaNhanVien, MaKhachHang)"
            + "VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.PhieuXuat SET [NgayXuat] = ? ,[MaNhanVien] = ? ,[MaKhachHang] = ? "
            + " WHERE [MaPhieuXuat] = ?";

    public ArrayList<PhieuXuat> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<PhieuXuat> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT MaPhieuXuat,CONVERT(VARCHAR,NgayXuat,103) as NgayXuat,MaNhanVien,MaKhachHang ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += " FROM PhieuXuat ";
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
                    PhieuXuat nv = new PhieuXuat();
                    nv.setMaPhieuXuat(rs.getString("MaPhieuXuat"));
                    nv.setNgayXuat(rs.getString("NgayXuat"));
                    nv.setMaKhachHang(rs.getString("MaKhachHang"));
                    nv.setMaNhanVien(rs.getString("MaNhanVien"));
                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
     GET_ALL = "SELECT  MaPhieuXuat,CONVERT(VARCHAR,NgayXuat,103) as NgayXuat,MaNhanVien,MaKhachHang FROM [PhieuXuat]";
        return objs;
    }
    //  "INSERT INTO PhieuXuat(DienThoai, MaPhieuXuat, TenPhieuXuat, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" +

    public boolean AddData(PhieuXuat nv) {
        //private final String ADD_DATA="INSERT INTO PhieuXuat(DienThoai, MaPhieuXuat, TenPhieuXuat, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" 
        //      +"VALUES (?,?,?,?,?,?,?,?,?,?)";
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, nv.getMaPhieuXuat());
            ps.setString(2, nv.getNgayXuat());
            ps.setString(3, nv.getMaNhanVien());
            ps.setString(4, nv.getMaKhachHang());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(PhieuXuat nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//UPDATE = "UPDATE dbo.PhieuXuat SET [NgayNhap] = ? ,[MaNhanVien] = ? ,[MaNhaCungCap] = ? "
//            + " WHERE [MaPN] = ?";

          
            ps.setString(1, nv.getNgayXuat());
            ps.setString(2, nv.getMaNhanVien());
            ps.setString(3, nv.getMaKhachHang());
             ps.setString(4, nv.getMaPhieuXuat());
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
     public int Get_SoLuong(String MaXe) 
    {
        int Soluong=0;
     
        Statement stmt=null;
        getConnect();
        String query="SELECT SoLuong FROM dbo.Xe where [MaXe]='"+MaXe+"' ";
         try {
             stmt=conn.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(PhieuXuatDAL.class.getName()).log(Level.SEVERE, null, ex);
         }
        ResultSet rs = null;
         try {
             rs = stmt.executeQuery(query);
         } catch (SQLException ex) {
             Logger.getLogger(PhieuXuatDAL.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
                 Soluong=rs.getInt("SoLuong");
         } catch (SQLException ex) {
             Logger.getLogger(PhieuXuatDAL.class.getName()).log(Level.SEVERE, null, ex);
         }
         return Soluong;
    }
}
