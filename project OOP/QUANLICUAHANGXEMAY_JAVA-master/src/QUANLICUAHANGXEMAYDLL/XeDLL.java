/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.XeDAL;
import QUANLICUAHANGXEMAYEntity.Xe;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class XeDLL {

    XeDAL dal = new XeDAL();

    public ArrayList<Xe> getALL(String TOP, String WHERE, String ORDER) {
        return dal.getALL(TOP, WHERE, ORDER);
    }

    public boolean AddData(Xe nv) {
        return dal.AddData(nv);
    }

    public boolean updateData(Xe nv) {
        return dal.updateData(nv);
    }

    public boolean deleteData(Xe nv) {
        return dal.deleteData(nv);
    }

    public ArrayList<Xe> CheckID(String ID) {
        return dal.getALL("", "MaXe='" + ID + "'", "");

    }

    public int CountDb() {
        return dal.CountDb();
    }

}
