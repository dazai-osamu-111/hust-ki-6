/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.KhachHangDAL;
import QUANLICUAHANGXEMAYEntity.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class KhachHangDLL {

    KhachHangDAL dal = new KhachHangDAL();

    public ArrayList<KhachHang> getALL(String TOP, String WHERE, String ORDER) {

        return dal.getALL(TOP, WHERE, ORDER);
    }

    public boolean AddData(KhachHang kh) {
        return dal.AddData(kh);
    }

    public boolean updateData(KhachHang kh) {
        return dal.updateData(kh);
    }

    public boolean deleteData(KhachHang kh) {
        return dal.deleteData(kh);
    }

    public ArrayList<KhachHang> CheckID(String ID) {
        return dal.getALL("", "MaKH='" + ID + "'", "");

    }

    public int CountDb() {
        return dal.CountDb();
    }
}
