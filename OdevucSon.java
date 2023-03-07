package odevucson;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author asus
 */
public class OdevucSon {

    public static void main(String[] args) throws IOException, Exception {
           
        
            IOoperations textReader = new IOoperations(); // IOOPERATİONS CLASSIMDAN DOSYADAN OKUDUĞUM DEĞERLERİ TUTTUĞUM YAPILARI ÇAĞIRABİLMEK İÇİN BİR NESNE OLUŞTURDUM
            IOoperations textWriter = new IOoperations(); // IOOPERATİONS CLASSIMDAN DOSYAYA YAZMA İŞLEMLERİNİ GERÇEKLEŞTİRMEK İÇİN BİR NESNE OLUŞTURDUM
            
            
            
            
            System.out.println("ArrayList: " + "\n" + "Siralamadan once:"); // ARRAYLİSTİ TERMİNALE YAZDIRACAĞIM
            textReader.readContactsTxt(); // OKUMA METODUMU ÇAĞIRIYORUM
            
            for( Contact contacts: textReader.contactList){ // FOR EACH İLE CONTACTLİST İMİ GEZİYORUM VE CONTACTS ÜZERİNDEN GETLERİMLE DEĞERLERİMİ ÇAĞIRIYORUM.
                    System.out.println( contacts.getTelNo()+" "+ contacts.getAd()+ " "+ contacts.getSoyad()+" " + contacts.getSosyalGuvenlikNo()  );
            }
            
            System.out.println("---------------------------------------------" + "\n" + "Siralamadan sonra: " ); // SIRALANMIŞ HALİNİ TERMİNALE YAZDIRIYORUM
             textReader.readOrderedContact(); // SIRALANMIŞ HALİ İÇİN OLUŞTURDUĞUM METODU ÇAĞIRIYORUM
            Collections.sort(textReader.orderedcontactList, new LastNameComparator());  // COLLECTİONS.SORT YAPISINI KULLANARAK ORDEREDCONTACTLİSTİM İÇİNDELKİ DEĞERLERİ 
                                                                                        //LASTNAMECOMPARATOR SINIFINDAKİ COMPARETO METODUYLA KARŞIALŞTIRARAK SIRALIYORUM
            for( Contact contacts: textReader.orderedcontactList){//FOR EACH İLE ORDEREDCONTACTLİST İMİ GEZİYORUM VE CONTACTS ÜZERİNDEN GETLERİMLE DEĞERLERİMİ ÇAĞIRIYORUM
                    System.out.println( contacts.getTelNo()+" "+ contacts.getAd()+ " "+ contacts.getSoyad()+" " + contacts.getSosyalGuvenlikNo()  );
            }
            System.out.println("------------------------------------------  " +"\n" + "Tree Set:");// TREESETİ TERMİNALE YAZDIRIYORUM
            textReader.readTreeContact(); // TREESET İÇİN OLUŞTURDUĞUM METODU ÇAĞIRIYORUM
            
            for( Contact contacts: textReader.treeContact){//FOR EACH İLE TREECONTACT İMİ GEZİYORUM VE CONTACTS ÜZERİNDEN GETLERİMLE DEĞERLERİMİ ÇAĞIRIYORUM
                    System.out.println( contacts.getTelNo()+" "+ contacts.getAd() +" "+ contacts.getSoyad() +" "+ contacts.getSosyalGuvenlikNo());
            }
            System.out.println("-------------------------------------------------" + "\n" + "Sirali tree Set:"); // SIRALİ HALİNİ TERMİNALE YAZDIRIYORUM
            
            textReader.readOrderedTreeContact(); // SIRALI TREESET İÇİN OLUŞTURDUĞUM METODU ÇAĞIRIYORUM
            
            
            for( Contact contacts: textReader.orderedTreeContact){//FOR EACH İLE ORDEREDTREECONTACT İMİ GEZİYORUM VE CONTACTS ÜZERİNDEN GETLERİMLE DEĞERLERİMİ ÇAĞIRIYORUM
                    System.out.println( contacts.getTelNo()+" "+ contacts.getAd() +" "+ contacts.getSoyad() +" "+ contacts.getSosyalGuvenlikNo());
            }
           System.out.println("-------------------------------------------------------------" + "\n" + "hashset:");//HASHSETİ TERMİNALE YAZDIRIYORUM
           
           textReader.readHashSet(); //HASHSET İÇİN OLUŞTURDUĞUM METODU ÇAĞIRIYORUM
           
            for( Contact contacts : textReader.hashSetContact){//FOR EACH İLE OHASHSETCONTAC İMİ GEZİYORUM VE CONTACTS ÜZERİNDEN GETLERİMLE DEĞERLERİMİ ÇAĞIRIYORUM
                    System.out.println( contacts.getTelNo()+" "+ contacts.getAd()+ " "+ contacts.getSoyad()+" " + contacts.getSosyalGuvenlikNo()  );
            }
             
            System.out.println("-------------------------------" + "\n" + "HashMap ile telefon numarasina gore siralama: ");   // HASHMAPİ TERMİNALE YAZDIRIYORUM
          
            textReader.readHashMap(); //HASHMAP İÇİN OLUŞTURDUĞUM METODU ÇAĞIRIYORUM
             for( Map.Entry< String, Contact> entry:textReader.hashMap.entrySet()){  // FOR EACH İLE HASHMAP İ GEZİYORUM AMA BUNDA ANAHTAR DEĞERİM OLDUĞU İÇİN 
                                                                                    //MAP.ENTRY YAPISINI KULLANIP ANAHTAR DEĞE KARŞIALŞTIRILACAK DEĞER İKİLİSİNİ GÖNDERİYORUM. GETLERİMİ VALUE UZERİNDEN ALIYORUM VE GET KEY İLE ANAHTAR DEĞERLERİMİ ALIYORUM
                 System.out.println(entry.getKey() + ":" + entry.getValue().getTelNo() + entry.getValue().getAd() + entry.getValue().getSoyad()+ entry.getValue().getSosyalGuvenlikNo());
           
         }
        
        textWriter.arrayWriter(textReader.contactList); // DOSYAYA YAZDIRMAK İÇİN OLUŞTURDUĞUM METODLARI SIRASIYLA IOOPEERATİONS CLASSINDAN OLUŞTURDUĞUM YAZMA NESNESİYLE ÇAĞIRIP HEPSİNİ YAZDIRIYORUM
        textWriter.hashMapWriter(textReader.hashMap);
        textWriter.hashWriter(textReader.hashSetContact);
        textWriter.orderedArrayWriter(textReader.orderedcontactList);
        textWriter.orderedTreeWriter(textReader.orderedTreeContact);
        textWriter.treeWriter(textReader.treeContact);
       }
    
}

