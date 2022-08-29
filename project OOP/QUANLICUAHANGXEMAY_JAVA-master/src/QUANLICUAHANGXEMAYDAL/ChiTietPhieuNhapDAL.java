/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.ChiTietPhieuNhap;
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
public class ChiTietPhieuNhapDAL extends DataAccessHelper {

    private String GET_ALL = "SELECT MaPN,MaXe,SLNhap,CONVERT(decimal(18,0),DonGiaNhap) as DonGiaNhap,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien FROM ChiTietPhieuNhap";
    private final String ADD_DATA = "INSERT INTO dbo.ChiTietPhieuNhap(MaPN, MaXe, SLNhap, DonGiaNhap, Thue) "
            + "VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.ChiTietPhieuNhap SET [SLNhap] = ? ,[DonGiaNhap] = ? ,[Thue] = ?"
            + " WHERE [MaPN] = ? AND MaXe=?";
    private final String DELETE = "DELETE FROM dbo.ChiTietPhieuNhap WHERE MaPN = ? AND MaXe=?";

    public ArrayList<ChiTietPhieuNhap> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<ChiTietPhieuNhap> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT MaPN,MaXe,SLNhap,CONVERT(decimal(18,0),DonGiaNhap) as DonGiaNhap,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += " FROM ChiTietPhieuNhap ";
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
                    ChiTietPhieuNhap nv = new ChiTietPhieuNhap();
                    nv.setMaPhieuNhap(rs.getString("MaPN"));
                    nv.setDonGiaNhap(rs.getString("DonGiaNhap"));
                    nv.setMaXe(rs.getString("MaXe"));
                    nv.setThanhTien(rs.getString("ThanhTien"));
                    nv.setThue(rs.getString("Thue"));
                    nv.setSLNhap(rs.getString("SLNhap"));

                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        GET_ALL = "SELECT MaPN,MaXe,SLNhap,CONVERT(decimal(18,0),DonGiaNhap) as DonGiaNhap,Thue,CONVERT(decimal(18,0),ThanhTien) as ThanhTien FROM ChiTietPhieuNhap";
        return objs;
    }
    //  INSERT INTO Xe(MaPN, MaXe, SLNhap, DonGiaNhap, Thue) "

    public boolean AddData(ChiTietPhieuNhap nv) {

        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, nv.getMaPhieuNhap());
            ps.setString(2, nv.getMaXe());
            ps.setString(3, nv.getSLNhap());
            ps.setString(4, nv.getDonGiaNhap());
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

    public boolean updateData(ChiTietPhieuNhap nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//UPDATE = "UPDATE dbo.ChiTietPhieuNhap SET [SLNhap] = ? ,[DonGiaNhap] = ? ,[Thue] = ?"
            // + " WHERE [MaPN] = ? AND MaXe=?";

            ps.setString(1, nv.getSLNhap());
            ps.setString(2, nv.getDonGiaNhap());
            ps.setString(3, nv.getThue());
            ps.setString(4, nv.getMaPhieuNhap());
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

    public boolean deleteData(ChiTietPhieuNhap nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, nv.getMaPhieuNhap());
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
