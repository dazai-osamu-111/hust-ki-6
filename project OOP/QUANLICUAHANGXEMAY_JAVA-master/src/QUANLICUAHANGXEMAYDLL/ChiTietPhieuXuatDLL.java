/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.ChiTietPhieuXuatDAL;
import QUANLICUAHANGXEMAYEntity.ChiTietPhieuXuat;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class ChiTietPhieuXuatDLL {
     ChiTietPhieuXuatDAL dal=new ChiTietPhieuXuatDAL();
    public ArrayList<ChiTietPhieuXuat> getALL(String TOP, String WHERE,String ORDER)
    {
        return dal.getALL(TOP,WHERE,ORDER);
    }
    public  boolean AddData(ChiTietPhieuXuat nv)
    {
        return dal.AddData(nv);
    }
      public  boolean updateData(ChiTietPhieuXuat nv)
    {
        return dal.updateData(nv);
    }
      public boolean deleteData(ChiTietPhieuXuat nv)
    {
        return dal.deleteData(nv);
    }
         public ArrayList<ChiTietPhieuXuat> CheckID(String MaPhieuXuat,String MaXe)
    {
        return dal.getALL("", "MaPhieuXuat='"+MaPhieuXuat+ "' AND MaXe='"+MaXe+"'", "");
             
    }
}
