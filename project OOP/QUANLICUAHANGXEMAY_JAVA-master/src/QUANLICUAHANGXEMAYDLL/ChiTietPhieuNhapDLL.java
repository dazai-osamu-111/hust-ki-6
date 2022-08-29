/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.ChiTietPhieuNhapDAL;
import QUANLICUAHANGXEMAYEntity.ChiTietPhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class ChiTietPhieuNhapDLL {
     ChiTietPhieuNhapDAL dal=new ChiTietPhieuNhapDAL();
    public ArrayList<ChiTietPhieuNhap> getALL(String TOP, String WHERE,String ORDER)
    {
        return dal.getALL(TOP,WHERE,ORDER);
    }
    public  boolean AddData(ChiTietPhieuNhap nv)
    {
        return dal.AddData(nv);
    }
      public  boolean updateData(ChiTietPhieuNhap nv)
    {
        return dal.updateData(nv);
    }
      public boolean deleteData(ChiTietPhieuNhap nv)
    {
        return dal.deleteData(nv);
    }
         public ArrayList<ChiTietPhieuNhap> CheckID(String MaPhieuNhap,String MaXe)
    {
        return dal.getALL("", "MaPN='"+MaPhieuNhap+ "' AND MaXe='"+MaXe+"'", "");
             
    }
}
