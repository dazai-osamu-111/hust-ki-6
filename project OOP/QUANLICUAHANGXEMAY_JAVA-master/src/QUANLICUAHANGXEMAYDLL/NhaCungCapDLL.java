/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.NhaCungCapDAL;
import QUANLICUAHANGXEMAYEntity.NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class NhaCungCapDLL extends NhaCungCapDAL {

    NhaCungCapDAL dal = new NhaCungCapDAL();

    public ArrayList<NhaCungCap> getALL(String TOP, String WHERE, String ORDER) {
        return dal.getALL(TOP, WHERE, ORDER);
    }

    public boolean AddData(NhaCungCap nv) {
        return dal.AddData(nv);
    }

    public boolean updateData(NhaCungCap nv) {
        return dal.updateData(nv);
    }

    public boolean deleteData(NhaCungCap nv) {
        return dal.deleteData(nv);
    }

    public ArrayList<NhaCungCap> CheckID(String ID) {
        return dal.getALL("", "MaNhaCC='" + ID + "'", "");
    }

    public int CountDb() {
        return dal.CountDb();
    }
}
