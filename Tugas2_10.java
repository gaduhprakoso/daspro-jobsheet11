import java.util.Scanner;

public class Tugas2_10 {
    static String[] menu = { "Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan" };
    static int[][] penjualan = new int[menu.length][7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Program Rekap Penjualan ===");
            System.out.println("1. Input Data Penjualan");
            System.out.println("2. Tampilkan Data Penjualan");
            System.out.println("3. Menu dengan Penjualan Tertinggi");
            System.out.println("4. Rata-rata Penjualan per Menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    inputData(sc);
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    menuTertinggi();
                    break;
                case 4:
                    rerataPenjualan();
                    break;
                case 5:
                    System.out.println("Program berhenti");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, tolong ulangi.");
            }
        } while (pilihan != 5);
        sc.close();
    }

    //input data penjualan
    static void inputData(Scanner sc) {
        System.out.println("\n=== Input Data Penjualan ===");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("Menu: " + menu[i]);
            for (int j = 0; j < 7; j++) {
                System.out.print("Hari ke-" + (j + 1) + ": ");
                penjualan[i][j] = sc.nextInt();
            }
        }
        System.out.println("Data berhasil diinput!");
    }

    // menampilkan data penjualan
    static void tampilkanData() {
        System.out.println("\n=== Data Penjualan ===");

        System.out.printf("%-15s", "Menu");
        for (int hari = 1; hari <= 7; hari++) {
            System.out.printf("%-10s", "Hari " + hari);
        }
        System.out.println();

        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%-15s", menu[i]);
            for (int j = 0; j < 7; j++) {
                System.out.printf("%-10s", penjualan[i][j]);
            }
            System.out.println();
        }
    }

    //menu tertinggi
    static void menuTertinggi() {
        int tertinggi = 0;
        String terlaris = null;

        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < 7; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > tertinggi) {
                tertinggi = totalPenjualan;
                terlaris = menu[i];
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi:");
        System.out.println("Menu: " + terlaris);
        System.out.println("Total penjualan: " + tertinggi);
    }

    //rerata penjualan per menu
    static void rerataPenjualan() {
        System.out.println("\n=== Rata-rata Penjualan ===");
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < 7; j++) {
                totalPenjualan += penjualan[i][j];
            }
            double rataRata = (double) totalPenjualan / 7;
            System.out.println("Menu: " + menu[i]);
            System.out.println("Rata-rata: " + rataRata);
            System.out.println();
        }
    }
}
