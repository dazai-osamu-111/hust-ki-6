package Backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLiSanPhamGiay {
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

            System.out.print("Kiểu cổ giày: ");
            String kieuCoGiay = inputs.nextLine();

            System.out.print("Dịp: ");
            String dip = inputs.nextLine();

            System.out.print("Loại giày: ");
            String loaiGiay = inputs.nextLine();

            System.out.println("Ngày nhập: ");
            String ngayNhap = inputs.nextLine();

            System.out.println("Tháng nhập: ");
            String thangNhap = inputs.nextLine();

            System.out.println("Năm nhập: ");
            String namNhap = inputs.nextLine();



            Giay giay = new Giay(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu,
                    kieuCoGiay, dip, loaiGiay, ngayNhap, thangNhap, namNhap);

            for(int i=0;i<App.SANPHAMGIAY.size();i++){
                if(checkIteration(App.SANPHAMGIAY.get(i), giay)){
                    int soluong = App.SANPHAMGIAY.get(i).getSoLuong();
                    App.SANPHAMGIAY.get(i).setSoLuong(soluong + soLuong);
                    System.out.println("Đã thêm sản phẩm thành công.");
                    return;
                }
            }

            App.SANPHAMGIAY.add(giay);
            System.out.println("Đã thêm sản phẩm thành công.");


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    public void show(){
        System.out.println("Danh sách các sản phẩm Giay.");
        String header = String.format("%-5s%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s","STT",
                "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                "Kiểu cổ giày", "Dịp", "Loại Giày", "Ngày nhập");
        System.out.println(header);
        int i = 0;
        for(Giay g : App.SANPHAMGIAY){
            String row = String.format("%-5d%-20s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s%s-%s-%s", i + 1,
                    g.getTenSP(), g.getGiaNhap(), g.getGiaBan(), g.getSoLuong(), g.getSize(), g.getMauSac(), g.getChatLieu()
                    , g.getXuatXu(), g.getKieuCoGiay(), g.getDip(), g.getLoaiGiay(), g.getNgayNhap(), g.getThangNhap(), g.getNamNhap());
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
            if(stt > 0 && stt <= App.SANPHAMGIAY.size()){
                System.out.println("Nhập thông tin chỉnh sửa cho sản phẩm");

                System.out.print("Nhập tên sản phẩm: ");
                String tenSP = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setTenSP(tenSP);

                System.out.print("Giá nhập: ");
                Double giaNhap = inputs.nextDouble();
                App.SANPHAMGIAY.get(stt - 1).setGiaNhap(giaNhap);

                System.out.print("Giá bán: ");
                Double giaBan = inputs.nextDouble();
                App.SANPHAMGIAY.get(stt - 1).setGiaBan(giaBan);

                System.out.print("Số lượng: ");
                Integer soLuong = inputs.nextInt();
                App.SANPHAMGIAY.get(stt - 1).setSoLuong(soLuong);


                inputs.nextLine();

                System.out.print("Size: ");
                String size = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setSize(size);

                System.out.print("Màu Sắc: ");
                String mauSac = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setMauSac(mauSac);

                System.out.print("Chất liệu:");
                String chatLieu = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setChatLieu(chatLieu);

                System.out.print("Xuất xứ:");
                String xuatXu = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setXuatXu(xuatXu);

                System.out.print("Kiểu cổ giày: ");
                String kieuCoGiay = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setKieuCoGiay(kieuCoGiay);

                System.out.print("Dịp: ");
                String dip = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setDip(dip);

                System.out.print("Loại giày: ");
                String loaiGiay = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setLoaiGiay(loaiGiay);

                System.out.println("Ngày nhập: ");
                String ngayNhap = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setNgayNhap(ngayNhap);

                System.out.println("Tháng nhập: ");
                String thangNhap = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setThangNhap(thangNhap);

                System.out.println("Năm nhập: ");
                String namNhap = inputs.nextLine();
                App.SANPHAMGIAY.get(stt - 1).setNamNhap(namNhap);


                System.out.println("Đã cập nhật sản phẩm thành công");
                return;
            } else {
                System.out.println("Số thứ tự không phù hợp.");
            }


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void delete(){
        try {
            Scanner inputs = new Scanner(System.in);
            System.out.println("Danh sách sản phẩm");
            show();
            System.out.println("Chọn số thứ tự sản phẩm cần xóa");
            int stt = inputs.nextInt();

            if(stt > 0 && stt <= App.SANPHAMGIAY.size()){
                App.SANPHAMGIAY.remove(stt -1);
                System.out.println("Đã xóa sản phẩm.");
            } else {
                System.out.println("Số thứ tự không phù hợp.");
            }


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean checkIteration(Giay g1, Giay g2){
        boolean check ;

        if(g1.getTenSP().equals(g2.getTenSP()) && g1.getGiaNhap().equals(g2.getGiaNhap()) && g1.getGiaBan().equals(g2.getGiaBan())
                 && g1.getSize().equals(g2.getSize() ) &&
                g1.getMauSac().equals(g2.getMauSac()) && g1.getChatLieu().equals(g2.getChatLieu()) &&
                g1.getXuatXu().equals(g2.getXuatXu())
                && g1.getKieuCoGiay().equals(g2.getKieuCoGiay()) && g1.getDip().equals(g2.getDip() )
                && g1.getLoaiGiay().equals(g2.getLoaiGiay())
                && g1.getNgayNhap().equals(g2.getNgayNhap()) && g1.getThangNhap().equals(g2.getThangNhap())
                && g1.getNamNhap().equals(g2.getNamNhap())){
            check = true;
        } else {
            check = false;
        }

        return check;
    }
}
