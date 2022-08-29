/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.PhieuNhap;
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
public class PhieuNhapDAL extends DataAccessHelper {

    private String GET_ALL = "SELECT  MaPN,CONVERT(VARCHAR,NgayNhap,103) as NgayNhap,MaNhanVien,MaNhaCungCap FROM [PhieuNhap]";
    private final String ADD_DATA = "INSERT INTO PhieuNhap(MaPN, NgayNhap, MaNhanVien, MaNhaCungCap)"
            + "VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.PhieuNhap SET [NgayNhap] = ? ,[MaNhanVien] = ? ,[MaNhaCungCap] = ? "
            + " WHERE [MaPN] = ?";

    public ArrayList<PhieuNhap> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<PhieuNhap> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT MaPN,CONVERT(VARCHAR,NgayNhap,103) as NgayNhap,MaNhanVien,MaNhaCungCap ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += " FROM PhieuNhap ";
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
                    PhieuNhap nv = new PhieuNhap();
                    nv.setMaPhieuNhap(rs.getString("MaPN"));
                    nv.setNgayNhap(rs.getString("NgayNhap"));
                    nv.setMaNhaCungCap(rs.getString("MaNhaCungCap"));
                    nv.setMaNhanVien(rs.getString("MaNhanVien"));

                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        GET_ALL = "SELECT MaPN,CONVERT(VARCHAR,NgayNhap,103) as NgayNhap,MaNhanVien,MaNhaCungCap  FROM dbo.PhieuNhap";
        return objs;
    }
    //  "INSERT INTO PhieuNhap(DienThoai, MaPhieuNhap, TenPhieuNhap, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" +

    public boolean AddData(PhieuNhap nv) {
        //private final String ADD_DATA="INSERT INTO PhieuNhap(DienThoai, MaPhieuNhap, TenPhieuNhap, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" 
        //      +"VALUES (?,?,?,?,?,?,?,?,?,?)";
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, nv.getMaPhieuNhap());
            ps.setString(2, nv.getNgayNhap());
            ps.setString(3, nv.getMaNhanVien());
            ps.setString(4, nv.getMaNhaCungCap());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(PhieuNhap nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//UPDATE = "UPDATE dbo.PhieuNhap SET [NgayNhap] = ? ,[MaNhanVien] = ? ,[MaNhaCungCap] = ? "
//            + " WHERE [MaPN] = ?";

            ps.setString(1, nv.getNgayNhap());
            ps.setString(2, nv.getMaNhanVien());
            ps.setString(3, nv.getMaNhaCungCap());
            ps.setString(4, nv.getMaPhieuNhap());
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
}
