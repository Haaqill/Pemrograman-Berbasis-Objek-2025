
public class Mobil extends Kendaraan
{
    private int jumlah_roda;

    public Mobil(String merk, String model, int tahun, int roda){
        super(merk,model,tahun);
        this.jumlah_roda = roda;
    }

    public int getRoda(){
        return jumlah_roda;
    }

    @Override
    public void printInfo(){
        System.out.println("Merk : " + getMerk());
        System.out.println("Model: " + getModel());
        System.out.println("Tahun: " + getTahun());
        System.out.println("Roda: " + getRoda());
    }
}