import java.util.ArrayList; 
import java.util.List;

public class MataKuliah
{
    // instance variables - replace the example below with your own
    private String kode;
    private String nama;
    private Dosen dosen;
    private List<Mahasiswa> daftar_mahasiswa;

    /**
     * Constructor for objects of class MataKuliah
     */
    public MataKuliah(String kode, String nama, Dosen dosen)
    {
        // initialise instance variables
        this.kode = kode;
        this.nama = nama;
        this.dosen = dosen;
        this.daftar_mahasiswa = new ArrayList<>();
        dosen.tambahMk(this);
    }

    public String getKode(){
        return kode;
    }

    public String getNama(){
        return nama;
    }

    public String getDosen(){
        return dosen.getNama();
    }

    public void tambahMhs(Mahasiswa mhs){
        daftar_mahasiswa.add(mhs);
    }

    public void showMhs(){
        System.out.println("====" + this.nama + "====");
        System.out.println("Dosen pengajar: " + this.getDosen());
        System.out.println("Daftar mahasiswa:");
        System.out.println("NRP | Nama");
        for (Mahasiswa mhs : daftar_mahasiswa){
            System.out.println(mhs.getNRP() + "|" + mhs.getNama());
        }
        System.out.println();
    }

}