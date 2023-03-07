package odevucson;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.util.Comparator;

/**
 *
 * @author asus
 */
public class LastNameComparator implements Comparator<Contact> { // COMPARATOR ARAYÜZÜNÜ İMPLEMENT EDEREK SOYADA GÖRE SIRALAMA YAPABİLME İMKANI SAĞLIYORUZ
    

    @Override
    public int compare(Contact o1, Contact o2) { // COMPARE METODUNU OVERRİDE EDEREK BUNUN İÇİNDE KARŞILAŞTIRMAYI YAPIYORUZ
        
       String o1soyad =(o1.getSoyad()); // O1 İN SOYADINI BİR DEĞİŞKENE ATADIM
       String o2soyad  =(o2.getSoyad()); // O2 NİN SOYADINI BİR DEĞİŞKENE ATADIM
       return o1soyad.compareTo(o2soyad); // COMPARETO KULLANARAK BU İKİ DEĞİŞKENİN KARŞILAŞTIRMASINI RETURN ETTİM
       
    }
    
}
