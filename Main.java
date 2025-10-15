import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pemesanan pemesanan = new Pemesanan();

        System.out.println("APLIKASI PEMESANAN MAKANAN SEDERHANA");

        // 1. Input data pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String nama = in.nextLine().trim();

        System.out.print("Masukkan nomor telepon: ");
        String telepon = in.nextLine().trim();

        pemesanan.setPelanggan(nama, telepon);

        // 2. Input data pesanan
        System.out.print("Masukkan jenis makanan: ");
        String jenis = in.nextLine().trim();

        int jumlah = 0;
        while (true) {
            System.out.print("Masukkan jumlah pesanan (angka): ");
            try {
                jumlah = Integer.parseInt(in.nextLine());
                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Coba lagi.");
            }
        }

        pemesanan.setPesanan(jenis, jumlah);

        // 3. Input harga per porsi
        int harga = 0;
        while (true) {
            System.out.print("Masukkan harga per porsi (angka): ");
            try {
                harga = Integer.parseInt(in.nextLine());
                if (harga <= 0) {
                    System.out.println("Harga harus lebih dari 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Coba lagi.");
            }
        }

        // Hitung total harga
        pemesanan.hitungTotalHarga(harga);

        // 4. Tampilkan hasil
        System.out.println("\nRINCIAN PESANAN");
        System.out.println("Nama Pelanggan : " + pemesanan.getPelanggan()[0][0]);
        System.out.println("Nomor Telepon  : " + pemesanan.getPelanggan()[0][1]);
        System.out.println("Jenis Makanan  : " + pemesanan.getPesanan()[0][0]);
        System.out.println("Jumlah Pesanan : " + pemesanan.getPesanan()[0][1]);
        System.out.println("Harga per Porsi: " + harga);
        System.out.println("TOTAL HARGA    : " + pemesanan.getTotalHarga());
        System.out.println("\nTerima kasih, pesanan Anda sedang diproses.");

        in.close();
    }
}

class Pemesanan {
    // Atribut private (data disembunyikan)
    private String[][] pelanggan;
    private Object[][] pesanan;
    private int totalHarga;

    // Constructor (mengatur array awal)
    public Pemesanan() {
        pelanggan = new String[1][2];
        pesanan = new Object[1][2];
    }

    // Setter untuk data pelanggan
    public void setPelanggan(String nama, String telepon) {
        pelanggan[0][0] = nama;
        pelanggan[0][1] = telepon;
    }

    // Setter untuk data pesanan
    public void setPesanan(String jenisMakanan, int jumlah) {
        pesanan[0][0] = jenisMakanan;
        pesanan[0][1] = jumlah;
    }

    // Hitung total harga
    public void hitungTotalHarga(int harga) {
        int jumlah = (int) pesanan[0][1];
        totalHarga = harga * jumlah;
    }

    // Getter untuk pelanggan
    public String[][] getPelanggan() {
        return pelanggan;
    }

    // Getter untuk pesanan
    public Object[][] getPesanan() {
        return pesanan;
    }

    // Getter untuk total harga
    public int getTotalHarga() {
        return totalHarga;
    }
}