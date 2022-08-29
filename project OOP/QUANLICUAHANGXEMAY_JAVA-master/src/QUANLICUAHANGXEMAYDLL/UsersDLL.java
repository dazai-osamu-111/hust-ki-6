/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYDLL;

import QUANLICUAHANGXEMAYDAL.UserDAL;
import QUANLICUAHANGXEMAYEntity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author duy
 */
public class UsersDLL {

    UserDAL dal = new UserDAL();

    public boolean getLogin(String u, String p) {
        return dal.getLogin(u, p);
    }

    public ArrayList<User> getALL(String TOP, String WHERE, String ORDER) {
        return dal.getALL(TOP, WHERE, ORDER);
    }

    public boolean AddData(User nv) {
        return dal.AddData(nv);
    }

    public boolean updateData(User nv)
    {
        return dal.updateData(nv);
    }
    public String Get_MaNhanVien(String Users) throws SQLException {
        return dal.Get_MaNhanVien(Users);
    }

    public String Get_Quyen(String Users) throws SQLException {
        return dal.Get_Quyen(Users);
    }

    public boolean update_Password(User nv) {
        return dal.update_Password(nv);
    }
      public ArrayList<User> CheckID(String ID)
    {
        return dal.getALL("", "[User]='"+ID+ "'", "");
             
    }
}
