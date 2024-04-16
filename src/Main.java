import com.workintech.library.Book;
import com.workintech.library.CATEGORIES;
import com.workintech.library.Library;
import com.workintech.person.Librarian;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Merhaba kütüphanemize hoş geldiniz");
        System.out.println("-----------------------");
        //1.Sisteme yeni kitap eklenebilir.
        Book book1 = new Book(1,"Batuhan","Masalsı Harikalar Diyarı",80,false, CATEGORIES.JOURNALS);
        Book book2 = new Book(2,"Ahmet","Kırmızı Diyar",70,false,CATEGORIES.MAGAZINES);
        Book book3 = new Book(3,"Ayse","Diyar Pala Diyarı",90,true,CATEGORIES.STUDYBOOKS);
        Book book4 = new Book(4,"Firat","Robin Hood",100,false,CATEGORIES.MAGAZINES);
        Book book5 = new Book(5,"Kazım","Flikon Hood",110,false,CATEGORIES.MAGAZINES);
        Book book6 = new Book(6,"Cakar","Cakar Hood",120,false,CATEGORIES.MAGAZINES);


        //Eklenen kitapları, Librarye ekleme
        Library library = new Library();
        library.new_book(book1);
        library.new_book(book2);
        library.new_book(book3);
        library.new_book(book4);
        library.new_book(book5);
        library.new_book(book6);

        System.out.println("Görev 1: Kitap ekleme işlemi başarılı, eklenen kitap:" + book1);

        //----------------------------------------------------------------------------------------------------------------//

        System.out.println("-----------------------");
        //Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir
        //2.Name'e göre kitap arama
        Book foundBookById = library.findBookById(6);
        if(foundBookById != null){
            System.out.println("Bulunan kitap: " + foundBookById);
        }else {
            System.out.println("Görev 2: Belirtilen ID'ye sahip kitap bulunamadı.");
        }

        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//

        //3.Sistemde var olan bir kitabın bilgileri güncellenebilir.
        Book changeBookById = library.findBookById(1);
        changeBookById.setAuthor("Marcus Aurelius");
        changeBookById.setName("The Last Rome");
        changeBookById.setPrice(500);
        changeBookById.setStatus(true);
        changeBookById.setCategories(CATEGORIES.STUDYBOOKS);
        System.out.println("Görev 3: Kitabınız güncellenmiştir, güncenllenmiş hali:" + changeBookById);
        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//
        //4.Sistemde var olan bir kitap silinebilir.
        long silinecekKitap = 3;
        library.deleteBook(silinecekKitap);
        System.out.println("-----------------------");

        //----------------------------------------------------------------------------------------------------------------//

        //5.Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.
        CATEGORIES desiredCategory = CATEGORIES.MAGAZINES;
        library.findBookByCategory(desiredCategory);
    }
}