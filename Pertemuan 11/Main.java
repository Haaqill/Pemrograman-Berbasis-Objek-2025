import java.util.Scanner;


public class Main
{
    public static void main(String[] args) {
        Penyewaan penyewaan = new Penyewaan();
        Mobil mobil1 = new Mobil("Toyota", "Avanza", 2013, 4);
        Mobil mobil2 = new Mobil("Honda", "Mobilio", 2014, 4);

        Motor motor1 = new Motor("Honda", "Beat", 2015, 2);
        Motor motor2 = new Motor("Yamaha", "Mio", 2016, 2);

        Sepeda sepeda1 = new Sepeda("Polygon", "Path 2 700C", 2016, "Hybrid");
        Sepeda sepeda2 = new Sepeda("United", "Sterling R1 700C", 2016, "Balap");

        penyewaan.tambahKendaraan(mobil1);
        penyewaan.tambahKendaraan(mobil2);
        penyewaan.tambahKendaraan(motor1);
        penyewaan.tambahKendaraan(motor2);
        penyewaan.tambahKendaraan(sepeda1);
        penyewaan.tambahKendaraan(sepeda2);

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        while (!quit) {
            System.out.println("\n=== Rental Kendaraan ===");
            System.out.println("1. Lihat daftar kendaraan");
            System.out.println("2. Lihat daftar penyewa");
            System.out.println("3. Tambah penyewa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            System.out.println();
            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    penyewaan.showKendaraan();
                    break;

                case 2:
                    penyewaan.showPenyewa();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Merk kendaraan: ");
                    String k = scanner.nextLine();
                    boolean found = false;
                    for (int i=0; i<penyewaan.list_kendaraan.size(); i++)
                        if(k.equals(penyewaan.list_kendaraan.get(i).getMerk())){
                            Penyewa penyewa = new Penyewa(nama, penyewaan.list_kendaraan.get(i));
                            penyewaan.tambahPenyewa(penyewa);
                            found = true;
                            break;
                        }
                    if(!found){
                        System.out.println("Merk tidak ditemukan");
                    }
                    break;

                case 0:
                    quit = true;
                    break;
            
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    break;
            }

        }

        scanner.close();
    }
}