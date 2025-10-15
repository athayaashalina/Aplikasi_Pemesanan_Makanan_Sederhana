public class Pemesanan {
    // menggunakan array 2D untuk pelanggan dan pesanan
    private String[][] pelanggan;   // [0][0] = nama, [0][1] = telepon
    private Object[][] pesanan;     // [0][0] = jenisMakanan (String), [0][1] = jumlah (Integer)
    private int totalHarga;

    // Constructor
    public Pemesanan() {
        pelanggan = new String[1][2];
        pesanan = new Object[1][2];
        totalHarga = 0;
    }

    // Menyimpan data pelanggan
    public void setPelanggan(String nama, String telepon) {
        pelanggan[0][0] = nama;
        pelanggan[0][1] = telepon;
    }

    // Menyimpan data pesanan
    public void setPesanan(String jenisMakanan, int jumlah) {
        pesanan[0][0] = jenisMakanan;
        pesanan[0][1] = jumlah;
    }

    // Menghitung total harga
    public void hitungTotalHarga(int hargaPerPorsi) {
        // Ambil jumlah dari pesanan
        if (pesanan[0][1] instanceof Integer) {
            int jumlah = (Integer) pesanan[0][1];
            // Perhitungan sederhana
            totalHarga = hargaPerPorsi * jumlah;
        } else {
            totalHarga = 0;
        }
    }

    // Getter untuk pelanggan
    public String[][] getPelanggan() {
        return pelanggan;
    }

    // Getter untuk pesanan
    public Object[][] getPesanan() {
        return pesanan;
    }

    // Getter total harga
    public int getTotalHarga() {
        return totalHarga;
    }
}