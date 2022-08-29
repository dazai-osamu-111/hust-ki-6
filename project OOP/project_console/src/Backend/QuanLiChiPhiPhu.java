package Backend;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLiChiPhiPhu {
    public void insert(){
        try {
            System.out.println("Nhập thông tin chi phi phu: ");
            Scanner inputs = new Scanner(System.in);

            System.out.print("Nhập tên chi phi phu: ");
            String tenCPP = inputs.nextLine();

            System.out.print("Nhap tien phi ");
            Integer tienPhi = inputs.nextInt();

            inputs.nextLine();

            System.out.print("Nhap ngay: ");
            String ngay = inputs.nextLine();

            System.out.print("Nhap thang: ");
            String thang = inputs.nextLine();

            System.out.print("Nhap nam: ");
            String nam = inputs.nextLine();
            ChiPhiPhu chiphiphu = new ChiPhiPhu(tenCPP,tienPhi, ngay, thang, nam);
            int check = 0;
            for(int i=0;i<App.CHIPHIPHU.size();i++) {
                if (checkIteration(App.CHIPHIPHU.get(i), chiphiphu)) {
                    check++;
                }
            } if(check == 0){
                App.CHIPHIPHU.add(chiphiphu);
                System.out.println("Đã thêm thành công.");
            } else{
                System.out.println("Thông tin đã tồn tại, vui lòng nhập lại");
            }
        }catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(){
        try {
            System.out.println("Nhập thông tin chi phi phu: ");
            Scanner inputs = new Scanner(System.in);

            System.out.print("Nhập tên chi phi phu: ");
            String tenCPP = inputs.nextLine();

            System.out.print("Nhap ngay: ");
            String ngay = inputs.nextLine();

            System.out.print("Nhap thang: ");
            String thang = inputs.nextLine();

            System.out.print("Nhap nam: ");
            String nam = inputs.nextLine();

            Integer tien = 0;

            ChiPhiPhu chiphiphu = new ChiPhiPhu(tenCPP,tien, ngay, thang, nam);
            int check = 0;
            for(int i=0;i<App.CHIPHIPHU.size();i++){
                if(checkIteration(App.CHIPHIPHU.get(i), chiphiphu)){
                    System.out.println("Nhập thông tin cap nhat cho chi phi phu: ");

                    System.out.print("Nhập tên chi phi phu: ");
                    tenCPP = inputs.nextLine();
                    App.CHIPHIPHU.get(i).setTenCP(tenCPP);

                    System.out.print("Nhap ngay: ");
                    ngay = inputs.nextLine();
                    App.CHIPHIPHU.get(i).setNgay(ngay);

                    System.out.print("Nhap thang: ");
                    thang = inputs.nextLine();
                    App.CHIPHIPHU.get(i).setThang(thang);

                    System.out.print("Nhap nam: ");
                    nam = inputs.nextLine();
                    App.CHIPHIPHU.get(i).setNam(nam);


                    System.out.println("Đã cập nhật thông tin thành công");
                    return;
                }
            }

            System.out.println("Không tìm thấy chi phi phu nay");

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(){
        try {
            System.out.println("Nhập thông tin chi phi phu: ");
            Scanner inputs = new Scanner(System.in);

            System.out.print("Nhập tên chi phi phu: ");
            String tenCPP = inputs.nextLine();

            System.out.print("Nhap ngay: ");
            String ngay = inputs.nextLine();

            System.out.print("Nhap thang: ");
            String thang = inputs.nextLine();

            System.out.print("Nhap nam: ");
            String nam = inputs.nextLine();

            Integer tien = 0;

            ChiPhiPhu chiphiphu = new ChiPhiPhu(tenCPP,tien, ngay, thang, nam);
            int check = 0;

            for(int i=0;i<App.CHIPHIPHU.size();i++){
                if(checkIteration(App.CHIPHIPHU.get(i), chiphiphu)){
                    App.CHIPHIPHU.remove(i);
                    System.out.println("Đã xóa thông tin chi phi phu do");
                    return;
                }
            }
            System.out.println("Không tìm thấy thông tin chi phi phu nay");




        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void show(){
        System.out.println("Danh sách chi phi phu");
        String header = String.format("%-20s%-20s%-20s%-20s%-20s", "TenCPP", "Tien", "Ngay", "Thang", "Nam");
        System.out.println(header);
        for(int i=0;i<App.CHIPHIPHU.size();i++){
            String row = String.format("%-20s %-20d %-20s %-20s %-20s\n", App.CHIPHIPHU.get(i).getTenCP(), App.CHIPHIPHU.get(i).getTien(),
                    App.CHIPHIPHU.get(i).getNgay(), App.CHIPHIPHU.get(i).getThang(), App.CHIPHIPHU.get(i).getNam());
            System.out.println(row);
        }
    }

    public boolean checkIteration(ChiPhiPhu cpp1, ChiPhiPhu cpp2){
        if(cpp1.getTenCP().equals(cpp2.getTenCP()) && cpp1.getNgay().equals(cpp2.getNgay())  && cpp1.getThang().equals(cpp2.getThang())  && cpp1.getNam().equals(cpp2.getNam())){
            return true;
        } else {
            return false;
        }
    }
}
