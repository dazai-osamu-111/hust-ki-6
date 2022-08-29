package Backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NhapXuatDuLieu {
//    public static List<Quan> SANPHAMQUAN = new ArrayList<Quan>();
//    public static List<Ao> SANPHAMAO = new ArrayList<Ao>();
//    public static List<Giay> SANPHAMGIAY = new ArrayList<Giay>();
//    public static List<NhanVien> NHANVIEN = new ArrayList<NhanVien>();
//    public static List<CaLamViec> CALAMVIEC =  new ArrayList<CaLamViec>();
//    public static List<DangKiCaLamViec> DANGKICALAMVIEC = new ArrayList<DangKiCaLamViec>();
//    public static List<DangKiCaLamViec> CONG = new ArrayList<DangKiCaLamViec>();
//    public static List<HoaDon> HOADON = new ArrayList<HoaDon>();
//    public static List<ChiPhiPhu> CHIPHIPHU = new ArrayList<ChiPhiPhu>();
    public void OutputQuan(){
        try{
            FileOutputStream fos = new FileOutputStream("Quan.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i=0;i<App.SANPHAMQUAN.size();i++){
                oos.writeObject(App.SANPHAMQUAN.get(i));
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void InputQuan(){
        try{
            FileInputStream fis = new FileInputStream("Quan.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(fis.available() > 0){
                App.SANPHAMQUAN.add((Quan)ois.readObject());
            }


            fis.close();
            ois.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void OutputAo(){
        try{
            FileOutputStream fos = new FileOutputStream("Ao.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i=0;i<App.SANPHAMAO.size();i++){
                oos.writeObject(App.SANPHAMAO.get(i));
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void InputAo(){
        try{
            FileInputStream fis = new FileInputStream("Ao.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = new Object();
            while(fis.available() > 0){
                obj = (Ao)ois.readObject();
                App.SANPHAMAO.add((Ao) obj);
            }


            fis.close();
            ois.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}