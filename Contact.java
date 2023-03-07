package odevucson;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author asus
 */
 
public class Contact implements Comparable< Contact> { // CLASS İÇİNDEKİ DEĞİŞKENLERİMİN BAZILARINI KARŞILAŞTIRMA İÇİN KULANACAĞIMDAN CLASSA COMPARABLE ARAYÜZÜNÜ İMPLEMENT EDİYORUM
    private String telNo; // DEĞİŞKENLERİ BELİRTİYORUM
    private String ad;
    private String soyad;
    private String sosyalGuvenlikNo;

    public Contact(String telNo, String ad, String soyad, String sosyalGuvenlikNo) { // CONSTRUCTOR OLUŞTURUYORUM
        this.telNo = telNo;
        this.ad = ad;
        this.soyad = soyad;
        this.sosyalGuvenlikNo = sosyalGuvenlikNo;
    }
    public Contact(){}

    public String getTelNo() { // GET VE SET METODLARIMI OLUŞTURUYORUM 
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSosyalGuvenlikNo() {
        return sosyalGuvenlikNo;
    }

    public void setSosyalGuvenlikNo(String sosyalGuvenlikNo) {
        this.sosyalGuvenlikNo = sosyalGuvenlikNo;
    }
    
    
    
    
    

    @Override
    public int compareTo(Contact o) { // KARŞIŞATIRILABİLİR OLMASI İÇİN COMPARETO METODUNU OVERRİDE EDİYORUM. ZATEN COMPARABLE ARAYÜZÜ KULLANIMINDA BU METOD OVERRİDE EDİLMEZSE HATA VERİYOR
        
        return 0;
        
    }
    
    
}
