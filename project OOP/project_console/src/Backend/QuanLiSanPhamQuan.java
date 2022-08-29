package Backend;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLiSanPhamQuan {


    public void insert(){
        try {
            // Nhập thông tin của sản phẩm
            System.out.println("Nhập thông tin sản phẩm: ");
            Scanner inputs = new Scanner(System.in);

            System.out.print("Nhập tên sản phẩm: ");
            String tenSP = inputs.nextLine();

            System.out.print("Giá nhập: ");
            Double giaNhap = inputs.nextDouble();

            System.out.print("Giá bán: ");
            Double giaBan = inputs.nextDouble();

            System.out.print("Số lượng: ");
            Integer soLuong = inputs.nextInt();

            inputs.nextLine();

            System.out.print("Size: ");
            String size = inputs.nextLine();

            System.out.print("Màu Sắc: ");
            String mauSac = inputs.nextLine();

            System.out.print("Chất liệu:");
            String chatLieu = inputs.nextLine();

            System.out.print("Xuất xứ:");
            String xuatXu = inputs.nextLine();

            System.out.print("Kiểu dáng quần: ");
            String kieuDangQuan = inputs.nextLine();

            System.out.print("Mẫu: ");
            String mau = inputs.nextLine();

            System.out.print("Loại Khóa: ");
            String loaiKhoa = inputs.nextLine();

            System.out.print("Phong cách: ");
            String phongCach = inputs.nextLine();

            System.out.print("Loại Quần:");
            String loaiQuan = inputs.nextLine();

            System.out.println("Ngày nhập: ");
            String ngayNhap = inputs.nextLine();

            System.out.println("Tháng nhập: ");
            String thangNhap = inputs.nextLine();

            System.out.println("Năm nhập: ");
            String namNhap = inputs.nextLine();

            Quan quan = new Quan(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu,
                    kieuDangQuan, mau, loaiKhoa, phongCach, loaiQuan, ngayNhap, thangNhap, namNhap );

            for(int i=0;i<App.SANPHAMQUAN.size();i++){
                if(checkIteration(App.SANPHAMQUAN.get(i), quan)){
                    int soluong = App.SANPHAMQUAN.get(i).getSoLuong();
                    App.SANPHAMQUAN.get(i).setSoLuong(soluong + soLuong);
                    System.out.println("Đã thêm sản phẩm thành công.");
                    return;
                }
            }

            App.SANPHAMQUAN.add(quan);
            System.out.println("Đã thêm sản phẩm thành công.");


        }   catch (InputMismatchException ei) {
        System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }

    public void show(){
        System.out.println("Danh sách các sản phẩm quần.");
        String header = String.format("%-5s%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s%-20s","STT",
                "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                "Kiểu Dáng Quần", "Mẫu", "Loại Khóa", "Phong Cách", "Loại Quần", "Ngày Nhập");
        System.out.println(header);
        int i = 0;
        for(Quan q : App.SANPHAMQUAN){
            String row = String.format("%-5d%-20s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s%s-%s-%s",
                    i+1, q.getTenSP(), q.getGiaNhap(), q.getGiaBan(), q.getSoLuong(), q.getSize(), q.getMauSac(), q.getChatLieu()
                    , q.getXuatXu(), q.getKieuDangQuan(), q.getMau(), q.getLoaiKhoa(), q.getPhongCach(), q.getLoaiQuan()
            , q.getNgayNhap(), q.getThangNhap(), q.getNamNhap());
            System.out.println(row);
            i++;
        }
    }

    public void update(){
        try {
            Scanner inputs = new Scanner(System.in);
            System.out.println("Danh sách sản phẩm");
            show();
            System.out.println("Chọn số thứ tự sản phẩm cần chỉnh sửa thông tin: ");
            int stt = inputs.nextInt();
            inputs.nextLine();
            if(stt > 0 && stt <= App.SANPHAMQUAN.size()){
                System.out.println("Nhập thông tin chỉnh sửa: ");
                System.out.print("Nhập tên sản phẩm: ");
                String tenSP = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setTenSP(tenSP);

                System.out.print("Giá nhập: ");
                Double giaNhap = inputs.nextDouble();
                App.SANPHAMQUAN.get(stt - 1).setGiaNhap(giaNhap);

                System.out.print("Giá bán: ");
                Double giaBan = inputs.nextDouble();
                App.SANPHAMQUAN.get(stt - 1).setGiaBan(giaBan);

                System.out.print("Số lượng: ");
                Integer soLuong = inputs.nextInt();
                App.SANPHAMQUAN.get(stt - 1).setSoLuong(soLuong);


                inputs.nextLine();

                System.out.print("Size: ");
                String size = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setSize(size);

                System.out.print("Màu Sắc: ");
                String mauSac = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setMauSac(mauSac);

                System.out.print("Chất liệu:");
                String chatLieu = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setChatLieu(chatLieu);

                System.out.print("Xuất xứ:");
                String xuatXu = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setXuatXu(xuatXu);

                System.out.print("Kiểu dáng quần: ");
                String kieuDangQuan = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setKieuDangQuan(kieuDangQuan);

                System.out.print("Mẫu: ");
                String mau = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setMau(mau);

                System.out.print("Loại Khóa: ");
                String loaiKhoa = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setLoaiKhoa(loaiKhoa);

                System.out.print("Phong cách: ");
                String phongCach = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setPhongCach(phongCach);

                System.out.print("Loại Quần:");
                String loaiQuan = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setLoaiQuan(loaiQuan);

                System.out.println("Ngày nhập: ");
                String ngayNhap = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setNgayNhap(ngayNhap);

                System.out.println("Tháng nhập: ");
                String thangNhap = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setThangNhap(thangNhap);

                System.out.println("Năm nhập: ");
                String namNhap = inputs.nextLine();
                App.SANPHAMQUAN.get(stt - 1).setNamNhap(namNhap);


                System.out.println("Đã cập nhật sản phẩm thành công");
            } else {
                System.out.println("Số thứ tự không phù hợp");
            }

            return;
        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }


    public void delete(){
        try{
            Scanner inputs = new Scanner(System.in);
            System.out.println("Danh sách sản phẩm");
            show();
            System.out.println("Chọn số thứ tự sản phẩm cần xóa: ");
            int stt = inputs.nextInt();
            if(stt > 0 && stt <= App.SANPHAMQUAN.size()){
                App.SANPHAMQUAN.remove(stt - 1);
                System.out.println("Đã xóa sản phẩm");
            } else {
                System.out.println("Số thứ tự không phù hợp.");
            }
            return;

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean checkIteration(Quan q1, Quan q2){
        boolean check ;
        if(q1.getTenSP().equals(q2.getTenSP())  && q1.getGiaNhap().equals(q2.getGiaNhap())  && q1.getGiaBan().equals(q2.getGiaBan())
                && q1.getSize().equals(q2.getSize())  &&
        q1.getMauSac().equals(q2.getMauSac())  && q1.getChatLieu().equals(q2.getChatLieu())  &&
                q1.getXuatXu().equals(q2.getXuatXu())
                && q1.getKieuDangQuan().equals(q2.getKieuDangQuan())  && q1.getMau().equals(q2.getMau())
                && q1.getLoaiKhoa().equals(q2.getLoaiKhoa())  &&
        q1.getPhongCach().equals(q2.getPhongCach())  && q1.getLoaiQuan().equals(q2.getLoaiQuan())
        && q1.getNgayNhap().equals(q2.getNgayNhap()) && q1.getThangNhap().equals(q2.getThangNhap())
                && q1.getNamNhap().equals(q2.getNamNhap())){
            check = true;
        } else {
            check = false;
        }

        return check;
    }
}
