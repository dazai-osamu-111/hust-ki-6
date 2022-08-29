/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.PhieuXuatDAL;
import QUANLICUAHANGXEMAYEntity.PhieuXuat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class PhieuXuatDLL {
     PhieuXuatDAL dal=new PhieuXuatDAL();
    public ArrayList<PhieuXuat> getALL(String TOP, String WHERE,String ORDER)
    {
        return dal.getALL(TOP,WHERE,ORDER);
    }
    public  boolean AddData(PhieuXuat nv)
    {
        return dal.AddData(nv);
    }
     public ArrayList<PhieuXuat> CheckID(String ID)
    {
        return dal.getALL("", "MaPhieuXuat='"+ID+ "'", "");
             
    }
      public  boolean updateData(PhieuXuat nv)
    {
        return dal.updateData(nv);
    }
       public int Get_SoLuong(String MaXe) {
        return dal.Get_SoLuong(MaXe);
    }
}
