package app.place;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

/**
 * Created by winnerawan
 * on 2/7/17.
 */
public class ZipCode {

    @Id
    private String kelurahan;
    private String kecamatan;
    private int kode;

    public ZipCode() { }

    public ZipCode(String kelurahan, String kecamatan, int kode) {
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kode = kode;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }
}
