import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Item> daftar_item;
    
    public Inventory(){
        this.daftar_item = new ArrayList<>();
    }

    public void showItem(){
        int i = 1;
        System.out.println("==== Vending Machine ====");
        for (Item item:daftar_item){
            System.out.println(i + ". " + item.getNama() + ": Rp" + item.getHarga() + " (stok: " + item.getStok() + ")");
            i += 1;
        }
    }

    public void addItem(String nama, int stok, int harga){
        Item baru = new Item(nama, stok, harga);
        daftar_item.add(baru);
    }

    public void kurangiStok(int index){
        daftar_item.get(index).kurangi();
    }

    public Item getItem(int index){
        return daftar_item.get(index);
    }
}