import com.workintech.library.Book;
import com.workintech.library.CATEGORIES;
import com.workintech.library.Library;
import com.workintech.person.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Merhaba kütüphanemize hoş geldiniz");
        System.out.println("-----------------------");
        //1.Sisteme yeni kitap eklenebilir.
        Book book1 = new Book(1,"Batuhan","Masalsı Harikalar Diyarı",80,false, CATEGORIES.JOURNALS);
        Book book2 = new Book(2,"Mehmet","Kırmızı Diyar",70,false,CATEGORIES.MAGAZINES);
        Book book3 = new Book(3,"Batuhan","Diyar Pala Diyarı",90,true,CATEGORIES.STUDYBOOKS);
        Book book4 = new Book(4,"Firat","Robin Hood",100,false,CATEGORIES.MAGAZINES);
        Book book5 = new Book(5,"Kazım","Flikon Hood",110,false,CATEGORIES.MAGAZINES);
        Book book6 = new Book(6,"Batuhan","Cakar Hood",120,false,CATEGORIES.MAGAZINES);


        //Eklenen kitapları, Librarye ekleme
        Library library = new Library();
        library.new_book(book1);
        library.new_book(book2);
        library.new_book(book3);
        library.new_book(book4);
        library.new_book(book5);
        library.new_book(book6);

        System.out.println("Görev 1: Kitap ekleme işlemi başarılı, eklenen kitap:" + book2);

        //----------------------------------------------------------------------------------------------------------------//

        System.out.println("-----------------------");

        //Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir
        //2.Name'e göre kitap arama
        Book foundBookById = library.findBookById(6);
        if(foundBookById != null){
            System.out.println("\"Görev 2:Bulunan kitap: " + foundBookById);
        }else {
            System.out.println("Görev 2: Belirtilen ID'ye sahip kitap bulunamadı.");
        }

        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//

        //3.Sistemde var olan bir kitabın bilgileri güncellenebilir.
        Book changeBookById = library.findBookById(4);
        changeBookById.setAuthor("Marcus Aurelius");
        changeBookById.setName("The Last Rome");
        changeBookById.setPrice(500);
        changeBookById.setStatus(true);
        changeBookById.setCategories(CATEGORIES.STUDYBOOKS);
        System.out.println("Görev 3: Kitabınız güncellenmiştir, güncenllenmiş hali:" + changeBookById);
        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//
        //4.Sistemde var olan bir kitap silinebilir.
        System.out.println("Görev 4:Sistem de var olan bir kitap silindi");
        long silinecekKitap = 3;
        library.deleteBook(silinecekKitap);
        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//

        //5.Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.
        System.out.println("Görev 5:" + CATEGORIES.MAGAZINES + " " + " Kategorisindeki tüm kitaplar Listeleniyor.");
        CATEGORIES desiredCategory = CATEGORIES.MAGAZINES;
        library.findBookByCategory(desiredCategory);

        System.out.println("-----------------------");


        //----------------------------------------------------------------------------------------------------------------//


        //6.Sistemde var olan bir yazarın tüm kitapları listelenebilir
        System.out.println("Görev 6:Batuhan adlı yazarın tüm kitapları aşağıda listeleniyor...");
        library.findByAuthor("Batuhan");
        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//

        //7.Bir kullanıcı sistemde eğer kitap kütüphanede varsa ve başkası tarafından alınmadıysa bir kitabı ödünç alabilir. //
        // Bu durum yaşanırsa hangi kitabın hangi kullanıcıda olduğunun bilgisi tutulmalıdır. //

        //7-1)Kullanıcı Kaydı Oluşturma.
        Member_Record member1 = new Student("Batuhan",25,new Adress("Turkey","Mugla","22","555-821-0155"),0,MEMBER_TYPE.STUDENT);
        Member_Record member2 = new Faculty("Mehmet",15,new Adress("Turkey","Istanbul","48","555-821-0122"),0,MEMBER_TYPE.FACULTY);
        Member_Record member3 = new Faculty("Jack Sparrow",14,new Adress("America","Los Angeles","22","555-821-0101"),5,MEMBER_TYPE.FACULTY);

        System.out.println("Kullanıcı Kaydı oluşturuldu");
        System.out.println(member1);
        System.out.println(member2);

        System.out.println("*****");

        //7-2) Kullanıcının Kitabı Ödünç Alması
        System.out.println("1.Başarılı ödünç alma simülasyonu.");
        library.borrowBook(member1,book1);

        //7-3)Zaten ödünç verilmiş bir kitabın alınmaya calısması simülasyonu.
        System.out.println("2.Daha önce ödünç alınmış kitapı almaya çalışma simülasyonu.");
        library.borrowBook(member2,book1);

        //7-4)Hali hazır da 5 tane kitap ödünç almış birisinin tekrardan kitap almaya çalışma simülasyonu.
        System.out.println("3.Maximum Ödünç Alma Sayısını Aşma Simülasyonu");
        library.borrowBook(member3,book6);


    }
}