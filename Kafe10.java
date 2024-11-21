import java.util.Scanner;

public class Kafe10 {

    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");
        // if (isMember) {
        //     System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian");
        // }
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("0. keluar");
        System.out.println("1. Kopi Hitam - Rp.15,000");
        System.out.println("2. Cappuccino - Rp.20,000");
        System.out.println("3. Latte - Rp.22,000");
        System.out.println("4. Teh Tarik - Rp.12,000");
        System.out.println("5. Roti Bakar - Rp.10,000");
        System.out.println("6. Mie Goreng - Rp.18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang anda inginkan");
    }

    public static int hitungTotalHarga(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = { 15000, 20000, 22000, 12000, 10000, 18000 };
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            hargaTotal = (int) (hargaTotal * 0.5);
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            hargaTotal = (int) (hargaTotal * 0.7);
        } else {
            System.out.println("Kode promo invalid!.");
        }
        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalHargaKeseluruhan = 0;
        String kodePromo = "";

        Menu("Andi", true);

        while (true) {
            System.out.print("Masukan nomor menu yang ingin anda pesan (masukan 0 untuk keluar): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 0) {
                break;
            }

            System.out.print("Masukan jumlah item yang ingin anda pesan: ");
            int banyakItem = sc.nextInt();

            System.out.print("Masukan kode promo (jika ada): ");
            sc.nextLine();
            kodePromo = sc.nextLine();

            int hargaMenu = hitungTotalHarga(pilihanMenu, banyakItem, kodePromo);
            totalHargaKeseluruhan += hargaMenu;
            System.out.println("Total harga untuk pesanan ini: Rp." + hargaMenu);
        }

        System.out.println("Total keseluruhan pesanan anda: Rp." + totalHargaKeseluruhan);
    }
}
