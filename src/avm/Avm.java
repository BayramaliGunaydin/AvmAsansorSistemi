/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avm;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Bayram
 */
public class Avm {

    volatile static ArrayList<Integer> GirisKuyruk =new ArrayList<Integer>();//Katlarda oluşan kuyrukları tutan arraylisler
    volatile static ArrayList<Integer> Kat1Kuyruk = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Kat2Kuyruk = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Kat3Kuyruk = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Kat4Kuyruk = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Kat5Kuyruk = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Asansör1B = new ArrayList<Integer>();//Asansörün içinde bulunan müsterileri tutan arraylistler
    volatile static ArrayList<Integer> Asansör2B = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Asansör3B = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Asansör4B = new ArrayList<Integer>();
    volatile static ArrayList<Integer> Asansör5B = new ArrayList<Integer>();
    volatile static int Kat1KisiSayisi=0,Kat2KisiSayisi=0,Kat3KisiSayisi=0,Kat4KisiSayisi=0;//Katlardaki kişi sayıları
    volatile static int Asansör1Kat=0;//Asansörlerin anlık bulundukları katlar
    volatile static int Asansör2Kat=0;
    volatile static int Asansör3Kat=0;
    volatile static int Asansör4Kat=0;
    volatile static int Asansör5Kat=0;
    volatile static int Kapasite1=10,Kapasite2=10,Kapasite3=10,Kapasite4=10,Kapasite5=10;//Asansörlerin kapasiteleri
    volatile static String Yön1="Yukari";//Asansörlerin yönleri
    volatile static String Yön2="Yukari";
    volatile static String Yön3="Yukari";
    volatile static String Yön4="Yukari";
    volatile static String Yön5="Yukari";
    volatile static boolean Asansör2Durum=false;//Asansörlerin çalışma durumları
    volatile static boolean Asansör3Durum=false;
    volatile static boolean Asansör4Durum=false;
    volatile static boolean Asansör5Durum=false;
    volatile static String A2Durum="Pasif";
    volatile static String A3Durum="Pasif";
    volatile static String A4Durum="Pasif";
    volatile static String A5Durum="Pasif"; 
    volatile static int CikanKisiSayisi=0;//Çıkış sayısı
    volatile static int GKat1=0,GKat2=0,GKat3=0,GKat4=0;//Giris kattan kaç müsteri kaçınca kata gideceğini tutan değerler
    volatile static int A1Hedef=1,A2Hedef=1,A3Hedef=1,A4Hedef=1,A5Hedef=1;
     public static void main(String args[]) throws InterruptedException {
  
         JFrame frm=new JFrame();
         frm.setSize(1000,1000);
         frm.setLayout(null);
         frm.setVisible(true);
         
         JLabel lbl=new JLabel();
         JLabel cikan=new JLabel();
         JLabel kat1=new JLabel();
         JLabel kat2=new JLabel();
         JLabel kat3=new JLabel();
         JLabel kat4=new JLabel();         
         
         kat1.setBounds(10,250, 300, 30);
         kat2.setBounds(10, 280, 300, 30);
         kat3.setBounds(10, 310, 300, 30);
         kat4.setBounds(10,340, 300, 30);
            
         frm.add(kat1);
         frm.add(kat2);
         frm.add(kat3);
         frm.add(kat4);
                 
         JLabel Gkat1=new JLabel();
         JLabel Gkat2=new JLabel();
         JLabel Gkat3=new JLabel();
         JLabel Gkat4=new JLabel();
                 
         Gkat1.setBounds(10, 70, 300, 30);
         Gkat2.setBounds(10, 100, 300, 30);
         Gkat3.setBounds(10, 130, 300, 30);
         Gkat4.setBounds(10, 160, 300, 30);
                  
         frm.add(Gkat1);
         frm.add(Gkat2);
         frm.add(Gkat3);
         frm.add(Gkat4);       
         frm.add(lbl);
         frm.add(cikan);
         
         frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
         
         kat1.setText("Kat1KisiSayisi=0 Kat1Kuyruk=[]");
         kat2.setText("Kat2KisiSayisi=0 Kat2Kuyruk=[]");
         kat3.setText("Kat3KisiSayisi=0 Kat3Kuyruk=[]");
         kat4.setText("Kat4KisiSayisi=0 Kat4Kuyruk=[]");
                 
         Gkat1.setText("0 Kisi 1.Kata Gidicek");
         Gkat2.setText("0 Kisi 2.Kata Gidicek");
         Gkat3.setText("0 Kisi 3.Kata Gidicek");
         Gkat4.setText("0 Kisi 4.Kata Gidicek");
                  
         lbl.setBounds(10, 40, 300, 30);
         lbl.setText("Giris Kat Kisi Sayisi=0");
         cikan.setBounds(10,400,150,30);
         cikan.setText("Cıkan Kisi Sayısı:0");
         JLabel lbl1=new JLabel();
         frm.add(lbl1);
         
         lbl1.setBounds(450, 10, 800, 30);
         lbl1.setBounds(450, 10, 800, 30);
         
         JLabel a1A=new JLabel();
         frm.add(a1A);        
         a1A.setBounds(500, 10, 600, 30);
         a1A.setText("Asansör1:");
         JLabel a1Durum=new JLabel();
         frm.add(a1Durum);        
         a1Durum.setBounds(540, 30, 600, 30);
         a1Durum.setText("Durum:Aktif");        
         JLabel a1Kat=new JLabel();
         frm.add(a1Kat);        
         a1Kat.setBounds(540, 50, 600, 30);
         a1Kat.setText("Kat:0");
         JLabel a1HedefKat=new JLabel();
         frm.add(a1HedefKat);        
         a1HedefKat.setBounds(540, 70, 600, 30);
         a1HedefKat.setText("Hedef Kat:1");
         JLabel a1Yön=new JLabel();
         frm.add(a1Yön);        
         a1Yön.setBounds(540, 90, 600, 30);
         a1Yön.setText("Yön:Yukarı");
         JLabel a1Kap=new JLabel();
         frm.add(a1Kap);        
         a1Kap.setBounds(540, 110, 600, 30);
         a1Kap.setText("Kapasite:10");
         JLabel a1Kisi=new JLabel();
         frm.add(a1Kisi);        
         a1Kisi.setBounds(540, 130, 600, 30);
         a1Kisi.setText("Asansördeki Kişi Sayısı:0");
         JLabel a1=new JLabel();
         frm.add(a1);        
         a1.setBounds(540, 150, 600, 30);
         a1.setText("Asansörün İçindekiler:[]");
         
         JLabel a2A=new JLabel();
         frm.add(a2A);        
         a2A.setBounds(500, 200, 600, 30);
         a2A.setText("Asansör2:");
         JLabel a2Durum=new JLabel();
         frm.add(a2Durum);        
         a2Durum.setBounds(540, 220, 600, 30);
         a2Durum.setText("Durum:Pasif");        
         JLabel a2Kat=new JLabel();
         frm.add(a2Kat);        
         a2Kat.setBounds(540, 240, 600, 30);
         a2Kat.setText("Kat:0");
         JLabel a2HedefKat=new JLabel();
         frm.add(a2HedefKat);        
         a2HedefKat.setBounds(540, 260, 600, 30);
         a2HedefKat.setText("Hedef Kat:1");
         JLabel a2Yön=new JLabel();
         frm.add(a2Yön);        
         a2Yön.setBounds(540, 280, 600, 30);
         a2Yön.setText("Yön:Yukarı");
         JLabel a2Kap=new JLabel();
         frm.add(a2Kap);        
         a2Kap.setBounds(540, 300, 600, 30);
         a2Kap.setText("Kapasite:10");
         JLabel a2Kisi=new JLabel();
         frm.add(a2Kisi);        
         a2Kisi.setBounds(540, 320, 600, 30);
         a2Kisi.setText("Asansördeki Kişi Sayısı:0");
         JLabel a2=new JLabel();
         frm.add(a2);        
         a2.setBounds(540, 340, 600, 30);
         a2.setText("Asansörün İçindekiler:[]");
         
         JLabel a3A=new JLabel();
         frm.add(a3A);        
         a3A.setBounds(500, 390, 600, 30);
         a3A.setText("Asansör3:");
         JLabel a3Durum=new JLabel();
         frm.add(a3Durum);        
         a3Durum.setBounds(540, 410, 600, 30);
         a3Durum.setText("Durum:Pasif");        
         JLabel a3Kat=new JLabel();
         frm.add(a3Kat);        
         a3Kat.setBounds(540, 430, 600, 30);
         a3Kat.setText("Kat:0");
         JLabel a3HedefKat=new JLabel();
         frm.add(a3HedefKat);        
         a3HedefKat.setBounds(540, 450, 600, 30);
         a3HedefKat.setText("Hedef Kat:1");
         JLabel a3Yön=new JLabel();
         frm.add(a3Yön);        
         a3Yön.setBounds(540, 470, 600, 30);
         a3Yön.setText("Yön:Yukarı");
         JLabel a3Kap=new JLabel();
         frm.add(a3Kap);        
         a3Kap.setBounds(540, 490, 600, 30);
         a3Kap.setText("Kapasite:10");
         JLabel a3Kisi=new JLabel();
         frm.add(a3Kisi);        
         a3Kisi.setBounds(540, 510, 600, 30);
         a3Kisi.setText("Asansördeki Kişi Sayısı:0");
         JLabel a3=new JLabel();
         frm.add(a3);        
         a3.setBounds(540, 530, 600, 30);
         a3.setText("Asansörün İçindekiler:[]");
         
         JLabel a4A=new JLabel();
         frm.add(a4A);        
         a4A.setBounds(500, 580, 600, 30);
         a4A.setText("Asansör4:");
         JLabel a4Durum=new JLabel();
         frm.add(a4Durum);        
         a4Durum.setBounds(540, 600, 600, 30);
         a4Durum.setText("Durum:Pasif");        
         JLabel a4Kat=new JLabel();
         frm.add(a4Kat);        
         a4Kat.setBounds(540, 620, 600, 30);
         a4Kat.setText("Kat:0");
         JLabel a4HedefKat=new JLabel();
         frm.add(a4HedefKat);        
         a4HedefKat.setBounds(540, 640, 600, 30);
         a4HedefKat.setText("Hedef Kat:1");
         JLabel a4Yön=new JLabel();
         frm.add(a4Yön);        
         a4Yön.setBounds(540, 660, 600, 30);
         a4Yön.setText("Yön:Yukarı");
         JLabel a4Kap=new JLabel();
         frm.add(a4Kap);        
         a4Kap.setBounds(540, 680, 600, 30);
         a4Kap.setText("Kapasite:10");
         JLabel a4Kisi=new JLabel();
         frm.add(a4Kisi);        
         a4Kisi.setBounds(540, 700, 600, 30);
         a4Kisi.setText("Asansördeki Kişi Sayısı:0");
         JLabel a4=new JLabel();
         frm.add(a4);        
         a4.setBounds(540, 720, 720, 30);
         a4.setText("Asansörün İçindekiler:[]");
         
         JLabel a5A=new JLabel();
         frm.add(a5A);        
         a5A.setBounds(500, 770, 600, 30);
         a5A.setText("Asansör5:");
         JLabel a5Durum=new JLabel();
         frm.add(a5Durum);        
         a5Durum.setBounds(540, 790, 600, 30);
         a5Durum.setText("Durum:Pasif");        
         JLabel a5Kat=new JLabel();
         frm.add(a5Kat);        
         a5Kat.setBounds(540, 810, 600, 30);
         a5Kat.setText("Kat:0");
         JLabel a5HedefKat=new JLabel();
         frm.add(a5HedefKat);        
         a5HedefKat.setBounds(540, 830, 600, 30);
         a5HedefKat.setText("Hedef Kat:1");
         JLabel a5Yön=new JLabel();
         frm.add(a5Yön);        
         a5Yön.setBounds(540, 850, 600, 30);
         a5Yön.setText("Yön:Yukarı");
         JLabel a5Kap=new JLabel();
         frm.add(a5Kap);        
         a5Kap.setBounds(540, 870, 600, 30);
         a5Kap.setText("Kapasite:10");
         JLabel a5Kisi=new JLabel();
         frm.add(a5Kisi);        
         a5Kisi.setBounds(540, 890, 600, 30);
         a5Kisi.setText("Asansördeki Kişi Sayısı:0");
         JLabel a5=new JLabel();
         frm.add(a5);        
         a5.setBounds(540, 910, 910, 30);
         a5.setText("Asansörün İçindekiler:[]");
          
          Thread Login=new Thread(){
            public void run(){
                while(true)
                {
                            
        Random rand=new Random();
        int GirenMüsteriSayisi=rand.nextInt(10)+1;
     synchronized(GirisKuyruk){
        for(int i=0;i<GirenMüsteriSayisi;i++){
        int MüsteriGidilecekKat=rand.nextInt(4)+1;
        if(MüsteriGidilecekKat==1){
            GKat1++;
        }
        if(MüsteriGidilecekKat==2){
            GKat2++;
        }
        if(MüsteriGidilecekKat==3){
            GKat3++;
        }
        if(MüsteriGidilecekKat==4){
            GKat4++;
        }      
        GirisKuyruk.add(MüsteriGidilecekKat);               
        }       
     }               
                try {                                                                                                                                         
            Thread.sleep(500);                                                                                                                                   
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        } }
            }  
          }; //500ms aralıklarla 1-10 arası rastgele müsterinin girişini sağlayan login threadı                   
          Thread Exit=new Thread(){
              public void run(){
                  while(true){ 
                           try {                                                                                                                                         
            Thread.sleep(1000);                                                                                                                                   
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        }
        Random rand=new Random();
        int CikacakKisiSayisiKat1=0;
        int CikacakKisiSayisiKat2=0;
        int CikacakKisiSayisiKat3=0;
        int CikacakKisiSayisiKat4=0;  
        
       while(true){     
         if(Kat1KisiSayisi>0){
             if(Kat1KisiSayisi>5){
                CikacakKisiSayisiKat1=rand.nextInt(6); 
             }
             else{
         CikacakKisiSayisiKat1=rand.nextInt(Kat1KisiSayisi+1);
             }
         }
         if(Kat2KisiSayisi>0){
         if(Kat2KisiSayisi>5){
                CikacakKisiSayisiKat2=rand.nextInt(6); 
             }
             else{
         CikacakKisiSayisiKat2=rand.nextInt(Kat2KisiSayisi+1);
             }
         }
         if(Kat3KisiSayisi>0){
         if(Kat3KisiSayisi>5){
                CikacakKisiSayisiKat3=rand.nextInt(6); 
             }
             else{
         CikacakKisiSayisiKat3=rand.nextInt(Kat3KisiSayisi+1);
             }
         }
         if(Kat4KisiSayisi>0){
         if(Kat4KisiSayisi>5){
                CikacakKisiSayisiKat4=rand.nextInt(6); 
             }
             else{
         CikacakKisiSayisiKat4=rand.nextInt(Kat4KisiSayisi+1);
             }
         }        
         if(CikacakKisiSayisiKat1+CikacakKisiSayisiKat2+CikacakKisiSayisiKat3+CikacakKisiSayisiKat4<6){            
             break;
         }
}          
       synchronized(Kat1Kuyruk){
       for(int i=0;i<CikacakKisiSayisiKat1;i++){
           Kat1Kuyruk.add(0);
           Kat1KisiSayisi=Kat1KisiSayisi-1;
       }}
       synchronized(Kat2Kuyruk){
       for(int i=0;i<CikacakKisiSayisiKat2;i++){
           Kat2Kuyruk.add(0);
           Kat2KisiSayisi=Kat2KisiSayisi-1;
       }}
       synchronized(Kat3Kuyruk){
       for(int i=0;i<CikacakKisiSayisiKat3;i++){
           Kat3Kuyruk.add(0);
           Kat3KisiSayisi=Kat3KisiSayisi-1;
       }}
       synchronized(Kat4Kuyruk){
       for(int i=0;i<CikacakKisiSayisiKat4;i++){
           Kat4Kuyruk.add(0);
           Kat4KisiSayisi=Kat4KisiSayisi-1;
       }}
        
    }
              }
          };//1000ms aralıklarla rastgele katlardan toplamda 1-5 arası rastgele müsterinin çıkış kuyruguna girmsini saylayan exit threadı
          Thread Asansör1=new Thread(){
           synchronized public void run(){              
                while(true){          
                     try {                                                                                                                                         
            Thread.sleep(200);
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        }
           if("Yukarı".equals(Yön1)){
            
           Asansör1Kat=Asansör1Kat+1;
           A1Hedef=Asansör1Kat+1;
       }
           if("Asagı".equals(Yön1)){
               
           Asansör1Kat=Asansör1Kat-1;
           A1Hedef=Asansör1Kat-1;
       }           
           if(Asansör1Kat==0){               
               Yön1="Yukarı";
               A1Hedef=1;         
           }
           if(Asansör1Kat==4){
               Yön1="Asagı";
               A1Hedef=3;
           }
                     
       if(Asansör1Kat==0){
           synchronized(GirisKuyruk){
           for (int i = 0; i < Asansör1B.size(); i++) {
              if(Asansör1B.get(i)==0){
                  Kapasite1=Kapasite1+1;                 
                  Asansör1B.remove(i);
                  CikanKisiSayisi++;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite1; i++) {
               
              if(GirisKuyruk.size()>0&&i<GirisKuyruk.size()){
               Asansör1B.add(GirisKuyruk.get(i));
               if(GirisKuyruk.get(i)==1){
            GKat1--;
        }
        if(GirisKuyruk.get(i)==2){
            GKat2--;
        }
        if(GirisKuyruk.get(i)==3){
            GKat3--;
        }
        if(GirisKuyruk.get(i)==4){
            GKat4--;
        }       
              Kapasite1=Kapasite1-1;
              GirisKuyruk.remove(i);
              i--;
              }
           }     
       continue; }}
       
       if(Asansör1Kat==1){
           synchronized(Kat1Kuyruk){
           for (int i = 0; i < Asansör1B.size(); i++) {
              if(Asansör1B.get(i)==1){
                  Kapasite1=Kapasite1+1;
                  Asansör1B.remove(i);
                  Kat1KisiSayisi=Kat1KisiSayisi+1;                 
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite1; i++) {
               if(Kat1Kuyruk.size()>0&&i<Kat1Kuyruk.size()){                  
             Asansör1B.add(Kat1Kuyruk.get(i));
               Kapasite1=Kapasite1-1;
               Kat1Kuyruk.remove(i);
               i--;}
           }        
           for (int i = 0; i < Asansör1B.size(); i++) {
               if("Yukarı".equals(Yön1)){
                   if(Asansör1B.get(i)>1){
                       break;
                   }
                   if(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön1="Asagı";
                       break;
                   }
               }
           } 
           if(Asansör1B.isEmpty()&&(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön1="Asagı";
       }              
       continue;}         
       }
       if(Asansör1Kat==2){
           synchronized(Kat2Kuyruk){
           for (int i = 0; i < Asansör1B.size(); i++) {
              if(Asansör1B.get(i)==2){
                  Kapasite1=Kapasite1+1;
                  Asansör1B.remove(i);
                  Kat2KisiSayisi=Kat2KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite1; i++) {
               if(Kat2Kuyruk.size()>0&&i<Kat2Kuyruk.size()){
              
              Asansör1B.add(Kat2Kuyruk.get(i));
               Kapasite1=Kapasite1-1;
               Kat2Kuyruk.remove(i);
               i--;    
                   }
           }               
           for (int i = 0; i < Asansör1B.size(); i++) {
               if("Yukarı".equals(Yön1)){
                   if(Asansör1B.get(i)>2){
                       break;
                   }
                   if(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön1="Asagı";
                       break;
                   }
               }
           }
           if(Asansör1B.isEmpty()&&(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön1="Asagı";
       } 
    continue; }         
       }
       if(Asansör1Kat==3){ 
           synchronized(Kat3Kuyruk){
           for (int i = 0; i < Asansör1B.size(); i++) {
              if(Asansör1B.get(i)==3){
                  Kapasite1=Kapasite1+1;
                  Asansör1B.remove(i);
                  Kat3KisiSayisi=Kat3KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite1; i++) {
               if(Kat3Kuyruk.size()>0&&i<Kat3Kuyruk.size()){
             Asansör1B.add(Kat3Kuyruk.get(i)); 
               Kapasite1=Kapasite1-1;
               Kat3Kuyruk.remove(i);
               i--;}           
           }
      for (int i = 0; i < Asansör1B.size(); i++) {
               if("Yukarı".equals(Yön1)){
                   if(Asansör1B.get(i)>3){
                       break;
                   }
                   if(Kat4Kuyruk.size()==0){
                       Yön1="Asagı";
                       break;
                   }
               }
           }
           if(Asansör1B.isEmpty()&&Kat4Kuyruk.size()==0){
           Yön1="Asagı";         
       } 
  continue; }        
       }     
       if(Asansör1Kat==4){
           
                    
           for (int i = 0; i < Asansör1B.size(); i++) {
              if(Asansör1B.get(i)==4){
                  Kapasite1=Kapasite1+1;
                  Asansör1B.remove(i);
                  Kat4KisiSayisi=Kat4KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite1; i++) {
               if(Kat4Kuyruk.size()>0&&i<Kat4Kuyruk.size()){
             Asansör1B.add(Kat4Kuyruk.get(i));
               Kapasite1=Kapasite1-1;
               Kat4Kuyruk.remove(i);
               i--;            }
           }  
          continue;
       }        
             
                }}
              
          };//200ms aralıklarla asansörün bilgilerini,katlardaki kuyruk bilgisini ve katlarda bulunan kişi sayısını güncelleyen asansör threadleri
          Thread Asansör2=new Thread(){
              
           synchronized public void run(){
              
                while(true){ 
                    synchronized(this){
                        if(Asansör2Durum==true||Asansör2B.size()!=0){
                     try {                                                                                                                                         
            Thread.sleep(200);
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        }
           if("Yukarı".equals(Yön2)){
            
           Asansör2Kat=Asansör2Kat+1;
           A2Hedef=Asansör2Kat+1;
       }
           if("Asagı".equals(Yön2)){
               
           Asansör2Kat=Asansör2Kat-1;
           A2Hedef=Asansör2Kat-1;
       }           
           if(Asansör2Kat==0){
               Yön2="Yukarı";
               A2Hedef=1;               
           }
           if(Asansör2Kat==4){
               Yön2="Asagı";
               A2Hedef=3;
           }
                   
       if(Asansör2Kat==0){
           synchronized(GirisKuyruk){
           for (int i = 0; i < Asansör2B.size(); i++) {
              if(Asansör2B.get(i)==0){
                  Kapasite2=Kapasite2+1;
                  Asansör2B.remove(i);
                  CikanKisiSayisi++;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite2; i++) {
              if(GirisKuyruk.size()>0&&i<GirisKuyruk.size()&&Asansör2Durum==true&&GirisKuyruk.get(i)!=null){
               Asansör2B.add(GirisKuyruk.get(i));
       if(GirisKuyruk.get(i)==1){
            GKat1--;
        }
        if(GirisKuyruk.get(i)==2){
            GKat2--;
        }
        if(GirisKuyruk.get(i)==3){
            GKat3--;
        }
        if(GirisKuyruk.get(i)==4){
            GKat4--;
        }       
              Kapasite2=Kapasite2-1;
              GirisKuyruk.remove(i);
              i--;
              }
           }     
       continue; 
           }}
       if(Asansör2Kat==1){
           synchronized(Kat1Kuyruk){
           for (int i = 0; i < Asansör2B.size(); i++) {
              if(Asansör2B.get(i)==1){
                  Kapasite2=Kapasite2+1;
                  Asansör2B.remove(i);
                  Kat1KisiSayisi=Kat1KisiSayisi+1;                 
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite2; i++) {
               if(Kat1Kuyruk.size()>0&&i<Kat1Kuyruk.size()&&Asansör2Durum==true&&Kat1Kuyruk.get(i)!=null){
             Asansör2B.add(Kat1Kuyruk.get(i));
               Kapasite2=Kapasite2-1;
               Kat1Kuyruk.remove(i);  
               i--;}
           }        
           for (int i = 0; i < Asansör2B.size(); i++) {
               if("Yukarı".equals(Yön2)){
                   if(Asansör2B.get(i)>1){
                       break;
                   }
                   if(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön2="Asagı";
                       break;
                   }
               }
           } 
           if(Asansör2B.isEmpty()&&(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön2="Asagı";
       }              
       continue;         
       }}
       if(Asansör2Kat==2){
           synchronized(Kat2Kuyruk){
           for (int i = 0; i < Asansör2B.size(); i++) {
              if(Asansör2B.get(i)==2){
                  Kapasite2=Kapasite2+1;
                  Asansör2B.remove(i);
                  Kat2KisiSayisi=Kat2KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite2; i++) {
               if(Kat2Kuyruk.size()>0&&i<Kat2Kuyruk.size()&&Asansör2Durum==true&&Kat2Kuyruk.get(i)!=null){
              
              Asansör2B.add(Kat2Kuyruk.get(i));
               Kapasite2=Kapasite2-1;
               Kat2Kuyruk.remove(i);
               i--;    
                   }
           }               
           for (int i = 0; i < Asansör2B.size(); i++) {
               if("Yukarı".equals(Yön2)){
                   if(Asansör2B.get(i)>2){
                       break;
                   }
                   if(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön2="Asagı";
                       break;
                   }
               }
           }
           if(Asansör2B.isEmpty()&&(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön2="Asagı";
       } 
    continue; }         
       }
       if(Asansör2Kat==3){ 
           synchronized(Kat3Kuyruk){
           for (int i = 0; i < Asansör2B.size(); i++) {
              if(Asansör2B.get(i)==3){
                  Kapasite2=Kapasite2+1;
                  Asansör2B.remove(i);
                  Kat3KisiSayisi=Kat3KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite2; i++) {
               if(Kat3Kuyruk.size()>0&&i<Kat3Kuyruk.size()&&Asansör2Durum==true&&Kat3Kuyruk.get(i)!=null){
             Asansör2B.add(Kat3Kuyruk.get(i)); 
               Kapasite2=Kapasite2-1;
               Kat3Kuyruk.remove(i);
               i--;}           
           }
      for (int i = 0; i < Asansör2B.size(); i++) {
               if("Yukarı".equals(Yön2)){
                   if(Asansör2B.get(i)>3){
                       break;
                   }
                   if(Kat4Kuyruk.size()==0){
                       Yön2="Asagı";
                       break;
                   }
               }
           }
           if(Asansör2B.isEmpty()&&Kat4Kuyruk.size()==0){
           Yön2="Asagı";         
       } 
  continue;}         
       }
       if(Asansör2Kat==4){         
           for (int i = 0; i < Asansör2B.size(); i++) {
              if(Asansör2B.get(i)==4){
                  Kapasite2=Kapasite2+1;
                  Asansör2B.remove(i);
                  Kat4KisiSayisi=Kat4KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite2; i++) {
               if(Kat4Kuyruk.size()>0&&i<Kat4Kuyruk.size()){
             Asansör2B.add(Kat4Kuyruk.get(i));
               Kapasite2=Kapasite2-1;
               Kat4Kuyruk.remove(i);
               i--;            }
           }  
          continue;
       }                  
                }}}}
              
          };
          Thread Asansör3=new Thread(){
           synchronized public void run(){
                
                while(true){
                    synchronized(this){
         if(Asansör3Durum==true||Asansör3B.size()!=0){
                     try {                                                                                                                                         
            Thread.sleep(400);
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        }  
                     
                     
          if("Yukarı".equals(Yön3)){
            
           Asansör3Kat=Asansör3Kat+1;
           A3Hedef=Asansör3Kat+1;
       }
           if("Asagı".equals(Yön3)){
               
           Asansör3Kat=Asansör3Kat-1;
           A3Hedef=Asansör3Kat-1;
       }           
           if(Asansör3Kat==0){
               Yön3="Yukarı";
               A3Hedef=1;               
           }
           if(Asansör3Kat==4){
               Yön3="Asagı";
               A3Hedef=3;
           }
       if(Asansör3Kat==0){
           synchronized(GirisKuyruk){
           for (int i = 0; i < Asansör3B.size(); i++) {
              if(Asansör3B.get(i)==0){
                  Kapasite3=Kapasite3+1;
                  Asansör3B.remove(i);
                  CikanKisiSayisi++;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite3; i++) {
              if(GirisKuyruk.size()>0&&i<GirisKuyruk.size()&&Asansör3Durum==true&&GirisKuyruk.get(i)!=null){
               Asansör3B.add(GirisKuyruk.get(i));
             if(GirisKuyruk.get(i)==1){
            GKat1--;
        }
        if(GirisKuyruk.get(i)==2){
            GKat2--;
        }
        if(GirisKuyruk.get(i)==3){
            GKat3--;
        }
        if(GirisKuyruk.get(i)==4){
            GKat4--;
        }
              Kapasite3=Kapasite3-1;
             GirisKuyruk.remove(i);
              i--;
              }
           }       
       continue;} 
       }
       if(Asansör3Kat==1){
           synchronized(Kat1Kuyruk){
           for (int i = 0; i < Asansör3B.size(); i++) {
              if(Asansör3B.get(i)==1){
                  Kapasite3=Kapasite3+1;
                  Asansör3B.remove(i);
                  Kat1KisiSayisi=Kat1KisiSayisi+1;                 
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite3; i++) {
               if(Kat1Kuyruk.size()>0&&i<Kat1Kuyruk.size()&&Asansör3Durum==true&&Kat1Kuyruk.get(i)!=null){
                   System.out.println(" kaç kere:"+Kat1Kuyruk.size());
             Asansör3B.add(Kat1Kuyruk.get(i));
               Kapasite3=Kapasite3-1;
               Kat1Kuyruk.remove(i); 
               i--;}
           }        
           for (int i = 0; i < Asansör3B.size(); i++) {
               if("Yukarı".equals(Yön3)){
                   if(Asansör3B.get(i)>1){
                       break;
                   }
                   if(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön3="Asagı";
                       break;
                   }
               }
           } 
           if(Asansör3B.isEmpty()&&(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön3="Asagı";
       }              
       continue; }        
       }
       if(Asansör3Kat==2){
           synchronized(Kat2Kuyruk){
           for (int i = 0; i < Asansör3B.size(); i++) {
              if(Asansör3B.get(i)==2){
                  Kapasite3=Kapasite3+1;
                  Asansör3B.remove(i);
                  Kat2KisiSayisi=Kat2KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite3; i++) {
               if(Kat2Kuyruk.size()>0&&i<Kat2Kuyruk.size()&&Asansör3Durum==true&&Kat2Kuyruk.get(i)!=null){            
              Asansör3B.add(Kat2Kuyruk.get(i));
               Kapasite3=Kapasite3-1;
               Kat2Kuyruk.remove(i);
               i--;    
                   }
           }               
           for (int i = 0; i < Asansör3B.size(); i++) {
               if("Yukarı".equals(Yön3)){
                   if(Asansör3B.get(i)>2){
                       break;
                   }
                   if(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön3="Asagı";
                       break;
                   }
               }
           }
           if(Asansör3B.isEmpty()&&(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön3="Asagı";
       } 
    continue;}          
       }
       if(Asansör3Kat==3){
           synchronized(Kat3Kuyruk){
           for (int i = 0; i < Asansör3B.size(); i++) {
              if(Asansör3B.get(i)==3){
                  Kapasite3=Kapasite3+1;
                  Asansör3B.remove(i);
                  Kat3KisiSayisi=Kat3KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite3; i++) {
               if(Kat3Kuyruk.size()>0&&i<Kat3Kuyruk.size()&&Asansör3Durum==true&&Kat3Kuyruk.get(i)!=null){
             Asansör3B.add(Kat3Kuyruk.get(i)); 
               Kapasite3=Kapasite3-1;
               Kat3Kuyruk.remove(i);
               i--;}           
           }
      for (int i = 0; i < Asansör3B.size(); i++) {
               if("Yukarı".equals(Yön3)){
                   if(Asansör3B.get(i)>3){
                       break;
                   }
                   if(Kat4Kuyruk.size()==0){
                       Yön3="Asagı";
                       break;
                   }
               }
           }
           if(Asansör3B.isEmpty()&&Kat4Kuyruk.size()==0){
           Yön3="Asagı";         
       } 
  continue;}         
       }
      if(Asansör3Kat==4){         
           for (int i = 0; i < Asansör3B.size(); i++) {
              if(Asansör3B.get(i)==4){
                  Kapasite3=Kapasite3+1;
                  Asansör3B.remove(i);
                  Kat4KisiSayisi=Kat4KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite3; i++) {
               if(Kat4Kuyruk.size()>0&&i<Kat4Kuyruk.size()){
             Asansör3B.add(Kat4Kuyruk.get(i));
               Kapasite3=Kapasite3-1;
               Kat4Kuyruk.remove(i);
               i--;            }
           }  
           Yön3="Asagı";
          continue;
       }        
           
                }}}}
              
          };
          Thread Asansör4=new Thread(){
              
           synchronized public void run(){
              
                while(true){ 
                    synchronized(this){
                        if(Asansör4Durum==true||Asansör4B.size()!=0){
                     try {                                                                                                                                         
            Thread.sleep(400);
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        } 
                     
           if("Yukarı".equals(Yön4)){
            
           Asansör4Kat=Asansör4Kat+1;
           A4Hedef=Asansör4Kat+1;
       }
           if("Asagı".equals(Yön4)){
               
           Asansör4Kat=Asansör4Kat-1;
           A4Hedef=Asansör4Kat-1;
       }           
           if(Asansör4Kat==0){
               Yön4="Yukarı";
               A4Hedef=1;               
           }
           if(Asansör4Kat==4){
               Yön4="Asagı";
               A4Hedef=3;
           }
       if(Asansör4Kat==0){
           synchronized(GirisKuyruk){
           for (int i = 0; i < Asansör4B.size(); i++) {
              if(Asansör4B.get(i)==0){
                  Kapasite4=Kapasite4+1;
                  Asansör4B.remove(i);
                  CikanKisiSayisi++;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite4; i++) {
              if(GirisKuyruk.size()>0&&i<GirisKuyruk.size()&&Asansör4Durum==true&&GirisKuyruk.get(i)!=null){
               Asansör4B.add(GirisKuyruk.get(i));
       if(GirisKuyruk.get(i)==1){
            GKat1--;
        }
        if(GirisKuyruk.get(i)==2){
            GKat2--;
        }
        if(GirisKuyruk.get(i)==3){
            GKat3--;
        }
        if(GirisKuyruk.get(i)==4){
            GKat4--;
        }        
              Kapasite4=Kapasite4-1;
              GirisKuyruk.remove(i);
              i--;
              }
           }     
             Yön4="Yukarı";
       continue; 
           }}
       if(Asansör4Kat==1){
           synchronized(Kat1Kuyruk){
           for (int i = 0; i < Asansör4B.size(); i++) {
              if(Asansör4B.get(i)==1){
                  Kapasite4=Kapasite4+1;
                  Asansör4B.remove(i);
                  Kat1KisiSayisi=Kat1KisiSayisi+1;                 
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite4; i++) {
               if(Kat1Kuyruk.size()>0&&i<Kat1Kuyruk.size()&&Asansör4Durum==true&&Kat1Kuyruk.get(i)!=null){
                   System.out.println(" kaç kere:"+Kat1Kuyruk.size());
             Asansör4B.add(Kat1Kuyruk.get(i));
               Kapasite4=Kapasite4-1;
               Kat1Kuyruk.remove(i);  
               i--;}
           }        
           for (int i = 0; i < Asansör4B.size(); i++) {
               if("Yukarı".equals(Yön4)){
                   if(Asansör4B.get(i)>1){
                       break;
                   }
                   if(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön4="Asagı";
                       break;
                   }
               }
           } 
           if(Asansör4B.isEmpty()&&(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön4="Asagı";
       }              
       continue;         
       }}
       if(Asansör4Kat==2){
           synchronized(Kat2Kuyruk){
           for (int i = 0; i < Asansör4B.size(); i++) {
              if(Asansör4B.get(i)==2){
                  Kapasite4=Kapasite4+1;
                  Asansör4B.remove(i);
                  Kat2KisiSayisi=Kat2KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite4; i++) {
               if(Kat2Kuyruk.size()>0&&i<Kat2Kuyruk.size()&&Asansör4Durum==true&&Kat2Kuyruk.get(i)!=null){
              
              Asansör4B.add(Kat2Kuyruk.get(i));
               Kapasite4=Kapasite4-1;
               Kat2Kuyruk.remove(i);
               i--;    
                   }
           }               
           for (int i = 0; i < Asansör4B.size(); i++) {
               if("Yukarı".equals(Yön4)){
                   if(Asansör4B.get(i)>2){
                       break;
                   }
                   if(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön4="Asagı";
                       break;
                   }
               }
           }
           if(Asansör4B.isEmpty()&&(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön4="Asagı";
       } 
    continue; }         
       }
       if(Asansör4Kat==3){ 
           synchronized(Kat3Kuyruk){
           for (int i = 0; i < Asansör4B.size(); i++) {
              if(Asansör4B.get(i)==3){
                  Kapasite4=Kapasite4+1;
                  Asansör4B.remove(i);
                  Kat3KisiSayisi=Kat3KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite4; i++) {
               if(Kat3Kuyruk.size()>0&&i<Kat3Kuyruk.size()&&Asansör4Durum==true&&Kat3Kuyruk.get(i)!=null){
             Asansör4B.add(Kat3Kuyruk.get(i)); 
               Kapasite4=Kapasite4-1;
               Kat3Kuyruk.remove(i);
               i--;}           
           }
      for (int i = 0; i < Asansör4B.size(); i++) {
               if("Yukarı".equals(Yön4)){
                   if(Asansör4B.get(i)>3){
                       break;
                   }
                   if(Kat4Kuyruk.size()==0){
                       Yön4="Asagı";
                       break;
                   }
               }
           }
           if(Asansör4B.isEmpty()&&Kat4Kuyruk.size()==0){
           Yön4="Asagı";         
       } 
  continue;}         
       }
       if(Asansör4Kat==4){         
           for (int i = 0; i < Asansör4B.size(); i++) {
              if(Asansör4B.get(i)==4){
                  Kapasite4=Kapasite4+1;
                  Asansör4B.remove(i);
                  Kat4KisiSayisi=Kat4KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite4; i++) {
               if(Kat4Kuyruk.size()>0&&i<Kat4Kuyruk.size()){
             Asansör4B.add(Kat4Kuyruk.get(i));
               Kapasite4=Kapasite4-1;
               Kat4Kuyruk.remove(i);
               i--;            }
           }  
           Yön4="Asagı";
          continue;
       }                    
                }}}}
              
          };
          Thread Asansör5=new Thread(){
              
           synchronized public void run(){
              
                while(true){ 
                    synchronized(this){
                        if(Asansör5Durum==true||Asansör5B.size()!=0){
                     try {                                                                                                                                         
            Thread.sleep(400);
        }                                                                                                                                             
        catch (Exception e) {                                                                                                                         
            e.printStackTrace();                                                                                                                      
        }
           if("Yukarı".equals(Yön5)){
            
           Asansör5Kat=Asansör5Kat+1;
           A5Hedef=Asansör5Kat+1;
       }
           if("Asagı".equals(Yön5)){
               
           Asansör5Kat=Asansör5Kat-1;
           A5Hedef=Asansör5Kat-1;
       }           
           if(Asansör5Kat==0){
               Yön5="Yukarı";
               A5Hedef=1;               
           }
           if(Asansör5Kat==4){
               Yön5="Asagı";
               A5Hedef=3;
           }
       if(Asansör5Kat==0){
           synchronized(GirisKuyruk){
           for (int i = 0; i < Asansör5B.size(); i++) {
              if(Asansör5B.get(i)==0){
                  Kapasite5=Kapasite5+1;
                  Asansör5B.remove(i);
                  CikanKisiSayisi++;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite5; i++) {
              if(GirisKuyruk.size()>0&&i<GirisKuyruk.size()&&Asansör5Durum==true&&GirisKuyruk.get(i)!=null){
               Asansör5B.add(GirisKuyruk.get(i));
       if(GirisKuyruk.get(i)==1){
            GKat1--;
        }
        if(GirisKuyruk.get(i)==2){
            GKat2--;
        }
        if(GirisKuyruk.get(i)==3){
            GKat3--;
        }
        if(GirisKuyruk.get(i)==4){
            GKat4--;
        }      
              Kapasite5=Kapasite5-1;
              GirisKuyruk.remove(i);
              i--;
              }
           }     
             Yön5="Yukarı";
       continue; 
           }}
       if(Asansör5Kat==1){
           synchronized(Kat1Kuyruk){
           for (int i = 0; i < Asansör5B.size(); i++) {
              if(Asansör5B.get(i)==1){
                  Kapasite5=Kapasite5+1;
                  Asansör5B.remove(i);
                  Kat1KisiSayisi=Kat1KisiSayisi+1;                 
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite5; i++) {
               if(Kat1Kuyruk.size()>0&&i<Kat1Kuyruk.size()&&Asansör5Durum==true&&Kat1Kuyruk.get(i)!=null){
                   System.out.println(" kaç kere:"+Kat1Kuyruk.size());
             Asansör5B.add(Kat1Kuyruk.get(i));
               Kapasite5=Kapasite5-1;
               Kat1Kuyruk.remove(i);  
               i--;}
           }        
           for (int i = 0; i < Asansör5B.size(); i++) {
               if("Yukarı".equals(Yön5)){
                   if(Asansör5B.get(i)>1){
                       break;
                   }
                   if(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön5="Asagı";
                       break;
                   }
               }
           } 
           if(Asansör5B.isEmpty()&&(Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön5="Asagı";
       }              
       continue;         
       }}
       if(Asansör5Kat==2){
           synchronized(Kat2Kuyruk){
           for (int i = 0; i < Asansör5B.size(); i++) {
              if(Asansör5B.get(i)==2){
                  Kapasite5=Kapasite5+1;
                  Asansör5B.remove(i);
                  Kat2KisiSayisi=Kat2KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite5; i++) {
               if(Kat2Kuyruk.size()>0&&i<Kat2Kuyruk.size()&&Asansör5Durum==true&&Kat2Kuyruk.get(i)!=null){
              
              Asansör5B.add(Kat2Kuyruk.get(i));
               Kapasite5=Kapasite5-1;
               Kat2Kuyruk.remove(i);
               i--;    
                   }
           }               
           for (int i = 0; i < Asansör5B.size(); i++) {
               if("Yukarı".equals(Yön5)){
                   if(Asansör5B.get(i)>2){
                       break;
                   }
                   if(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0){
                       Yön5="Asagı";
                       break;
                   }
               }
           }
           if(Asansör5B.isEmpty()&&(Kat3Kuyruk.size()+Kat4Kuyruk.size()==0)){
           Yön5="Asagı";
       } 
    continue; }         
       }
       if(Asansör5Kat==3){ 
           synchronized(Kat3Kuyruk){
           for (int i = 0; i < Asansör5B.size(); i++) {
              if(Asansör5B.get(i)==3){
                  Kapasite5=Kapasite5+1;
                  Asansör5B.remove(i);
                  Kat3KisiSayisi=Kat3KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite5; i++) {
               if(Kat3Kuyruk.size()>0&&i<Kat3Kuyruk.size()&&Asansör5Durum==true&&Kat3Kuyruk.get(i)!=null){
             Asansör5B.add(Kat3Kuyruk.get(i)); 
               Kapasite5=Kapasite5-1;
               Kat3Kuyruk.remove(i);
               i--;}           
           }
      for (int i = 0; i < Asansör5B.size(); i++) {
               if("Yukarı".equals(Yön5)){
                   if(Asansör5B.get(i)>3){
                       break;
                   }
                   if(Kat4Kuyruk.size()==0){
                       Yön5="Asagı";
                       break;
                   }
               }
           }
           if(Asansör5B.isEmpty()&&Kat4Kuyruk.size()==0){
           Yön5="Asagı";         
       } 
  continue;}         
       }
       if(Asansör5Kat==4){         
           for (int i = 0; i < Asansör5B.size(); i++) {
              if(Asansör5B.get(i)==4){
                  Kapasite5=Kapasite5+1;
                  Asansör5B.remove(i);
                  Kat4KisiSayisi=Kat4KisiSayisi+1;
                  i--;
              } 
           }
           for (int i = 0; i < Kapasite5; i++) {
               if(Kat4Kuyruk.size()>0&&i<Kat4Kuyruk.size()){
             Asansör5B.add(Kat4Kuyruk.get(i));
               Kapasite5=Kapasite5-1;
               Kat4Kuyruk.remove(i);
               i--;            }
           }  
           Yön5="Asagı";
          continue;
       }        
           
                }}}}
              
          };
          Thread AsansörKontrol=new Thread(){
              public void run(){
                  while(true){
                      if(20<GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör2Durum=true;
                          A2Durum="Aktif";
                      }
                      if(10>GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör2Durum=false;
                          A2Durum="Pasif";
                      }
                      if(40<GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör3Durum=true;
                          A3Durum="Aktif";
                      }
                      if(20>GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör3Durum=false;
                          A3Durum="Pasif";
                      }
                      if(60<GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör4Durum=true;
                          A4Durum="Aktif";
                      }
                      if(30>GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör4Durum=false;
                          A4Durum="Pasif";
                      }
                      if(80<GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör5Durum=true;
                          A5Durum="Aktif";
                      }
                      if(40>GirisKuyruk.size()+Kat1Kuyruk.size()+Kat2Kuyruk.size()+Kat3Kuyruk.size()+Kat4Kuyruk.size()+Kat5Kuyruk.size()){
                          Asansör5Durum=false;
                          A5Durum="Pasif";
                      }
                  }
              }
          };//Kuyruk sayılarına ve asansör kapasitelerine bakarak asansör durumlarını kontrol eden thread(Aralıksız sürekli çalışır)
                   
          Login.start();
          Exit.start();          
          AsansörKontrol.start();
          Asansör1.start();
          Asansör2.start();
          Asansör3.start();
          Asansör4.start();
          Asansör5.start();
          
          Login.setPriority(1); 
          Exit.setPriority(2);
          AsansörKontrol.setPriority(3);
          Asansör1.setPriority(4);
          Asansör2.setPriority(5);
          Asansör3.setPriority(6);
          Asansör4.setPriority(7);
          Asansör5.setPriority(8);
                while(true){//200ms aralıklarla bilgileri güncelleyen while döngüsü            
                    try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(Avm.class.getName()).log(Level.SEVERE, null, ex);
           }
            synchronized(GirisKuyruk){
                //     System.out.println("Giris="+GirisKuyruk.size());
                //    System.out.println(""+GirisKuyruk);                    
                    lbl.setText("Giris Kat Kisi Sayisi="+String.valueOf(GirisKuyruk.size()));
                }
         /*         System.out.println("Kat1="+Kat1KisiSayisi+" Kuyruk="+Kat1Kuyruk.size());
                    System.out.println("Kat2="+Kat2KisiSayisi+" Kuyruk="+Kat2Kuyruk.size());                    
                    System.out.println("Kat3="+Kat3KisiSayisi+" Kuyruk="+Kat3Kuyruk.size());                   
                    System.out.println("Kat4="+Kat4KisiSayisi+" Kuyruk="+Kat4Kuyruk.size());
                   
                    System.out.println("Asansör 1="+Asansör1B.size()+" Kat="+Asansör1Kat);
                    System.out.println(""+Asansör1B);
                    System.out.println("Asansör 2="+Asansör2B.size()+" Kat="+Asansör2Kat);
                    System.out.println(""+Asansör2B);
                    System.out.println("Asansör 3="+Asansör3B.size()+" Kat="+Asansör3Kat);
                    System.out.println(""+Asansör3B);
                    System.out.println("Asansör 4="+Asansör3B.size()+" Kat="+Asansör4Kat);
                    System.out.println(""+Asansör4B);*/

                    a1Kat.setText("Kat:"+String.valueOf(Asansör1Kat));
                    a1HedefKat.setText("Hedef Kat:"+String.valueOf(A1Hedef));
                    a1Yön.setText("Yön:"+Yön1);
                    a1Kisi.setText("Asansördeki Kişi Sayısı:"+String.valueOf(Asansör1B.size()));
                    a1.setText("Asansörün İçindekiler:"+String.valueOf(Asansör1B));
                    
                    a2Durum.setText("Durum:"+A2Durum);
                    a2Kat.setText("Kat:"+String.valueOf(Asansör2Kat));
                    a2HedefKat.setText("Hedef Kat:"+String.valueOf(A2Hedef));
                    a2Yön.setText("Yön:"+Yön2);
                    a2Kisi.setText("Asansördeki Kişi Sayısı:"+String.valueOf(Asansör2B.size()));
                    a2.setText("Asansörün İçindekiler:"+String.valueOf(Asansör2B));
                    
                    a3Durum.setText("Durum:"+A3Durum);
                    a3Kat.setText("Kat:"+String.valueOf(Asansör3Kat));
                    a3HedefKat.setText("Hedef Kat:"+String.valueOf(A3Hedef));
                    a3Yön.setText("Yön:"+Yön3);
                    a3Kisi.setText("Asansördeki Kişi Sayısı:"+String.valueOf(Asansör3B.size()));
                    a3.setText("Asansörün İçindekiler:"+String.valueOf(Asansör3B));
                    
                    a4Durum.setText("Durum:"+A4Durum);
                    a4Kat.setText("Kat:"+String.valueOf(Asansör4Kat));
                    a4HedefKat.setText("Hedef Kat:"+String.valueOf(A4Hedef));
                    a4Yön.setText("Yön:"+Yön4);
                    a4Kisi.setText("Asansördeki Kişi Sayısı:"+String.valueOf(Asansör4B.size()));
                    a4.setText("Asansörün İçindekiler:"+String.valueOf(Asansör4B));
                    
                    a5Durum.setText("Durum:"+A5Durum);
                    a5Kat.setText("Kat:"+String.valueOf(Asansör5Kat));
                    a5HedefKat.setText("Hedef Kat:"+String.valueOf(A5Hedef));
                    a5Yön.setText("Yön:"+Yön5);
                    a5Kisi.setText("Asansördeki Kişi Sayısı:"+String.valueOf(Asansör5B.size()));
                    a5.setText("Asansörün İçindekiler:"+String.valueOf(Asansör5B));
                                        
                    kat1.setText("Kat1 Kisi Sayisi="+String.valueOf(Kat1KisiSayisi)+"    Kat1 Kuyruk="+String.valueOf(Kat1Kuyruk.size()));
                    kat2.setText("Kat2 Kisi Sayisi="+String.valueOf(Kat2KisiSayisi)+"    Kat2 Kuyruk="+String.valueOf(Kat2Kuyruk.size()));
                    kat3.setText("Kat3 Kisi Sayisi="+String.valueOf(Kat3KisiSayisi)+"    Kat3 Kuyruk="+String.valueOf(Kat3Kuyruk.size()));
                    kat4.setText("Kat4 Kisi Sayisi="+String.valueOf(Kat4KisiSayisi)+"    Kat4 Kuyruk="+String.valueOf(Kat4Kuyruk.size()));                   
                   
                    Gkat1.setText(GKat1+" Kisi 1.Kata Gidicek");
                    Gkat2.setText(GKat2+" Kisi 2.Kata Gidicek");
                    Gkat3.setText(GKat3+" Kisi 3.Kata Gidicek");
                    Gkat4.setText(GKat4+" Kisi 4.Kata Gidicek");
                    
                    cikan.setText("Cıkan Kisi Sayısı:"+CikanKisiSayisi);                   
                }
                
            }
    
}
