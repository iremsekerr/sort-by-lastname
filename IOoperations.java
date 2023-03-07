/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package odevucson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author asus
 */
//BÜTÜN DOSYA OKUMA VE YAZMA İŞLEMLERİNİ TEK BİR CLASSTA YAPTIM
public class IOoperations {
     ArrayList<Contact> contactList = new ArrayList<Contact>(); //KİŞİLERİMİ TUTTUĞUM ARRAYLİST
     ArrayList<Contact> orderedcontactList = new ArrayList<Contact>(); // SOY İSİMLERİNE GÖRE SIRALANMIŞ ŞEKİLDE KİŞİLERİ TUTTUĞUM ARRAYLİST
     HashSet<Contact> hashSetContact = new HashSet<>(); // KİŞİLERİMİ TUTTUĞUM HASHSET YAPISI
     TreeSet<Contact> treeContact = new TreeSet<>(); // KİŞİLERİMİ TUTTUĞUM TREESET YAPISI 
     TreeSet<Contact> orderedTreeContact = new TreeSet<Contact>(new LastNameComparator()); // LAST NAME COMPARATOR SINIFINDAN BİR NESNEYLE SOY İSİMLERİNİ SIRALAYIP TUTTUĞUM TREESET
     HashMap<String, Contact> hashMap = new HashMap<String, Contact>(); // ANAHTAR DEĞERİMİN TELEFON NUMARASI OLMASINDAN KAYNAKLI BİR DEĞERİ STRİNG DİĞERİNİ CONTACT SINIFINDAN GÖNDERDİM. 
                                                                        //KİŞİLERİMİ TELEFON NUMARALARINA GÖRE TUTTUĞUM HASHMAP YAPISI  
   
     
    public void readContactsTxt()throws FileNotFoundException{ // CONTACT TXT Yİ OKUYARAK ARRAYLİST'E ATTIĞIM METOD. ATTIĞIM ARRAYLİS İSE CONTACTLİST
        File f = new File("contacts.txt"); // DOSYAYI OKUYOR
        Scanner sc = new Scanner(f); // DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK

        String lines; // SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
        String[] details; //CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
        while (sc.hasNextLine()) { 
            lines = sc.nextLine();
            details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
            String telNo = details[0]; // TELEFON NUMARASINI BU İNDİSE ATACAK
            String ad = details[1]; // ADI BU İNDİSE ATACAK
            String soyad = details[2]; // SOYADI BU İNDİSE ATACAK
            String sosyalGuvenlikNo = details[3]; // SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
            contactList.add(new Contact( telNo,  ad,  soyad,  sosyalGuvenlikNo)); // CONTACTLİSTE EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNEGÖNDERMEMİZ GEREKLİ
            
            
        }
        sc.close(); // DOSYAYI KAPATIYORUM
         
    }
    
    
    public void readOrderedContact() throws FileNotFoundException{// CONTACT TXT Yİ OKUYARAK ORDEREDARRAYLİST E ATTIĞIM METOD. SIRALI VE SIRASIZ OLARAK İKİ AYRI ÇIKTI İSTEDİĞİNDEN İKİ FARKLI METOD KULLANDIM
     
        
        File f = new File("contacts.txt");// DOSYAYI OKUYOR
        Scanner sc = new Scanner(f);// DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK

        String lines; // SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
        String[] details;//CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
        while (sc.hasNextLine()) {
            lines = sc.nextLine();
            details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
            String telNo = details[0];// TELEFON NUMARASINI BU İNDİSE ATACAK
            String ad = details[1]; // ADI BU İNDİSE ATACAK
            String soyad = details[2];// SOYADI BU İNDİSE ATACAK
            String sosyalGuvenlikNo = details[3];// SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
            orderedcontactList.add(new Contact( telNo,  ad,  soyad,  sosyalGuvenlikNo));// ORDEREDCONTACTLİSTE EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNE GÖNDERMEMİZ GEREKLİ
            
            
        }
        sc.close();// DOSYAYI KAPATIYORUM
    
    
    }
    
        public void readHashSet()throws FileNotFoundException{ // CONTACT TXT Yİ OKUYARAK HASHSET YAPISINA ATTIĞIM METOD. HASHSETCONTACT BENİM OLUŞTURDUĞUM HASHSET YAPSININ ADI 
        File f = new File("contacts.txt");// DOSYAYI OKUYOR
        Scanner sc = new Scanner(f);// DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK

        String lines;//SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
        String[] details;//CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
        while (sc.hasNextLine()) {
            lines = sc.nextLine();
            details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
            String telNo = details[0];// TELEFON NUMARASINI BU İNDİSE ATACAK
            String ad = details[1]; // ADI BU İNDİSE ATACAK
            String soyad = details[2];// SOYADI BU İNDİSE ATACAK
            String sosyalGuvenlikNo = details[3];// SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
            hashSetContact.add(new Contact( telNo,  ad,  soyad,  sosyalGuvenlikNo));// HASHSETCONTACT E EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNE GÖNDERMEMİZ GEREKLİ
            
        }
        sc.close();// DOSYAYI KAPATIYORUM
        
    }
        //BU METOD HATA VERMEMESİNE RAĞMEN YALNIZCA İLK SATIRI OKUYOR. TERMİNALE DE DOSYAYA DA YAZDIRIRKEN TEK SATIRI YAZDIRIYOR NEDENİNİ ÇÖZEMEDİM.
    public void readTreeContact() throws FileNotFoundException {// CONTACT TXT Yİ OKUYARAK TREESET YAPISINA ATTIĞIM METOD. TREECONTACT BENİM OLUŞTURDUĞUM TREE YAPSININ ADI
   
        File f = new File("contacts.txt"); // DOSYAYI OKUYOR
        Scanner sc = new Scanner(f);// DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK
        String lines;//SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
        String [] details;//CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
    
    while(sc.hasNextLine()){
        lines = sc.nextLine();
        details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
        String telNo = details[0];// TELEFON NUMARASINI BU İNDİSE ATACAK
        String ad = details[1];// ADI BU İNDİSE ATACAK
        String soyad = details[2];// SOYADI BU İNDİSE ATACAK
        String sosyalGuvenlikNo = details[3];// SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
        treeContact.add(new Contact(telNo, ad, soyad, sosyalGuvenlikNo));// TREECONTACT E EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNE GÖNDERMEMİZ GEREKLİ
    
    }
    sc.close();// DOSYAYI KAPATIYORUM
    
    }
        
        public void readOrderedTreeContact()throws FileNotFoundException{ //CONTACT TXT Yİ OKUYARAK TREESET YAPISINA ATTIĞIM METOD. ORDEREDTREECONTACT BENİM OLUŞTURDUĞUM TREE YAPSININ ADI.BUNDA SIRALILARI TUTUYORUM
       
            File f = new File("contacts.txt");// DOSYAYI OKUYOR
            Scanner sc = new Scanner(f);// DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK

            String lines;;//SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
            String[] details;//CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
        while (sc.hasNextLine()) {
            lines = sc.nextLine();
            details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
            String telNo = details[0];// TELEFON NUMARASINI BU İNDİSE ATACAK
            String ad = details[1];// ADI BU İNDİSE ATACAK
            String soyad = details[2];// SOYADI BU İNDİSE ATACAK
            String sosyalGuvenlikNo = details[3];// SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
            orderedTreeContact.add(new Contact( telNo,  ad,  soyad,  sosyalGuvenlikNo));// ORDEREDTREECONTACT E EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNE GÖNDERMEMİZ GEREKLİ
            
        }
        sc.close();// DOSYAYI KAPATIYORUM
       
    }
        
        public void readHashMap() throws FileNotFoundException{//CONTACT TXT Yİ OKUYARAK HASHMAP YAPISINA ATTIĞIM METOD . HASHMAP ,BENİM OLUŞTURDUĞUM HASHMAP YAPSININ ADI
        
        File f = new File("contacts.txt");// DOSYAYI OKUYOR
        Scanner sc = new Scanner(f);// DOSYAYI BULAMAZSA FİLENOTFOUNDEXCEPTİON ATACAK

        String lines;//SATIRLARI AYIRABİLMEK İÇİN OLUŞTURDUĞUM DEĞİŞKEN
        String[] details;//CONTACTİN DEĞİŞKENLERİNİ TUTMAK İÇİN OLUŞTURULAN DİZİ
        while (sc.hasNextLine()) {
            lines = sc.nextLine();
            details = lines.split(" ");// BOŞLUK KARAKTERİNE GÖRE AYIRIP OKUYACAK
            String telNo = details[0];// TELEFON NUMARASINI BU İNDİSE ATACAK
            String ad = details[1];// ADI BU İNDİSE ATACAK
            String soyad = details[2];// SOYADI BU İNDİSE ATACAK
            String sosyalGuvenlikNo = details[3];// SOSYAL GÜVENLİK NUMARASNI BU İNDİSE ATACAK
            hashMap.put(telNo, new Contact(telNo,  ad,  soyad,  sosyalGuvenlikNo));// HASHMAP E EKLEME YAPIYOR. BUNUN İÇİN DE CONTACT CLASSINI İÇİNE GÖNDERMEMİZ GEREKLİ
        }
       
       sc.close();// DOSYAYI KAPATIYORUM
      
        
            
        } 
       
        //BU KISIMDAN SONRASI DOSYAYA YAZMA İŞLEMLERİ İÇİN OLUŞTURDUĞUM METODLARI İÇERİYOR
        
    public void arrayWriter (ArrayList contactList) throws IOException{ // ARRAYLİSTİMİ SIRASIZ OLARAK YZADIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM ARRAYLİST
        Iterator<Contact> itr = contactList.iterator(); // ITERASYON YÖNTEMİYLE YAZDIRMAMIZ İSTENDİĞİNDEN İTERATOR YAPSINI KULLANIYORUM VE CONTACTLİST UÜZERİNDEN ÇAĞIRIYORUM
        while (itr.hasNext()) {  // İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
              Contact c = itr.next(); // HER BİR DEĞERİ .NEXT İLE TUTMAK GEREKECEĞİNDEN CONTACTTAN BİR C NESNESİ OLUŞTURUP BUNUNLA NEXT LERİNİ ALIYORUM
              String ssNo = c.getSosyalGuvenlikNo(); // SOSYAL GÜVENLİK NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP SSN DEĞİŞKNEİNE ATIYORUM
              String iad = c.getAd(); // ADI C NESNESİ ÜZERİNDEN ÇAĞIRIP İAD DEĞİŞKENİİNE ATIYORUM
              String sad =c.getSoyad(); //SOYADI C NESNESİ ÜZERİNDEN ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = c.getTelNo(); //TELEFON NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM.
        try{ // TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("contactArrayList.txt", true); //FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter); // BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format("%n%s;%s;%s;%s" , ssNo,iad,sad,telNo)); // YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close(); //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
       
    }
    
    
public void orderedArrayWriter (ArrayList orderedcontactList) throws IOException{ // ARRAYLİSTİMİ SOYİSME GÖRE SIRALI OLARAK YZADIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM ARRAYLİST
      
      
       Iterator<Contact> itr = orderedcontactList.iterator();// ITERASYON YÖNTEMİYLE YAZDIRMAMIZ İSTENDİĞİNDEN İTERATOR YAPSINI KULLANIYORUM VE ORDEREDCONTACTLİST ÜZERİNDEN ÇAĞIRIYORUM
        while (itr.hasNext()) {// İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
              Contact c = itr.next();// HER BİR DEĞERİ .NEXT İLE TUTMAK GEREKECEĞİNDEN CONTACTTAN BİR C NESNESİ OLUŞTURUP BUNUNLA NEXT LERİNİ ALIYORUM
              String ssNo = c.getSosyalGuvenlikNo(); // SOSYAL GÜVENLİK NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP SSN DEĞİŞKNEİNE ATIYORUM
              String iad = c.getAd();// ADI C NESNESİ ÜZERİNDEN ÇAĞIRIP İAD DEĞİŞKENİİNE ATIYORUM
              String sad =c.getSoyad();//SOYADI C NESNESİ ÜZERİNDEN ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = c.getTelNo();//TELEFON NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM.
        try{// TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("contactArrayListOrderedByLastName.txt", true);//FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter); // BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format("%n%s;%s;%s;%s" , ssNo,iad,sad,telNo));// YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close(); //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
    
    
}
    
    public void hashWriter (HashSet hashSetContact) throws IOException{ // HASHSETİMİ YZADIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM HASHSET
        
         Iterator<Contact> itr = hashSetContact.iterator();// ITERASYON YÖNTEMİYLE YAZDIRMAMIZ İSTENDİĞİNDEN İTERATOR YAPSINI KULLANIYORUM VE HASHSETCONTACT ÜZERİNDEN ÇAĞIRIYORUM
        while (itr.hasNext()) {// İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
              Contact c = itr.next();// HER BİR DEĞERİ .NEXT İLE TUTMAK GEREKECEĞİNDEN CONTACTTAN BİR C NESNESİ OLUŞTURUP BUNUNLA NEXT LERİNİ ALIYORUM
              String ssNo = c.getSosyalGuvenlikNo(); //SOSYAL GÜVENLİK NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP SSN DEĞİŞKNEİNE ATIYORUM
              String iad = c.getAd(); // ADI C NESNESİ ÜZERİNDEN ÇAĞIRIP İAD DEĞİŞKENİİNE ATIYORUM
              String sad =c.getSoyad();//SOYADI C NESNESİ ÜZERİNDEN ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = c.getTelNo();//TELEFON NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM.
        try{ // TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("contactHashSet.txt", true);//FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter);// BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format("%n%s;%s;%s;%s" , ssNo,iad,sad,telNo));// YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close();  //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
        
    }
    public void treeWriter(TreeSet treeContact) throws IOException{// TREESETİMİ SIRASIZ YAZDIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM TREESET. ANCAK BUNDA DA SADECE İLK SATIRI YAZDIRIYOR
      
            Iterator<Contact> itr = treeContact.iterator();// ITERASYON YÖNTEMİYLE YAZDIRMAMIZ İSTENDİĞİNDEN İTERATOR YAPSINI KULLANIYORUM VE TREECONTACT ÜZERİNDEN ÇAĞIRIYORUM
        while (itr.hasNext()) {// İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
              Contact c = itr.next();// HER BİR DEĞERİ .NEXT İLE TUTMAK GEREKECEĞİNDEN CONTACTTAN BİR C NESNESİ OLUŞTURUP BUNUNLA NEXT LERİNİ ALIYORUM
              String ssNo = c.getSosyalGuvenlikNo();//SOSYAL GÜVENLİK NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP SSN DEĞİŞKNEİNE ATIYORUM
              String iad = c.getAd();// ADI C NESNESİ ÜZERİNDEN ÇAĞIRIP İAD DEĞİŞKENİİNE ATIYORUM
              String sad = c.getSoyad();//SOYADI C NESNESİ ÜZERİNDEN ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = c.getTelNo();//TELEFON NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM.
        try{ // TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("contactTreeSet.txt", true);//FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter);// BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format("%n%s;%s;%s;%s" , ssNo,iad,sad,telNo));// YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close(); //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
    
    }
    public void orderedTreeWriter(TreeSet orderedTreeContact){// TREESETİMİ SOYİSME GÖRE SIRALI YAZDIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM TREESET
    
            Iterator<Contact> itr = orderedTreeContact.iterator();// ITERASYON YÖNTEMİYLE YAZDIRMAMIZ İSTENDİĞİNDEN İTERATOR YAPSINI KULLANIYORUM VE ORDEREDTREECONTACT ÜZERİNDEN ÇAĞIRIYORUM
        while (itr.hasNext()) {// İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
              Contact c1 = itr.next();// HER BİR DEĞERİ .NEXT İLE TUTMAK GEREKECEĞİNDEN CONTACTTAN BİR C NESNESİ OLUŞTURUP BUNUNLA NEXT LERİNİ ALIYORUM
              String ssNo = c1.getSosyalGuvenlikNo();//SOSYAL GÜVENLİK NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP SSN DEĞİŞKNEİNE ATIYORUM
              String iad = c1.getAd();// ADI C NESNESİ ÜZERİNDEN ÇAĞIRIP İAD DEĞİŞKENİİNE ATIYORUM
              String sad =c1.getSoyad();//SOYADI C NESNESİ ÜZERİNDEN ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = c1.getTelNo();//TELEFON NUMARASINI C NESNESİ ÜZERİNDEN ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM.
        try{  // TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("orderedContactTreeSet.txt", true);//FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter);// BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format("%n%s;%s;%s;%s" , ssNo,iad,sad,telNo));// YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close();  //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
    
    
    
    }
    public void hashMapWriter ( HashMap hashMap){// HASHMAPİMİ ANAHTAR DEĞER OLAN TELEFON NUMARASINA GÖRE YAZDIRMAK İÇİN KULLANDIĞIM METOD. METODUN PARAMETRESİ İSE KULLANACAĞIM HASHMAP
    
              Iterator<Map.Entry<String, Contact>> itr = hashMap.entrySet().iterator(); // BURADA İTERATOR KULLANIMI DİĞERLERİNDEN FARKLI ÇÜNKÜ KEY, VALUE İKİLİSİYLE ÇALIŞIYOR.
                                                                                        //YİNE MAP.ENTRY YAPSININI KULLANARAK DĞERELERİ GÖNDERİYORUM. HASHMAPİN ÜXERİNDEN İTERATOR ÇAĞIRABİLMEK İÇİN ÖNCE ENTRYSET YAPSINI KULLANMAK ZORUNDAYIZ
        while (itr.hasNext()) {// İTERATORE EKLEME YAPARAK GİTMESİ İÇİN DÖNGÜYE ALIYORUM
            Map.Entry<String, Contact> entry = itr.next(); //BU SEFER .NEXT  KULLANABİLMEK İÇİN MAP.ENTRY İ KULLANARAK NEXTLERİ ALIYORUM
              String key = entry.getKey(); // ÖNCE KEY DEĞERİ ALIYORUM VE Bİ DEĞİŞKENE ATIYORUM
              String ssNo = entry.getValue().getSosyalGuvenlikNo(); // SOSYAL GÜVENLİK NUMARASINI ENTRY NESNESİ ÜZERİNDEN  GETVALUE İLE ÇAĞIRIP SSN DEĞİŞKENİNE ATIYORUM
              String iad = entry.getValue().getAd(); //ADI ENTRY NESNESİ ÜZERİNDEN  GETVALUE İLE ÇAĞIRIP İAD DEĞİŞKENİNE ATIYORUM
              String sad =entry.getValue().getSoyad(); //SOYADI ENTRY NESNESİ ÜZERİNDEN  GETVALUE İLE ÇAĞIRIP SAD DEĞİŞKENİNE ATIYORUM
              String telNo = entry.getValue().getTelNo(); // TELEFON NUMARASINI ENTRY NESNESİ ÜZERİNDEN  GETVALUE İLE ÇAĞIRIP TELNO DEĞİŞKENİNE ATIYORUM
        try{ // TRY CATCH YAPISIYLA DOSYAYA DOSYAYA YAZDIRMA İŞLEMİNİ YAPIYORUM EĞER DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE CATH HATAYI ÇALIŞTIRIP KULLANICIYA UYARI VERİR. 
      	  FileWriter fileWriter = new FileWriter("hashMapContact.txt", true); //FİLEWRİTER KULLANARAK İÇERİĞİN HANGİ DOSYAYA YAZILACAĞINI BELRİTİYORUM.
        BufferedWriter w2 = new BufferedWriter(fileWriter);// BUFFERED WRİTER YAPISIYLA YAZDIRMA İŞLEMİNİ GERÇEKLEŞTİRİYORUM
              w2.write(String.format( "%n%n%s;%s;%s;%s" ,key +":"+ telNo,iad,sad,ssNo));// YAZILACAK OLAN DEĞİŞKENLERİMİ GÖNDERİYORUM
              w2.close();  //BUFFERED WRİTERI KAPATIYORUM
        }
        catch (Exception hata){ // DOSYAYA YAZMA İŞLEMİ GERÇEKLEŞMEZSE BU BLOK HATAYI DÖNDÜRECEK
              hata.printStackTrace();
      }

  }
  }
}
