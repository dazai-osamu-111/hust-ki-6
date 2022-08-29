/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.ChiTietPhieuXuat;
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
public class ChiTietPhieuXuatDAL extends DataAccessHelper{
    private String GET_ALL = "SELECT MaPhieuXuat,MaXe,SLXuat,CONVERT(decimal(18,0),DonGiaXuat) as DonGiaXuat,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien FROM ChiTietPhieuXuat";
    private final String ADD_DATA = "INSERT INTO dbo.ChiTietPhieuXuat(MaPhieuXuat, MaXe, SLXuat, DonGiaXuat, Thue) "
            + "VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.ChiTietPhieuXuat SET [SLXuat] = ? ,[DonGiaXuat] = ? ,[Thue] = ?"
            + " WHERE [MaPhieuXuat] = ? AND MaXe=?";
    private final String DELETE = "DELETE FROM dbo.ChiTietPhieuXuat WHERE MaPhieuXuat = ? AND MaXe=?";

    public ArrayList<ChiTietPhieuXuat> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<ChiTietPhieuXuat> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT MaPhieuXuat,MaXe,SLXuat,CONVERT(decimal(18,0),DonGiaXuat) as DonGiaXuat,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += " FROM ChiTietPhieuXuat ";
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
                    ChiTietPhieuXuat nv = new ChiTietPhieuXuat();
                    nv.setMaPhieuXuat(rs.getString("MaPhieuXuat"));
                    nv.setMaXe(rs.getString("MaXe"));
                    nv.setSLXuat(rs.getString("SLXuat"));
                    nv.setThanhTien(rs.getString("ThanhTien"));
                    nv.setThue(rs.getString("Thue"));
                    nv.setDonGiaXuat(rs.getString("DonGiaXuat"));

                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       GET_ALL = "SELECT MaPhieuXuat,MaXe,SLXuat,CONVERT(decimal(18,0),DonGiaXuat) as DonGiaXuat,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien FROM ChiTietPhieuXuat";
        return objs;
    }
    //  INSERT INTO Xe(MaPN, MaXe, SLNhap, DonGiaNhap, Thue) "

    public boolean AddData(ChiTietPhieuXuat nv) {

        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, nv.getMaPhieuXuat());
            ps.setString(2, nv.getMaXe());
            ps.setString(3, nv.getSLXuat());
            ps.setString(4, nv.getDonGiaXuat());
            ps.setString(5, nv.getThue());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(ChiTietPhieuXuat nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//UPDATE = "UPDATE dbo.ChiTietPhieuXuat SET [SLNhap] = ? ,[DonGiaNhap] = ? ,[Thue] = ?"
            // + " WHERE [MaPN] = ? AND MaXe=?";

            ps.setString(1, nv.getSLXuat());
            ps.setString(2, nv.getDonGiaXuat());
            ps.setString(3, nv.getThue());
            ps.setString(4, nv.getMaPhieuXuat());
            ps.setString(5, nv.getMaXe());
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

    public boolean deleteData(ChiTietPhieuXuat nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, nv.getMaPhieuXuat());
            ps.setString(2, nv.getMaXe());
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
