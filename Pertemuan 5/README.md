# Source Code
### Mahasiswa
```java
import java.util.ArrayList; 
import java.util.List;

public class Mahasiswa
{
    private String nrp;
    private String nama;
    private List<MataKuliah> daftar_matkul;

    public Mahasiswa(String nama, String nrp)
    {
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
```

### Dosen
```java
import java.util.ArrayList; 
import java.util.List;

public class Dosen
{
    private String nip;
    private String nama;
    private List<MataKuliah> daftar_ajar;

    public Dosen(String nama, String nip)
    {
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
```

### MataKuliah
```java
import java.util.ArrayList; 
import java.util.List;

public class MataKuliah
{
    private String kode;
    private String nama;
    private Dosen dosen;
    private List<Mahasiswa> daftar_mahasiswa;

    public MataKuliah(String kode, String nama, Dosen dosen)
    {
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
```

### Main
```java
public class Main
{
    public static void main(String[] args){
        Dosen dosen1 = new Dosen("Fajar Baskoro", "D001");
        Dosen dosen2 = new Dosen("Rully Soelaiman", "D002");
        Dosen dosen3 = new Dosen("Viktor Hariadi", "D003");

        MataKuliah matkul1 = new MataKuliah("IF101", "Pemrograman Web", dosen1);
        MataKuliah matkul2 = new MataKuliah("IF102", "Pemrograman Berbasis Objek",  dosen1);
        MataKuliah matkul3 = new MataKuliah("IF103", "Pemrograman Berbasis Objek",  dosen2);
        MataKuliah matkul4 = new MataKuliah("IF104", "Teori Graf",  dosen3);

        Mahasiswa mhs1 = new Mahasiswa("Hanif", "5025241111");
        Mahasiswa mhs2 = new Mahasiswa("Aqil", "5025241112");
        Mahasiswa mhs3 = new Mahasiswa("Janardana", "5025241113");

        mhs1.ambilMk(matkul1);
        mhs1.ambilMk(matkul2);
        mhs2.ambilMk(matkul1);
        mhs2.ambilMk(matkul3);
        mhs3.ambilMk(matkul3);
        mhs3.ambilMk(matkul4);

        matkul1.showMhs(); 
        matkul2.showMhs();
        matkul3.showMhs();
        matkul4.showMhs();
    }
}
```
