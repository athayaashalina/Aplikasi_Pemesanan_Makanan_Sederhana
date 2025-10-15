// Pemesanan.java
public class Pemesanan {
    // Sesuai struktur yang diminta: menggunakan array 2D untuk pelanggan dan pesanan
    // Kita pakai ukuran 1 x 2 karena hanya menyimpan satu pesanan pelanggan pada contoh ini.
    private String[][] pelanggan;   // [0][0] = nama, [0][1] = telepon
    private Object[][] pesanan;     // [0][0] = jenisMakanan (String), [0][1] = jumlah (Integer)
    private int totalHarga;

    // Constructor: inisialisasi array
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

    // Menghitung total harga: harga per porsi * jumlah
    public void hitungTotalHarga(int hargaPerPorsi) {
        // Ambil jumlah dari pesanan (pastikan bukan null)
        if (pesanan[0][1] instanceof Integer) {
            int jumlah = (Integer) pesanan[0][1];
            // Perhitungan sederhana
            totalHarga = hargaPerPorsi * jumlah;
        } else {
            totalHarga = 0;
        }
    }

    // Getter untuk pelanggan (kembalikan array agar bisa ditampilkan oleh Main)
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