import java.util.ArrayList; 
import java.util.List;

public class Mahasiswa
{
    // instance variables - replace the example below with your own
    private String nrp;
    private String nama;
    private List<MataKuliah> daftar_matkul;


    /**
     * Constructor for objects of class Mahasiswa
     */
    public Mahasiswa(String nama, String nrp)
    {
        // initialise instance variables
        this.nama = nama;
        this.nrp = nrp;
        this.daftar_matkul = new ArrayList<>();
    }

    public String getNRP(){
        return nrp;
    }

    public String getNama(){
        return nama;
    }

    public void ambilMk(MataKuliah mk){
        daftar_matkul.add(mk);
        mk.tambahMhs(this);
    }

    public void daftarMatkul(){
        System.out.println("Mata Kuliah:");
        for (MataKuliah mk : daftar_matkul){
            System.out.println(mk.getNama());
        }
    }
    
}