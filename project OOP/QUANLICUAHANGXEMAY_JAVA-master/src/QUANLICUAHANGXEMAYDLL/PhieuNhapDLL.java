/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.PhieuNhapDAL;
import QUANLICUAHANGXEMAYEntity.PhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class PhieuNhapDLL {
     PhieuNhapDAL dal=new PhieuNhapDAL();
    public ArrayList<PhieuNhap> getALL(String TOP, String WHERE,String ORDER)
    {
        return dal.getALL(TOP,WHERE,ORDER);
    }
    public  boolean AddData(PhieuNhap nv)
    {
        return dal.AddData(nv);
    }
     public ArrayList<PhieuNhap> CheckID(String ID)
    {
        return dal.getALL("", "MaPN='"+ID+ "'", "");
             
    }
      public  boolean updateData(PhieuNhap nv)
    {
        return dal.updateData(nv);
    }
}
