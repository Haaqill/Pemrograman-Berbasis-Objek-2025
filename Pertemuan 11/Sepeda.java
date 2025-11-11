
public class Sepeda extends Kendaraan
{
    public String jenis;

    public Sepeda(String merk, String model, int tahun, String jenis){
        super(merk,model,tahun);
        this.jenis= jenis;
    }

    public String getJenis(){
        return jenis;
    }

    @Override
    public void printInfo(){
        System.out.println("Merk : " + getMerk());
        System.out.println("Model: " + getModel());
        System.out.println("Tahun: " + getTahun());
        System.out.println("Jenis: " + getJenis());
    }
}