package Backend;

public class DangKiCaLamViec {
    private CaLamViec caLamViec;
    private NhanVien nhanVien;

    public DangKiCaLamViec(CaLamViec caLamViec, NhanVien nhanVien) {
        this.caLamViec = caLamViec;
        this.nhanVien = nhanVien;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
