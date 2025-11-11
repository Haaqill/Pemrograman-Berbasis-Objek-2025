public class Kendaraan
{
    private String merk;
    private String model;
    private int tahun_produksi;

    public Kendaraan(String merk, String model, int tahun){
        this.merk = merk;
        this.model = model;
        this.tahun_produksi = tahun;
    }

    public String getMerk(){
        return merk;
    }
    
    public String getModel(){
        return model;
    }

    public int getTahun(){
        return tahun_produksi;
    }

    public void printInfo(){
        System.out.println("Merk : " + merk);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun_produksi);
    }
}