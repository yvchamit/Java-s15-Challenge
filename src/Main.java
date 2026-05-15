import com.workintech.library_system.entity.*;


public class Main {
    public static void main(String[] args) {

        stars();
        Author yazar1 = new Author(1L, "Yaşar Kemal");
        Author yazar2 = new Author(2L, "Sabahattin Ali");
        Author yazar3 = new Author(3L, "Robert C. Martin");
        Author yazar4 = new Author(4L, "James Gosling");

        Library library = new Library();
        LibraryManager manager = new LibraryManager(library);


        // 1-) Sisteme yeni kitap eklenebilir.

        manager.addBook(new StudyBooks(301L, "Clean Code", yazar3, 120.0, "Yazılım"));
        manager.addBook(new StudyBooks(302L, "Effective Java", yazar4, 150.0, "Yazılım"));
        manager.addBook(new StudyBooks(303L, "Clean Architecture", yazar3, 130.0, "Yazılım"));

        manager.addBook(new StudyBooks(101L, "İnce Memed 1", yazar1, 45.0, "Edebiyat"));
        manager.addBook(new StudyBooks(102L, "İnce Memed 2", yazar1, 45.0, "Edebiyat"));
        manager.addBook(new StudyBooks(103L, "Kürk Mantolu Madonna", yazar2, 30.0, "Roman"));
        manager.addBook(new StudyBooks(104L, "Kuyucaklı Yusuf", yazar2, 35.0, "Roman"));

        manager.addBook(new Magazines(201L, "Bilim Teknik", new Author(5L, "TÜBİTAK"), 15.0, 650));
        manager.addBook(new Magazines(202L, "Atlas", new Author(6L, "DBR"), 20.0, 310));

        stars();

        // 2-) Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir.
        manager.searchBook("Effective Java");
        manager.findBookByAuthor(yazar1.getName());

        stars();

        // 3-)Sistemde var olan bir kitabın bilgileri güncellenebilir.
        System.out.println("Güncelleme Öncesi:");
        manager.searchBook("Clean Code");

        stars();
        manager.updateBookDetails(301L, "Clean Code V2", yazar2, "Programming");

        System.out.println("\nGüncelleme Sonrası:");
        manager.searchBook("Clean Code V2");
        stars();


        // 4-) Sistemde var olan bir kitap silinebilir.
        manager.searchBook("Atlas");
        manager.removeBook(202L);
        stars();
        manager.searchBook("Atlas");
        stars();

        // 5-) Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.
        // 6-) Sistemde var olan bir yazarın tüm kitapları listelenebilir;
        manager.listByCategory("Yazılım");
        stars();
        manager.findBookByAuthor("James Gosling");


        // 7-) Bir kullanıcı sistemde eğer kitap kütüphanede varsa ve başkası tarafından alınmadıysa bir kitabı ödünç alabilir. Bu durum yaşanırsa hangi kitabın hangi kullanıcıda olduğunun bilgisi tutulmalıdır.
        // 8-) Aynı şekilde kullanıcı kitap geri teslimde edebilir.
        // 9-) Kullanıcıların 5 kitap limiti olmalı ve bu kitap limitine ulaştıklarında daha fazla kitap alamamalılar.

        Book book = new StudyBooks(304L, "Algorithm", yazar1, 100.0, "Yazılım");
        manager.addBook(book);

        Student student = new Student(1L, "Ali Veli");
        manager.registerMember(student);

        manager.lendBook(304L, 1L);

        System.out.println("Kitap Durumu: " + book.getStatus());
        System.out.println("Ali'nin Kitap Sayısı: " + student.getMemberRecord().getNoBooksIssued());

        stars();
        manager.returnBook(304L, 1L);
        System.out.println("Ali'nin Kitap Sayısı: " + student.getMemberRecord().getNoBooksIssued());

        stars();
        manager.lendBook(301L, 1L);
        manager.lendBook(302L, 1L);
        manager.lendBook(303L, 1L);
        manager.lendBook(101L, 1L);
        manager.lendBook(102L, 1L);
        System.out.println("Ali'nin Kitap Sayısı: " + student.getMemberRecord().getNoBooksIssued());
        stars();
        manager.lendBook(103L, 1L);
        stars();
        manager.returnBook(301L, 1L);
        manager.returnBook(302L, 1L);
        System.out.println("Ali'nin Kitap Sayısı: " + student.getMemberRecord().getNoBooksIssued());
        stars();

        student.getMemberRecord().getAccount().setBalance(-50.0);
        System.out.println("Ali'nin Güncel Bakiyesi: " + student.getMemberRecord().getAccount().getBalance() + " TL");
        manager.lendBook(103L, 1L);

    }

    public static void stars(){
        System.out.println("\n<-------------- ***** -------------->\n");
    }
}