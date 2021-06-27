package latihanscanner;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Siswa {
    String nama;
    int umur;
    String kelas;
    int tahunKelahiran;

    Siswa(String nama, int umur, int kelas) throws Exception {
        this.nama = nama;
        this.umur = umur;
        this.kelas = this.resolveClass(kelas);

        this.validateName();
        this.validateAge();
    }

    public void validateAge() throws Exception {
        int umur = this.umur;
        if (!this.isInteger(umur)) throw new Exception("Umur harus angka bukannya berdesimal!");
        Calendar calendar = Calendar.getInstance();

        int tahun = calendar.get(Calendar.YEAR);
        int tahunKelahiran = tahun - umur;
        if (tahunKelahiran < 0) throw new Exception("Umur harus valid!");
        this.tahunKelahiran = tahunKelahiran;
    }

    private boolean isInteger(double n) {
        int x = (int)n;
        if ((n-x) > 0) {
            return false;
        } else return true;
    }

    public void validateName() throws Exception {
        String nama = this.nama;
        Pattern pattern = Pattern.compile("[^a-zA-Z\s]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nama);
        boolean found = matcher.find();

        if (found) throw new Exception("Nama harus berupa huruf, angka dan simbol lainnya tidak diperkenankan!");
    }

    private String resolveClass(int kelas) throws Exception {
        if (kelas > 0 && kelas < 7) return String.format("%s SD", kelas);
        else if (kelas < 1) return "0 TK";
        else if (kelas >= 7 && kelas < 10) return String.format("%s SMP", kelas);
        else if (kelas >= 10 && kelas < 12) return String.format("%s SMA/SMK", kelas);
        else throw new Exception("Mohon masukan kelas yang valid!");
    }
}