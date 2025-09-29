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