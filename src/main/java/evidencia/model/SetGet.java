package evidencia.model;
import java.io.Serializable;

    public class SetGet implements Serializable {
        //OSOBNECISLO,DATUMNARODENIA,TITUL,MENO,PRIEZVISKO,POHLAVIE,ODDELENIE

        private String osobnecislo;
        private String datumNarodenia;
        private String datumNastupu;
        private Titul titul;

        private String meno;
        private String priezvisko;
        private Pohlavie pohlavie;
        private Oddelenie oddelenie;


        public SetGet() {
        }


        public SetGet(String osobneCislo, String datumnarodenia, String datumNastupu, Titul Titul, String Meno, String Priezvisko, Pohlavie Pohlavie, Oddelenie Oddelenie) {
            this.osobnecislo=osobneCislo;
            this.datumNarodenia=datumnarodenia;
            this.datumNastupu=datumNastupu;
            this.titul=Titul;
            this.meno=Meno;
            this.priezvisko=Priezvisko;
            this.pohlavie=Pohlavie;
            this.oddelenie=Oddelenie;
        }
        public SetGet(String osobneCislo, String datumnarodenia, String datumNastupu, Titul Titul, String Meno, String Priezvisko, Pohlavie Pohlavie) {
        this.osobnecislo=osobneCislo;
        this.datumNarodenia=datumnarodenia;
        this.datumNastupu=datumNastupu;
        this.titul=Titul;
        this.meno=Meno;
        this.priezvisko=Priezvisko;
        this.pohlavie=Pohlavie;

        }

        public String getOsobnecislo() {
            return osobnecislo;
        }

        public void setOsobnecislo(String osobnecislo) {
            this.osobnecislo = osobnecislo;
        }

        public String getDatumNarodenia() {
            return datumNarodenia;
        }

        public void setDatumNarodenia(String datumNarodenia) {
            this.datumNarodenia = datumNarodenia;
        }
        public String getDatumNastupu() {
            return datumNastupu;
        }

        public void setDatumNastupu(String datumNastupu) {
            this.datumNastupu = datumNastupu;
        }
        public Titul getTitul() {
            return titul;
        }

        public void setTitul(Titul titul) {
            this.titul = titul;
        }

        public String getMeno() {
            return meno;
        }

        public void setMeno(String meno) {
            this.meno = meno;
        }

        public String getPriezvisko() {
            return priezvisko;
        }

        public void setPriezvisko(String priezvisko) {
            this.priezvisko = priezvisko;
        }

        public Pohlavie getPohlavie() {
            return pohlavie;
        }

        public void setPohlavie(Pohlavie pohlavie) {
            this.pohlavie = pohlavie;
        }

        public Oddelenie getOddelenie() {
            return oddelenie;
        }

        public void setOddelenie(Oddelenie oddelenie) {
            this.oddelenie = oddelenie;
        }

        @Override
        public String toString() {
            return "" +
                    "osobnecislo=" + osobnecislo +
                    ",datumNarodenia='" + datumNarodenia + '\'' +
                    ",datumNastupu=" + datumNastupu +
                    ",titul=" + titul +
                    ",meno='" + meno + '\'' +
                    ",priezvisko='" + priezvisko + '\'' +
                    ",pohlavie=" + pohlavie +
                    ",oddelenie=" + oddelenie ;
        }
    }



