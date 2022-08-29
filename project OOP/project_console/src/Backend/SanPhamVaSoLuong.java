package Backend;

public class SanPhamVaSoLuong {
    private Quan sanPhamQuan;
    private Ao sanPhamAo;
    private Giay sanPhamGiay;
    private Integer soLuongQuan;
    private Integer soLuongAo;
    private Integer soLuongGiay;

    public SanPhamVaSoLuong(Quan sanPhamQuan, Ao sanPhamAo, Giay sanPhamGiay, Integer soLuongQuan, Integer soLuongAo, Integer soLuongGiay) {
        this.sanPhamQuan = sanPhamQuan;
        this.sanPhamAo = sanPhamAo;
        this.sanPhamGiay = sanPhamGiay;
        this.soLuongQuan = soLuongQuan;
        this.soLuongAo = soLuongAo;
        this.soLuongGiay = soLuongGiay;
    }

    public Quan getSanPhamQuan() {
        return sanPhamQuan;
    }

    public void setSanPhamQuan(Quan sanPhamQuan) {
        this.sanPhamQuan = sanPhamQuan;
    }

    public Ao getSanPhamAo() {
        return sanPhamAo;
    }

    public void setSanPhamAo(Ao sanPhamAo) {
        this.sanPhamAo = sanPhamAo;
    }

    public Giay getSanPhamGiay() {
        return sanPhamGiay;
    }

    public void setSanPhamGiay(Giay sanPhamGiay) {
        this.sanPhamGiay = sanPhamGiay;
    }

    public Integer getSoLuongQuan() {
        return soLuongQuan;
    }

    public void setSoLuongQuan(Integer soLuongQuan) {
        this.soLuongQuan = soLuongQuan;
    }

    public Integer getSoLuongAo() {
        return soLuongAo;
    }

    public void setSoLuongAo(Integer soLuongAo) {
        this.soLuongAo = soLuongAo;
    }

    public Integer getSoLuongGiay() {
        return soLuongGiay;
    }

    public void setSoLuongGiay(Integer soLuongGiay) {
        this.soLuongGiay = soLuongGiay;
    }
}
