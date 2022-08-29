package Backend;

public class NhanVien {
    private String tenNV, sđt;
    private Integer luong;

    public NhanVien(String tenNV, String sđt, Integer luong) {
        this.tenNV = tenNV;
        this.sđt = sđt;
        this.luong = luong;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        this.luong = luong;
    }
}
