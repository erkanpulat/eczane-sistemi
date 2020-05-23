
package entity;

public class ilac {
    private long barkodNo;
    private String ilacAdi;
    private float fiyat;
    private int adet;
    private String uretimTarihi;
    private String sonKullanmaTarihi;
    private firma firma;
    private String filePath;
    private String fileName;
    private String fileType;

    public ilac() {
    }

    public ilac(long barkodNo, String ilacAdi, float fiyat, int adet, String uretimTarihi, String sonKullanmaTarihi, firma firma, 
            String filePath, String fileName, String fileType) {
        this.barkodNo = barkodNo;
        this.ilacAdi = ilacAdi;
        this.fiyat = fiyat;
        this.adet = adet;
        this.uretimTarihi = uretimTarihi;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.firma = firma;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }

  
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    

    public long getBarkodNo() {
        return barkodNo;
    }

    public void setBarkodNo(long barkodNo) {
        this.barkodNo = barkodNo;
    }

    public String getIlacAdi() {
        return ilacAdi;
    }

    public void setIlacAdi(String ilacAdi) {
        this.ilacAdi = ilacAdi;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String getUretimTarihi() {
        return uretimTarihi;
    }

    public void setUretimTarihi(String uretimTarihi) {
        this.uretimTarihi = uretimTarihi;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public firma getFirma() {
        return firma;
    }

    public void setFirma(firma firma) {
        this.firma = firma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (this.barkodNo ^ (this.barkodNo >>> 32));
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
        final ilac other = (ilac) obj;
        if (this.barkodNo != other.barkodNo) {
            return false;
        }
        return true;
    }

    
    
    
}
