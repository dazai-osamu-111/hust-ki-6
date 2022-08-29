/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.Xe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author duy
 */
public class XeDAL extends DataAccessHelper {

    private String GET_ALL = "SELECT MaXe,TenHangXe,SoLuong,ThongTinBaoHanh,TenXe,NhaSX,CONVERT(decimal(18,0),DonGia) as DonGia,TinhTrang FROM dbo.Xe";
    private final String ADD_DATA = "INSERT INTO Xe(MaXe, TenHangXe, SoLuong, ThongTinBaoHanh, TenXe, NhaSX, DonGia) "
            + "VALUES (?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.Xe SET [TenHangXe] = ? ,[SoLuong] = ? ,[ThongTinBaoHanh] = ? ,[TenXe] = ?,[NhaSX]=?, [DonGia]=?"
            + " WHERE [MaXe] = ?";
    private final String DELETE = "DELETE FROM dbo.Xe WHERE MaXe = ?";

    public ArrayList<Xe> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<Xe> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += " MaXe,TenHangXe,SoLuong,ThongTinBaoHanh,TenXe,NhaSX,CONVERT(decimal(18,0),DonGia) as DonGia,TinhTrang FROM Xe ";
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
                    Xe nv = new Xe();
                    nv.setMaXe(rs.getString("MaXe"));
                    nv.setTenHangXe(rs.getString("TenHangXe"));
                    nv.setSoLuong(rs.getString("SoLuong"));
                    nv.setThongTinBaoHanh(rs.getString("ThongTinBaoHanh"));
                    nv.setTenXe(rs.getString("TenXe"));
                    nv.setNhaSX(rs.getString("NhaSX"));
                    nv.setDonGia(rs.getString("DonGia"));
                    nv.setTinhTrang(rs.getString("TinhTrang"));
                    objs.add(nv);
                }
                getClose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        GET_ALL = "SELECT MaXe,TenHangXe,SoLuong,ThongTinBaoHanh,TenXe,NhaSX,CONVERT(decimal(18,0),DonGia) as DonGia,TinhTrang FROM dbo.Xe";
        return objs;
    }
    //  "INSERT INTO Xe(DienThoai, MaXe, TenXe, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" +

    public boolean AddData(Xe nv) {
//       "INSERT INTO Xe(MaXe, TenHangXe, SoLuong, ThongTinBaoHanh, TenXe, NhaSX, DonGia)"
//            + "VALUES (?,?,?,?,?,?,?)";
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);

            ps.setString(1, nv.getMaXe());
            ps.setString(2, nv.getTenHangXe());
            ps.setString(3, nv.getSoLuong());
            ps.setString(4, nv.getThongTinBaoHanh());
            ps.setString(5, nv.getTenXe());
            ps.setString(6, nv.getNhaSX());
            ps.setString(7, nv.getDonGia());
          

            int rs = ps.executeUpdate();
            System.out.println(""+rs);
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(Xe nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//"UPDATE dbo.Xe SET [TenHangXe] = ? ,[SoLuong] = ? ,[ThongTinBaoHanh] = ? ,[TenXe] = ?,[NhaSX]=?, [DonGia]=?"
//            + " WHERE [MaXe] = ?";
             
            ps.setString(1, nv.getTenHangXe());
            ps.setString(2, nv.getSoLuong());
            ps.setString(3, nv.getThongTinBaoHanh());
            ps.setString(4, nv.getTenXe());
            ps.setString(5, nv.getNhaSX());
            ps.setString(6, nv.getDonGia());
             ps.setString(7, nv.getMaXe());
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

    public boolean deleteData(Xe nv) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, nv.getMaXe());
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
        String query="SELECT count(*) from dbo.Xe";
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
