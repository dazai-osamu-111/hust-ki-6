/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDAL;

import QUANLICUAHANGXEMAYEntity.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import QUANLICUAHANGXEMAYEntity.KhachHang;

/**
 *
 * @author duy
 */
public class KhachHangDAL extends DataAccessHelper {

    private String GET_ALL = "SELECT MaKH,TenKH,DiaChi,DienThoai,Email,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh ,TinhTrang FROM dbo.KhachHang";
    private final String ADD_DATA = "INSERT INTO KhachHang(MaKH, TenKH, DiaChi, DienThoai, Email, NgaySinh)"
            + "VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE dbo.KhachHang SET [TenKH] = ? ,[DiaChi] = ? ,[DienThoai] = ?,[Email]=?, [NgaySinh]=?"
            + " WHERE [MaKH] = ?";
    private final String DELETE = "DELETE FROM dbo.KhachHang  WHERE MaKH = ?";

    public ArrayList<KhachHang> getALL(String TOP, String WHERE, String ORDER) {
        ArrayList<KhachHang> objs = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "MaKH,TenKH,DiaChi,DienThoai,Email,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh ,TinhTrang FROM KhachHang ";
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
                    KhachHang kh = new KhachHang();
                    //   nv.setMaNhanVien(rs.getString("MaNhanVien"));
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setTenKH(rs.getString("TenKH"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    kh.setNgaySinh(rs.getString("NgaySinh"));
                    objs.add(kh);
                }
                getClose();
                GET_ALL = "SELECT MaKH,TenKH,DiaChi,DienThoai,Email,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh ,TinhTrang FROM dbo.KhachHang";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objs;
    }

    public boolean AddData(KhachHang kh) {

        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);

//           ps.setString(1, nv.getDienThoai());
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getDienThoai());
            ps.setString(5, kh.getEmail());
            ps.setString(6, kh.getNgaySinh());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateData(KhachHang kh) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);

          
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getDienThoai());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getNgaySinh());
             ps.setString(6, kh.getMaKH());
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

    public boolean deleteData(KhachHang kh) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, kh.getMaKH());
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
        String query="SELECT count(*) from dbo.KhachHang";
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
