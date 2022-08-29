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

/**
 *
 * @author duy
 */
public class NhanVienDAL extends DataAccessHelper{
   private String GET_ALL="SELECT MaNhanVien,TenNhanVien,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh,GioiTinh,DiaChi,DienThoai,Chucvu,CONVERT(decimal(18,0),LuongCoBan) AS LuongCoBan,CONVERT(VARCHAR,Ngayvaolam,103) AS Ngayvaolam,CONVERT(decimal(18,0),Luong) AS Luong FROM dbo.NhanVien";
   private final String ADD_DATA="INSERT INTO NhanVien(DienThoai, MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" 
                                    +"VALUES (?,?,?,?,?,?,?,?,?,?)";
   private final String UPDATE = "UPDATE dbo.NhanVien SET [DienThoai] = ? ,[TenNhanVien] = ? ,[NgaySinh] = ? ,[GioiTinh] = ?,[DiaChi]=?, [Chucvu]=?,[LuongCoBan]=?,[Ngayvaolam]=?,[Luong]=?"
                                + " WHERE [MaNhanVien] = ?";
   private final String DELETE = "DELETE FROM dbo.NhanVien WHERE MaNhanVien = ?"; 
 
   public ArrayList<NhanVien> getALL(String TOP, String WHERE,String ORDER)
   {
       ArrayList<NhanVien> objs=new ArrayList<>();
         if(TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0){
            GET_ALL = "SELECT ";
            if(TOP.length() != 0){
                GET_ALL += "TOP " +TOP;
            }
            GET_ALL += "MaNhanVien,TenNhanVien,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh,GioiTinh,DiaChi,DienThoai,Chucvu,CONVERT(decimal(18,0),LuongCoBan) AS LuongCoBan,CONVERT(VARCHAR,Ngayvaolam,103) AS Ngayvaolam,CONVERT(decimal(18,0),Luong) AS Luong FROM NhanVien ";
            if(WHERE.length() != 0) GET_ALL += "WHERE " +WHERE;
            if(ORDER.length() != 0) GET_ALL += "ORDER BY" + ORDER;
        }
       try {
           getConnect();
           PreparedStatement ps=conn.prepareStatement(GET_ALL);
           ResultSet rs=ps.executeQuery();
           if(rs!=null)
           {
               while(rs.next())
               {
                   NhanVien nv=new NhanVien();
                   nv.setMaNhanVien(rs.getString("MaNhanVien"));
                   nv.setTenNhanVien(rs.getString("TenNhanVien"));
                   nv.setNgaySinh(rs.getString("NgaySinh"));
                   nv.setGioiTinh(rs.getString("GioiTinh"));
                   nv.setDiaChi(rs.getString("DiaChi"));
                   nv.setDienThoai(rs.getString("DienThoai"));
                   nv.setChucvu(rs.getString("Chucvu"));
                   nv.setLuongCoBan(rs.getString("LuongCoBan"));
                   nv.setNgayvaolam(rs.getString("Ngayvaolam"));
                   nv.setLuong(rs.getString("Luong"));
                   objs.add(nv);
               }
               getClose();
           }
       } catch (SQLException ex) {
           Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
       }
       GET_ALL="SELECT MaNhanVien,TenNhanVien,CONVERT(VARCHAR,NgaySinh,103) as NgaySinh,GioiTinh,DiaChi,DienThoai,Chucvu,CONVERT(decimal(18,0),LuongCoBan) AS LuongCoBan,CONVERT(VARCHAR,Ngayvaolam,103) AS Ngayvaolam,CONVERT(decimal(18,0),Luong) AS Luong FROM dbo.NhanVien";
       return objs;
   }
 //  "INSERT INTO NhanVien(DienThoai, MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" +
      
   public boolean AddData(NhanVien nv)
   {
       //private final String ADD_DATA="INSERT INTO NhanVien(DienThoai, MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, DiaChi, Chucvu, LuongCoBan, Ngayvaolam, Luong)" 
                              //      +"VALUES (?,?,?,?,?,?,?,?,?,?)";
       boolean check=false;
       try {
           getConnect();
           PreparedStatement ps=conn.prepareStatement(ADD_DATA);
           

           ps.setString(1, nv.getDienThoai());
             ps.setString(2, nv.getMaNhanVien());
           ps.setString(3, nv.getTenNhanVien());
           ps.setString(4, nv.getNgaySinh());
           ps.setString(5, nv.getGioiTinh());
           ps.setString(6, nv.getDiaChi());
           ps.setString(7, nv.getChucvu());
           ps.setString(8, nv.getLuongCoBan());
           ps.setString(9,nv.getNgayvaolam());
           ps.setString(10, nv.getLuong());
           
         
           int rs=ps.executeUpdate();
           if(rs>0)
           {
               check=true;
           }
           getClose();
       } catch (Exception e) {
       }
       return check;
   }
   public boolean updateData(NhanVien nv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(UPDATE);
//"UPDATE dbo.NhanVien SET [DienThoai] = ? ,[TenNhanVien] = ? ,[NgaySinh] = ? ,[GioiTinh] = ?,[DiaChi]=?, [Chucvu]=?,[LuongCoBan]=?,[Ngayvaolam]=?,[Luong]=?"
  //                              + "WHERE [MaNhanVien] = ?";
           ps.setString(1, nv.getDienThoai());
          
           ps.setString(2, nv.getTenNhanVien());
           ps.setString(3, nv.getNgaySinh());
           ps.setString(4, nv.getGioiTinh());
           ps.setString(5, nv.getDiaChi());
           ps.setString(6, nv.getChucvu());
           ps.setString(7, nv.getLuongCoBan());
           ps.setString(8,nv.getNgayvaolam());
           ps.setString(9, nv.getLuong());
            ps.setString(10, nv.getMaNhanVien());
            int rs = ps.executeUpdate();
            if(rs > 0) check = true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
   public boolean deleteData(NhanVien nv){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareCall(DELETE);
            ps.setString(1, nv.getMaNhanVien());
            int rs = ps.executeUpdate();
            if(rs > 0) check = true;
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
        String query="SELECT count(*) from dbo.NhanVien";
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
