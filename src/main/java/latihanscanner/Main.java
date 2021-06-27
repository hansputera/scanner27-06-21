package latihanscanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Mohon masukan nama yang valid:");
            String name = sc.nextLine();
            System.out.println("Mohon masukan kelas yang valid:");
            int classInt = sc.nextInt();
            System.out.println("Mohon masukan umur yang valid:");
            int umur = sc.nextInt();

            Siswa siswa = new Siswa(name, umur, classInt);
            System.out.println(String.format("Nama: %s\nKelas: %s\nTahun perkiraan kelahiran: %s\nUmur: %s", siswa.nama, siswa.kelas, siswa.tahunKelahiran, siswa.umur));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Mengulangi!\n\n");
            Main.main(args);
        }
    }
}