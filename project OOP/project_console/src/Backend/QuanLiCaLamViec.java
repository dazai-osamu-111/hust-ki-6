package Backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLiCaLamViec {
    public void insert(){
        try {
            // Nhập thông tin của ca làm việc
            System.out.println("Nhập thông tin ca làm việc: ");
            Scanner inputs = new Scanner(System.in);


            System.out.print("Năm: ");
            String nam = inputs.nextLine();

            System.out.print("Tháng: ");
            String thang = inputs.nextLine();

            System.out.print("Ngày: ");
            String ngay = inputs.nextLine();

            System.out.print("Giờ bắt đầu:");
            String gioBatDau = inputs.nextLine();


            System.out.print("Giờ kết thúc:");
            String gioKetThuc = inputs.nextLine();




            CaLamViec caLamViec = new CaLamViec(nam, thang, ngay, gioBatDau, gioKetThuc);
            int check = 0;
            for(int i=0;i<App.CALAMVIEC.size();i++){
                if(checkIteration(App.CALAMVIEC.get(i),caLamViec)){
                    check++;
                }
            }
            if(check == 0){
                App.CALAMVIEC.add(caLamViec);
                System.out.println("Đã thêm ca làm việc.");
            } else{
                System.out.println("Thông tin đã tồn tại, vui lòng nhập lại");
            }



        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(){
        try {
            System.out.println("Nhập thông tin ca làm việc: ");
            Scanner inputs = new Scanner(System.in);


            System.out.print("Năm: ");
            String nam = inputs.nextLine();

            System.out.print("Tháng: ");
            String thang = inputs.nextLine();

            System.out.print("Ngày: ");
            String ngay = inputs.nextLine();

            System.out.print("Giờ bắt đầu:");
            String gioBatDau = inputs.nextLine();


            System.out.print("Giờ kết thúc:");
            String gioKetThuc = inputs.nextLine();


            CaLamViec caLamViec = new CaLamViec(nam, thang, ngay, gioBatDau, gioKetThuc);
            for(int i=0;i<App.CALAMVIEC.size();i++){
                if(checkIteration(App.CALAMVIEC.get(i),caLamViec)){
                    System.out.println("Nhập thông tin cập nhật cho ca làm việc: ");

                    System.out.print("Năm: ");
                    nam = inputs.nextLine();
                    App.CALAMVIEC.get(i).setNam(nam);

                    System.out.print("Tháng: ");
                    thang = inputs.nextLine();
                    App.CALAMVIEC.get(i).setThang(thang);

                    System.out.print("Ngày: ");
                    ngay = inputs.nextLine();
                    App.CALAMVIEC.get(i).setNgay(ngay);

                    System.out.print("Giờ bắt đầu:");
                    gioBatDau = inputs.nextLine();
                    App.CALAMVIEC.get(i).setGioBatDau(gioBatDau);


                    System.out.print("Giờ kết thúc:");
                    gioKetThuc = inputs.nextLine();
                    App.CALAMVIEC.get(i).setGioKetThuc(gioKetThuc);

                    System.out.println("Đã cập nhật thông tin thành công");
                    return;
                }
            }

            System.out.println("Không tìm thấy ca làm việc này");

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(){
        try {
            System.out.println("Nhập thông tin ca làm việc: ");
            Scanner inputs = new Scanner(System.in);


            System.out.print("Năm: ");
            String nam = inputs.nextLine();

            System.out.print("Tháng: ");
            String thang = inputs.nextLine();

            System.out.print("Ngày: ");
            String ngay = inputs.nextLine();

            System.out.print("Giờ bắt đầu:");
            String gioBatDau = inputs.nextLine();


            System.out.print("Giờ kết thúc:");
            String gioKetThuc = inputs.nextLine();


            CaLamViec caLamViec = new CaLamViec(nam, thang, ngay, gioBatDau, gioKetThuc);
            for(int i=0;i<App.CALAMVIEC.size();i++){
                if(checkIteration(App.CALAMVIEC.get(i),caLamViec)){
                    App.CALAMVIEC.remove(i);
                    System.out.println("Đã xóa thông tin ca làm việc");
                    return;
                }
            }
            System.out.println("Không tìm thấy thông tin ca làm việc, vui lòng nhập lại.");




        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show(){
        System.out.println("Danh sách ca làm việc:");
        String header = String.format("%-20s%-20s%-20s", "Ngày", "Giờ bắt đầu", "Giờ kết thúc");
        System.out.println(header);
        for(int i=0;i<App.CALAMVIEC.size();i++){
            String stringNgay = String.format("%s-%s-%s", App.CALAMVIEC.get(i).getNam(),App.CALAMVIEC.get(i).getThang(),
                    App.CALAMVIEC.get(i).getNgay() );
            String row = String.format("%-20s%-20s%-20s", stringNgay, App.CALAMVIEC.get(i).getGioBatDau(), App.CALAMVIEC.get(i).getGioKetThuc());
            System.out.println(row);
        }
    }

    public boolean checkIteration(CaLamViec c1, CaLamViec c2){
        if(c1.getNam().equals(c2.getNam()) && c1.getThang().equals(c2.getThang()) && c1.getNgay().equals(c2.getNgay())
        && c1.getGioKetThuc().equals(c2.getGioKetThuc()) && c1.getGioBatDau().equals(c2.getGioBatDau())){
            return true;
        } else return false;
    }

}
