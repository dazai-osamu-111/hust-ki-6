package Backend;

public class ChiPhiPhu {
    private String tenCP;
    private Integer tien;
    private String ngay, thang, nam;


    public ChiPhiPhu(String tenCP, Integer tien, String ngay, String thang, String nam) {
        this.tenCP = tenCP;
        this.tien = tien;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public String getTenCP() {
        return tenCP;
    }

    public void setTenCP(String tenCP) {
        this.tenCP = tenCP;
    }

    public Integer getTien() {
        return tien;
    }

    public void setTien(Integer tien) {
        this.tien = tien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }
}
