package Proje_Atm.Proje_Atm;

import java.util.Scanner;


public class Giris {

    static Scanner scan = new Scanner(System.in);
    static String kartNo = "1010101010";
    static String sifre = "zeynep";
    static double bakiye = 1000;


    public static void kartKontrol() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Lutfen kart numaranizi giriniz: ");
            String kartNumara = scan.nextLine();
            if (kartNumara.contains(" ")) {
                kartNumara = kartNumara.replaceAll(" ", "");
            }
            if (!kartNo.equals(kartNumara)) {
                System.out.println("Lutfen kart numaranizi dogru giriniz");
                if (i == 2) {
                    System.out.println("3 kere hatali girdiniz.Cikis yapiliyor!");
                    System.exit(0);
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    System.out.println("Sifrenizi giriniz: ");
                    String sifreAlinan = scan.next();
                    if (!sifreAlinan.equals(sifre)) {
                        System.out.println("Yanlis sifre! Kalan deneme hakki: " + (2 - j));
                        if (j == 2) {
                            System.out.println("Kartiniz bloklandi!");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Giris basarili");
                        anaMenu();


                    }
                }

            }
        }
    }

    public static void anaMenu() {
        String secim = "";
        Scanner scanner = new Scanner(System.in);
        do {
            menuText();
            secim = scanner.next().substring(0, 1);
            switch (secim) {
                case "1" -> bakiyeSorgu();
                case "2" -> paraYatirma();
                case "3" -> paraCekme();
                case "4" -> paraGonderme();
                case "5" -> sifreDegistirme();
                case "6" -> cikis();
                default -> System.out.println("hatalı seçim");
            }
        } while (!secim.equalsIgnoreCase("6"));
    }

    public static void menuText() {
        String menuText = """
                  --  ATM ye Hosgeldiniz --
                1 : Bakiye Sorgula
                2 : Para Yatirma
                3 : Para Cekme
                4 : Para Gonderme
                5 : Sifre Degistirme
                6 : Cikis  
                """;
        System.out.println(menuText);
    }

    public static void bakiyeSorgu() {
        System.out.println("Bakiyeniz: " + bakiye);
    }

    public static void paraYatirma() {
        System.out.println("Yatirmak istediginiz miktari giriniz: ");
        double yatanMiktar = scan.nextDouble();
        bakiye = bakiye + yatanMiktar;
        System.out.println("Islem basarili! Yeni bakiyeniz: " + bakiye);
    }

    public static void paraCekme() {
        System.out.println("Cekmek istediginiz miktari giriniz: ");
        double cekilenMiktar = scan.nextDouble();
        if (cekilenMiktar > bakiye) {
            System.out.println("Bakiye yetersiz!");
        } else {
            bakiye = bakiye - cekilenMiktar;
            System.out.println("Islem basarili! Yeni bakiyeniz: " + bakiye);
        }
    }

    public static void paraGonderme() {
        System.out.println("Gondermek istediginiz ibani giriniz: ");
        System.out.print("TR");
        String iban = scan.next();
        if (iban.length() != 26) {
            System.out.println("Hatali giris!");
            anaMenu();
        } else {
            System.out.println("Gondermek istediginiz miktari giriniz: ");
            double gonderilenMiktar = scan.nextDouble();

            if (gonderilenMiktar > bakiye) {
                System.out.println("Bakiye yetersiz!");
            } else {
                bakiye = bakiye - gonderilenMiktar;
                System.out.println("Islem basarili! Yeni bakiyeniz: " + bakiye);
            }
        }


    }

    public static void sifreDegistirme() {
        System.out.println("Mevcut sifrenizi giriniz: ");
        String mevcutSifre = scan.next();
        for (int i = 0; i < 3; i++) {
            if (!mevcutSifre.equals(sifre)) {
                System.out.println("Hatali giris! Lutfen dogru sifreyi giriniz: ");
                System.out.println("Kalan hakkiniz: " + (2 - i));

                if (i == 2) {
                    System.out.println("Deneme hakkiniz bitmistir. Menuye yonlendiriliyorsunuz.");
                    anaMenu();
                }scan.next();
            }
            else{
                System.out.println("Yeni sifreyi giriniz");
                String yeniSifre = scan.next();
                sifre = yeniSifre;
                System.out.println("Sifreniz basariyla degistirildi.");break;
            }

        }
        }


    public static void cikis() {
        System.out.println("Cikis yapiliyor!");
        System.exit(0);
    }
}
