public class University {

    private String university;
    private String bolum;
    private int ogrcSayisi;
    private int notOrt;

    public University(String university, String bolum, int ogrcSayisi, int notOrt) {
        this.university = university;
        this.bolum = bolum;
        this.ogrcSayisi = ogrcSayisi;
        this.notOrt = notOrt;
    }

// Getter Setter
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrcSayisi() {
        return ogrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        this.ogrcSayisi = ogrcSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "University{" +
                "university='" + university + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrcSayisi=" + ogrcSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
