import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class VendingMachine
{
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem("Kopi", 10, 9000);
        inventory.addItem("Teh", 10, 5000);
        inventory.addItem("Air Mineral", 10, 4000);
        inventory.addItem("Roti", 10, 10000);
        inventory.addItem("Biskuit", 10, 5000);
        inventory.addItem("Susu", 10, 8000);
        boolean finished = false;
        int choice;
        int confirm;
        int uang;
        String transaksi;
        FileWriter log = new FileWriter("log.txt", true);
        Scanner scanner = new Scanner(System.in);
        while (!finished){
            inventory.showItem();
            System.out.println("Silahkan masukan nomor item (0 untuk keluar): ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            if(choice == 0){
                finished = true;
            }
            else {
                Item pilihan = inventory.getItem(choice - 1);
                if(pilihan.getStok() > 0){
                    System.out.println("Apakah anda ingin memesan " + pilihan.getNama() + "? (1 = Iya, 0 = Tidak)");
                    confirm = scanner.nextInt();
                    scanner.nextLine(); 
                    if(confirm == 1){
                        System.out.println("Masukan Uang sebesar Rp" + pilihan.getHarga());
                        uang = scanner.nextInt(); 
                        scanner.nextLine(); 
                        if(uang >= pilihan.getHarga()){
                            System.out.println("Pembayaran Berhasil!");
                            pilihan.kurangi();
                            transaksi = "Item: " + pilihan.getNama();
                            log.write(transaksi);
                        }
                        else {
                            System.out.println("Pembayaran gagal! uang dikembalikan");
                        }
                    }
                }
                else {
                    System.out.println("Barang sedang kosong, silakan hubungi admin");
                }
            }

        }

        scanner.close();
        System.out.println("Terima Kasih");
    }
}