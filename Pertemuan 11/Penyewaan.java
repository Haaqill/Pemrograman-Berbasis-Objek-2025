import java.util.ArrayList;

public class Penyewaan
{
    public ArrayList<Penyewa> list_penyewa;
    public ArrayList<Kendaraan> list_kendaraan;
    
    public Penyewaan(){
        this.list_penyewa = new ArrayList<>();
        this.list_kendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan kendaraan){
        this.list_kendaraan.add(kendaraan);
    }

    public void tambahPenyewa(Penyewa penyewa){
        this.list_penyewa.add(penyewa);
    }

    public void hapus(Penyewa penyewa){
        this.list_penyewa.remove(penyewa);
    }

    public void showKendaraan(){
        for (int i=0; i<list_kendaraan.size(); i++){
            list_kendaraan.get(i).printInfo();
            System.out.println();
        }
    }
    
    public void showPenyewa(){
        for (int i=0; i<list_penyewa.size(); i++){
            list_penyewa.get(i).info();
            System.out.println();
        }
    }
}