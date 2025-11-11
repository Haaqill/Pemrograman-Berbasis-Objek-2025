
public class Penyewa
{
    private String nama;
    private Kendaraan kendaraan;

    public Penyewa(String nama, Kendaraan kendaraan){
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public void info(){
        System.err.println("Nama penyewa: " + nama);
        System.err.println("Informasi kendaraan");
        kendaraan.printInfo();
    }
}