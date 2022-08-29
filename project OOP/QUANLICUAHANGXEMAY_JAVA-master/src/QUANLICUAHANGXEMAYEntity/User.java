/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYEntity;

/**
 *
 * @author duy
 */
public class User {
   private String User;
   
    private String MatKhauMoi;
    private String MaNhanVien;
    private String Quyen;

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }
    public void setUser(String User) {
        this.User = User;
    }

 

    public void setMatKhauMoi(String MatKhauMoi) {
        this.MatKhauMoi = MatKhauMoi;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }
    public String getUser() {
        return User;
    }

  

    public String getMatKhauMoi() {
        return MatKhauMoi;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }
}
