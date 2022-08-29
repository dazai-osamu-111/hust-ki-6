/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.NhanVienDAL;
import QUANLICUAHANGXEMAYEntity.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class NhanVienDLL {

    NhanVienDAL dal = new NhanVienDAL();

    public ArrayList<NhanVien> getALL(String TOP, String WHERE, String ORDER) {
        return dal.getALL(TOP, WHERE, ORDER);
    }

    public boolean AddData(NhanVien nv) {
        return dal.AddData(nv);
    }

    public boolean updateData(NhanVien nv) {
        return dal.updateData(nv);
    }

    public boolean deleteData(NhanVien nv) {
        return dal.deleteData(nv);
    }

    public ArrayList<NhanVien> CheckID(String ID) {
        return dal.getALL("", "MaNhanVien='" + ID + "'", "");

    }

    public int CountDb() {
        return dal.CountDb();
    }
}
