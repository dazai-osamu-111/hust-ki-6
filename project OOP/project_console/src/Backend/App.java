package Backend;

import java.util.*;


public class App {

    public static List<Quan> SANPHAMQUAN = new ArrayList<Quan>();
    public static List<Ao> SANPHAMAO = new ArrayList<Ao>();
    public static List<Giay> SANPHAMGIAY = new ArrayList<Giay>();
    public static List<NhanVien> NHANVIEN = new ArrayList<NhanVien>();
    public static List<CaLamViec> CALAMVIEC =  new ArrayList<CaLamViec>();
    public static List<DangKiCaLamViec> DANGKICALAMVIEC = new ArrayList<DangKiCaLamViec>();
    public static List<DangKiCaLamViec> CONG = new ArrayList<DangKiCaLamViec>();
    public static List<HoaDon> HOADON = new ArrayList<HoaDon>();
    public static List<ChiPhiPhu> CHIPHIPHU = new ArrayList<ChiPhiPhu>();


    public static void menu(){
        System.out.println("--------------Quản lí cửa hàng bán quần áo----------------------");
        System.out.println("1. Quản lí sản phẩm.");
        System.out.println("2. Quản lí nhân viên.");
        System.out.println("3. Quản lí ca làm việc");
        System.out.println("4. Quản lí lương nhân viên");
        System.out.println("5. Bán hàng");
        System.out.println("6. Quản lí doanh thu.");
        System.out.println("7. Thoát.");
    }

    public static void menunv(){
        System.out.println("--------------Quan Lí cửa hàng bán quần áo------------------------");
        System.out.println("1. Quản lí sản phẩm.");
        System.out.println("2. Bán Hàng");
        System.out.println("3. Thoát");

    }

    public static void menu1(){
        System.out.println("--------------------Chọn loại sản phẩm------------------");
        System.out.println("1. Quần.");
        System.out.println("2. Áo.");
        System.out.println("3. Giày.");
        System.out.println("4. Thoát.");
    }

    public static void submenu1(){
        System.out.println("-----------------------Quản lí sản phẩm------------------");
        System.out.println("1. Thêm sản phẩm mới.");
        System.out.println("2. Chỉnh sửa.");
        System.out.println("3. Xóa sản phẩm.");
        System.out.println("4. Hiển thị danh sách các sản phẩm.");
        System.out.println("5. Thoát");
    }

    public static void menu2(){ // Menu để quản lí nhân viên
        System.out.println("-----------------------Quản lí nhân viên-------------------");
        System.out.println("1. Thêm nhân viên mới");
        System.out.println("2. Chỉnh sửa thông tin nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Hiển thị danh sách nhân viên");
        System.out.println("5. Thoát");
    }

    public static void menu3(){ // Menu để quản lí ca làm việc
        System.out.println("----------------------Quản lí ca làm việc-------------------");
        System.out.println("1. Thêm ca làm việc mới");
        System.out.println("2. Chỉnh sửa ca làm việc");
        System.out.println("3. Xóa ca làm việc");
        System.out.println("4. Hiển thị ca làm việc");
        System.out.println("5. Đăng kí ca làm việc");
        System.out.println("6. Thoát");
    }

    public static void menu35(){ // Menu Quản lí đăng kí ca làm việc
        System.out.println("----------------------Đăng kí ca làm việc--------------------");
        System.out.println("1. Thêm đăng kí mới");
        System.out.println("2. Sửa đăng kí");
        System.out.println("3. Xóa đăng kí");
        System.out.println("4. Hiển thị danh sách đăng kí");
        System.out.println("5. Thoát");
    }

    public static void menu4(){ // Menu Quản lí lương
        System.out.println("----------------------Quản lí lương nhân viên------------------");
        System.out.println("1. Chấm công");
        System.out.println("2. Tính lương");
        System.out.println("3. Thoát.");
    }

    public static void menu41(){
        System.out.println("----------------------Chấm công----------------------------------");
        System.out.println("1. Thêm công mới.");
        System.out.println("2. Hiển thị danh sách công.");
        System.out.println("3. Xóa công đã chấm.");
        System.out.println("4. Thoát.");
    }

    public static void menu6(){
        System.out.println("1. Hiển thị hóa đơn bán hàng");
        System.out.println("2. Quản lí các chi phí phụ");
        System.out.println("3. Tính doanh thu theo khoảng thời gian.");
        System.out.println("4. Thoát.");
    }

    public static void menu62(){
        System.out.println("1. Thêm mới");
        System.out.println("2. chỉnh sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Hiển thị");
        System.out.println("5. Thoát.");
    }

    public static void main(String args[]){
        Quan quan = new Quan("Quần âu nam", 350000.0, 550000.0, 30, "M", "Xanh navy", "Tuytsy", "VietNam", "Tepered", "Trơn", "Kéo", "Cơ bản", "Đi làm", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần âu nam", 350000.0, 550000.0, 30, "L", "Be", "Tuytsy", "VietNam", "Tepered", "Trơn", "Kéo", "Cơ bản", "Đi làm", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần âu nam", 350000.0, 550000.0, 30, "XL", "Đen", "Tuytsy", "VietNam", "Tepered", "Trơn", "Kéo", "Cơ bản", "Đi làm", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần âu nam", 350000.0, 550000.0, 25, "XL", "Be", "Tuytsy", "VietNam", "Tepered", "Trơn", "Kéo", "Cơ bản", "Đi làm", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần jean", 330000.0, 450000.0, 30, "M", "Xanh nhạt", "Denim", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi chơi", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần jean", 330000.0, 450000.0, 25, "L", "Xanh đậm", "Denim", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi chơi", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần jean", 330000.0, 450000.0, 30, "M", "Xanh đậm", "Denim", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi chơi", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần kaki", 320000.0, 420000.0, 40, "M", "Đen", "Kaki", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi học", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần kaki", 320000.0, 420000.0, 40, "M", "Xám", "Kaki", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi học", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);
        quan = new Quan("Quần kaki", 320000.0, 420000.0, 40, "S", "Xám", "Kaki", "TrungQuoc", "Baggy", "Trơn", "Kéo", "Cơ bản", "Đi học", "20", "07", "2021");
        App.SANPHAMQUAN.add(quan);




        Ao ao1 =new Ao("Ao phong nam",200000.0,280000.0,20,"S","Đen","Cotton","VietNam","Cổ tròn","Trơn","Lỡ tay","Oversize", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao phong nam",200000.0,280000.0,30,"M","Đen","Cotton","VietNam","Cổ tròn","Trơn","Lỡ tay","Oversize", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao phong nam",200000.0,280000.0,25,"L","Đen","Cotton","VietNam","Cổ tròn","Trơn","Lỡ tay","Oversize", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao polo phoi vien",190000.0,330000.0,40,"M","Trắng","Cotton","VietNam","Có cổ","Trơn","Ngắn tay","Bó body", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao polo phoi vien",190000.0,330000.0,45,"L","Be","Cotton","VietNam","Có cổ","Trơn","Ngắn tay","Bó body", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao so mi dai tay",250000.0,450000.0,30,"M","Xanh","Cotton","VietNam","Có cổ","Trơn","Dài tay","Relax", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao so mi dai tay",250000.0,450000.0,30,"L","Trắng","Cotton","VietNam","Có cổ","Trơn","Dài tay","Relax", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao so mi ngan tay",150000.0,200000.0,35,"S","Xanh","Cotton","TrungQuoc","Có cổ","Trơn","Ngắn tay","Relax", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao so mi ngan tay",150000.0,200000.0,32,"M","Be","Cotton","TrungQuoc","Có cổ","Trơn","Ngắn tay","Relax", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);
        ao1 =new Ao("Ao so mi ngan tay",150000.0,200000.0,40,"L","Đen","Cotton","TrungQuoc","Có cổ","Trơn","Ngắn tay","Relax", "21", "07", "2022");
        App.SANPHAMAO.add(ao1);


        Giay giay1 = new Giay("Thể thao nam",400000.0,800000.0,30,"40","trắng","Da PU","Trung Quốc","Nam","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Thể thao nam",400000.0,800000.0,30,"41","trắng","Da PU","Trung Quốc","Nam","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Thể thao nam",400000.0,800000.0,30,"41","Xanh","Da PU","Trung Quốc","Nam","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Thể thao nam",400000.0,800000.0,30,"41","Đen","Da PU","Trung Quốc","Nam","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Thể thao nữ",400000.0,800000.0,32,"38","Xanh","Da PU","Trung Quốc","Nữ","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Thể thao nữ",400000.0,800000.0,32,"38","Trắng","Da PU","Trung Quốc","Nữ","Chạy bộ","Khóa dây", "22", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Giày da nam",500000.0,950000.0,25,"42","Nâu","Da bò","Việt Nam","Nam","sự kiện","Đốc cổ thấp", "25", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Giày da nam",500000.0,950000.0,25,"41","Nâu","Da bò","Việt Nam","Nam","sự kiện","Đốc cổ thấp", "25", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Giày da nam",500000.0,950000.0,28,"42","Đen","Da bò","Việt Nam","Nam","sự kiện","Đốc cổ thấp", "25", "07", "2022");
        App.SANPHAMGIAY.add(giay1);
        giay1 = new Giay("Giày da nam",500000.0,950000.0,27,"41","Đen","Da bò","Việt Nam","Nam","sự kiện","Đốc cổ thấp", "25", "07", "2022");
        App.SANPHAMGIAY.add(giay1);





        NhanVien nhanvien1= new NhanVien("Trịnh Quốc Công","13213654",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new  NhanVien("Lê Văn Anh Vũ","46546545",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new  NhanVien("Nguyễn Anh Tú","61315645",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Nguyễn Gia Lộc","79874513",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Hà Văn Đức","16546546",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Hà Công Tuấn","16548898",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Lê Đình Tuyên","16879878",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Hoàng Quốc Bảo","46513215",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Vũ Minh Hải","46546545",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Bùi Tôn Điệp","46841516",20000);
        App.NHANVIEN.add(nhanvien1);
        nhanvien1= new NhanVien("Trần Huy Hoàng","13548988",20000);
        App.NHANVIEN.add(nhanvien1);





        CaLamViec calamviec1 = new CaLamViec("2022","06","10","07","12");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","10","12","17");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","10","17","22");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","11","07","12");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","11","12","17");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","11","17","22");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","12","07","12");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","12","12","17");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","12","17","22");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","13","07","12");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","13","12","17");
        App.CALAMVIEC.add(calamviec1);
        calamviec1 = new CaLamViec("2022","06","13","17","22");
        App.CALAMVIEC.add(calamviec1);



        ChiPhiPhu chiphiphu1 =  new ChiPhiPhu("TienNha",1500000,"05","04","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("DienNuoc",650000,"05","04","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("SuaChua",1300000,"05","04","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("TienNha",1500000,"05","05","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("DienNuoc",500000,"05","05","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("SuaChua",500000,"05","05","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("TienNha",1500000,"05","06","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("DienNuoc",750000,"05","06","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("TienNha",1500000,"05","07","2022");
        App.CHIPHIPHU.add(chiphiphu1);
        chiphiphu1 =  new ChiPhiPhu("DienNuoc",850000,"05","07","2022");
        App.CHIPHIPHU.add(chiphiphu1);



        Scanner inputtkmk = new Scanner(System.in);
        String tk = "";
        String mk = "";
        System.out.print("Nhập tài khoản: ");
        tk = inputtkmk.nextLine();
        System.out.print("Nhập mật khẩu: ");
        mk = inputtkmk.nextLine();

        if(tk.equals("NhanVien") && mk.equals("NhanVien")){

            int function = 0, function1 = 0, subFunction1 = 0/* cho sản phẩm quần*/;
            int subFunction2 = 0; // cho sản phẩm áo
            int subFunction3 = 0; // cho sản phẩm Giay

            do {
                // Menu cấp 1
                menunv();
                Scanner inputs = new Scanner(System.in);

                try {
                    System.out.print("Chọn chức năng: ");
                    function = inputs.nextInt();


                    switch (function) {

                        case 1:

                            // Quản lí sản phẩm
                            do {
                                menu1();// Menu cho phần chọn loại sản phẩm trong chức năng quản lí sản phẩm
                                Scanner input1s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    function1 = input1s.nextInt();


                                    switch (function1) {

                                        case 1: // Đã test xong
                                            // sản phẩm quần
                                            QuanLiSanPhamQuan qlspQuan = new QuanLiSanPhamQuan();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput1s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction1 = subinput1s.nextInt();


                                                    switch (subFunction1) {

                                                        case 1: // Thêm sản phẩm quần
                                                            qlspQuan.insert();
                                                            break;
                                                        case 2:
                                                            qlspQuan.update();
                                                            break;
                                                        case 3:
                                                            qlspQuan.delete();
                                                            break;
                                                        case 4:
                                                            qlspQuan.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction1 != 5);

                                            break;

                                        case 2:
                                            //Sản phẩm áo
                                            QuanLiSanPhamAo qlspAo = new QuanLiSanPhamAo();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput2s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction2 = subinput2s.nextInt();


                                                    switch (subFunction2) {

                                                        case 1: // Thêm sản phẩm áo
                                                            qlspAo.insert();
                                                            break;
                                                        case 2:
                                                            qlspAo.update();
                                                            break;
                                                        case 3:
                                                            qlspAo.delete();
                                                            break;
                                                        case 4:
                                                            qlspAo.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction2 != 5);

                                            break;
                                        case 3:
                                            // sản phẩm Giay
                                            QuanLiSanPhamGiay qlspGiay = new QuanLiSanPhamGiay();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput3s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction3 = subinput3s.nextInt();


                                                    switch (subFunction3) {

                                                        case 1: // Thêm sản phẩm quần
                                                            qlspGiay.insert();
                                                            break;
                                                        case 2:
                                                            qlspGiay.update();
                                                            break;
                                                        case 3:
                                                            qlspGiay.delete();
                                                            break;
                                                        case 4:
                                                            qlspGiay.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction3 != 5);

                                            break;

                                        default:
                                            break;

                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }


                            } while (function1 != 4);

                            break;

                        case 2:
                            QuanLiHoaDon qlhd = new QuanLiHoaDon();
                            qlhd.insert();
                            break;

                        default:
                            break;

                    }

                } catch (InputMismatchException ei) {
                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            } while (function != 3);


            System.out.println("Kết thúc.");

        }

        if(tk.equals("QuanLi") && mk.equals("QuanLi")) {



            int function = 0, function1 = 0, subFunction1 = 0/* cho sản phẩm quần*/;
            int subFunction2 = 0; // cho sản phẩm áo
            int subFunction3 = 0; // cho sản phẩm Giay

            do {
                // Menu cấp 1
                menu();
                Scanner inputs = new Scanner(System.in);

                try {
                    System.out.print("Chọn chức năng: ");
                    function = inputs.nextInt();


                    switch (function) {

                        case 1:

                            // Quản lí sản phẩm
                            do {
                                menu1();// Menu cho phần chọn loại sản phẩm trong chức năng quản lí sản phẩm
                                Scanner input1s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    function1 = input1s.nextInt();


                                    switch (function1) {

                                        case 1: // Đã test xong
                                            // sản phẩm quần
                                            QuanLiSanPhamQuan qlspQuan = new QuanLiSanPhamQuan();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput1s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction1 = subinput1s.nextInt();


                                                    switch (subFunction1) {

                                                        case 1: // Thêm sản phẩm quần
                                                            qlspQuan.insert();
                                                            break;
                                                        case 2:
                                                            qlspQuan.update();
                                                            break;
                                                        case 3:
                                                            qlspQuan.delete();
                                                            break;
                                                        case 4:
                                                            qlspQuan.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction1 != 5);

                                            break;

                                        case 2:
                                            //Sản phẩm áo
                                            QuanLiSanPhamAo qlspAo = new QuanLiSanPhamAo();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput2s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction2 = subinput2s.nextInt();


                                                    switch (subFunction2) {

                                                        case 1: // Thêm sản phẩm áo
                                                            qlspAo.insert();
                                                            break;
                                                        case 2:
                                                            qlspAo.update();
                                                            break;
                                                        case 3:
                                                            qlspAo.delete();
                                                            break;
                                                        case 4:
                                                            qlspAo.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction2 != 5);

                                            break;
                                        case 3:
                                            // sản phẩm Giay
                                            QuanLiSanPhamGiay qlspGiay = new QuanLiSanPhamGiay();
                                            do {
                                                submenu1(); // Menu cấp cho phần quản lí sản phẩm
                                                Scanner subinput3s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    subFunction3 = subinput3s.nextInt();


                                                    switch (subFunction3) {

                                                        case 1: // Thêm sản phẩm quần
                                                            qlspGiay.insert();
                                                            break;
                                                        case 2:
                                                            qlspGiay.update();
                                                            break;
                                                        case 3:
                                                            qlspGiay.delete();
                                                            break;
                                                        case 4:
                                                            qlspGiay.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (subFunction3 != 5);

                                            break;

                                        default:
                                            break;

                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }


                            } while (function1 != 4);

                            break;
                        case 2: // Đã test xong
                            int functionNV = 0; // cho nhân viên
                            QuanliNhanVien qlnv = new QuanliNhanVien();
                            do {
                                menu2();
                                Scanner input2s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    functionNV = input2s.nextInt();
                                    switch (functionNV) {
                                        case 1:
                                            qlnv.insert();
                                            break;
                                        case 2:
                                            qlnv.update();
                                            break;
                                        case 3:
                                            qlnv.delete();
                                            break;
                                        case 4:
                                            qlnv.show();
                                            break;
                                        default:
                                            break;
                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (functionNV != 5);

                            break;
                        case 3:
                            int functionCLV = 0; // cho nhân viên
                            QuanLiCaLamViec qlclv = new QuanLiCaLamViec();
                            QuanLiDangKiCaLamViec qldkclv = new QuanLiDangKiCaLamViec();
                            do {
                                menu3();
                                Scanner input3s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    functionCLV = input3s.nextInt();
                                    switch (functionCLV) {
                                        case 1:
                                            qlclv.insert();
                                            break;
                                        case 2:
                                            qlclv.update();
                                            break;
                                        case 3:
                                            qlclv.delete();
                                            break;
                                        case 4:
                                            qlclv.show();
                                            break;
                                        case 5: // Quản lí đăng kí ca làm việc
                                            Integer functionQLDKCLV = 0;
                                            do {
                                                menu35();// menu quản lí đăng kí ca làm việc
                                                Scanner input35s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    functionQLDKCLV = input35s.nextInt();


                                                    switch (functionQLDKCLV) {
                                                        case 1: // Thêm sản phẩm quần
                                                            qldkclv.insert();
                                                            break;
                                                        case 2:
                                                            qldkclv.update();
                                                            break;
                                                        case 3:
                                                            qldkclv.delete();
                                                            break;
                                                        case 4:
                                                            qldkclv.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (functionQLDKCLV != 5);

                                            break;
                                        default:
                                            break;
                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (functionCLV != 6);
                            break;
                        case 4:
                            Integer functionCC = 0;
                            QuanLiChamCong qlcc = new QuanLiChamCong();
                            do {
                                menu4(); // Menu cấp cho phần quản lí sản phẩm
                                Scanner subinput4s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    functionCC = subinput4s.nextInt();


                                    switch (functionCC) {

                                        case 1: // Quản lí chấm công
                                            Integer functionChamCong = 0;
                                            do {
                                                menu41();// menu quản lí đăng kí ca làm việc
                                                Scanner input41s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    functionChamCong = input41s.nextInt();


                                                    switch (functionChamCong) {
                                                        case 1: // Thêm sản phẩm quần
                                                            qlcc.insert();
                                                            break;
                                                        case 2:
                                                            qlcc.show();
                                                            break;
                                                        case 3:
                                                            qlcc.delete();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (functionChamCong != 4);

                                            break;
                                        case 2: // Tính lương nhân viên
                                            qlcc.tinhLuong();
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            break;
                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (functionCC != 3);
                            break;
                        case 5:
                            QuanLiHoaDon qlhd = new QuanLiHoaDon();
                            qlhd.insert();
                            break;
                        case 6:
                            QuanLiHoaDon qlhd6 = new QuanLiHoaDon();
                            QuanLiChiPhiPhu qlcpp = new QuanLiChiPhiPhu();
                            QuanLiDoanhThu qldtobj = new QuanLiDoanhThu();
                            Integer functionQldt = 0;
                            do {
                                menu6();// menu quản lí doanh thu
                                Scanner input6s = new Scanner(System.in);
                                try {
                                    System.out.print("Chọn chức năng: ");
                                    functionQldt = input6s.nextInt();


                                    switch (functionQldt) {
                                        case 1: // Hiển thị hóa đơn
                                            qlhd6.show();
                                            break;
                                        case 2: // Quản lí chi phí phụ
                                            Integer functionCPP = 0;
                                            do {
                                                menu62();// menu quản lí chi phí phụ
                                                Scanner input62s = new Scanner(System.in);
                                                try {
                                                    System.out.print("Chọn chức năng: ");
                                                    functionCPP = input62s.nextInt();


                                                    switch (functionCPP) {
                                                        case 1: // Thêm sản phẩm quần
                                                            qlcpp.insert();
                                                            break;
                                                        case 2:
                                                            qlcpp.update();
                                                            break;
                                                        case 3:
                                                            qlcpp.delete();
                                                            break;
                                                        case 4:
                                                            qlcpp.show();
                                                            break;
                                                        default:
                                                            break;

                                                    }

                                                } catch (InputMismatchException ei) {
                                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }


                                            } while (functionCPP != 5);
                                            break;
                                        case 3:
                                            qldtobj.show();
                                            break;
                                        default:
                                            break;

                                    }

                                } catch (InputMismatchException ei) {
                                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (functionQldt != 4);
                        default:
                            break;

                    }

                } catch (InputMismatchException ei) {
                    System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            } while (function != 7);


            System.out.println("Kết thúc.");
        }
    }
}
