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
            String jumlahStr = in.nextLine().trim();
            try {
                jumlah = Integer.parseInt(jumlahStr);
                if (jumlah < 0) {
                    System.out.println("Jumlah tidak boleh negatif. Coba lagi.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka bulat.");
            }
        }

        pemesanan.setPesanan(jenis, jumlah);

        // 3. Input harga per porsi dan hitung total
        int hargaPerPorsi = 0;
        while (true) {
            System.out.print("Masukkan harga per porsi (angka): ");
            String hargaStr = in.nextLine().trim();
            try {
                hargaPerPorsi = Integer.parseInt(hargaStr);
                if (hargaPerPorsi < 0) {
                    System.out.println("Harga tidak boleh negatif. Coba lagi.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka bulat.");
            }
        }

        pemesanan.hitungTotalHarga(hargaPerPorsi);

        // 4. Tampilkan hasil
        System.out.println("\n--- RINCIAN PESANAN ---");
        String[][] dataPel = pemesanan.getPelanggan();
        Object[][] dataPes = pemesanan.getPesanan();

        System.out.println("Nama Pelanggan : " + (dataPel[0][0] != null ? dataPel[0][0] : "-"));
        System.out.println("Nomor Telepon  : " + (dataPel[0][1] != null ? dataPel[0][1] : "-"));
        System.out.println("Jenis Makanan  : " + (dataPes[0][0] != null ? dataPes[0][0] : "-"));
        System.out.println("Jumlah Pesanan : " + (dataPes[0][1] != null ? dataPes[0][1] : 0));
        System.out.println("Harga per Porsi: " + hargaPerPorsi);
        System.out.println("TOTAL HARGA    : " + pemesanan.getTotalHarga());

        System.out.println("\nTerima kasih, pesanan Anda sedang diproses.");
        in.close();
    }
}