import java.util.ArrayList; 
import java.util.List;

public class Dosen
{
    // instance variables - replace the example below with your own
    private String nip;
    private String nama;
    private List<MataKuliah> daftar_ajar;

    /**
     * Constructor for objects of class Dosen
     */
    public Dosen(String nama, String nip)
    {
        // initialise instance variables
        this.nama = nama;
        this.nip = nip;
        this.daftar_ajar = new ArrayList<>();
    }

    public String getNIP(){
        return nip;
    }

    public String getNama(){
        return nama;
    }

    public void tambahMk(MataKuliah mk){
        daftar_ajar.add(mk);
    }

    public void daftarAjar(){
        System.out.println("Mata kuliah:");
        for (MataKuliah mk : daftar_ajar){
            System.out.println(mk.getNama());
        }
    }
}