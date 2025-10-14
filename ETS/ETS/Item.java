public class Item
{
    private String nama;
    private int stok;
    private int harga;

    public Item(String nama, int stok, int harga){
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama(){
        return nama;
    }

    public int getStok(){
        return stok;
    }

    public int getHarga(){
        return harga;
    }

    public void kurangi(){
        stok -= 1;
    }
}