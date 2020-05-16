
package entity;

public class adresler {

    private int adresNo;
    private String adres;
  
    public adresler() {
    }

    public adresler(int adresNo, String adres) {
        this.adresNo=adresNo;
        this.adres=adres;
    }
    
    public int getAdresNo() {
        return adresNo;
    }

    public void setAdresNo(int adresNo) {
        this.adresNo = adresNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.adresNo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final adresler other = (adresler) obj;
        if (this.adresNo != other.adresNo) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "adresler{" + "adresNo=" + adresNo + ", adres=" + adres + '}';
    }
 
}
