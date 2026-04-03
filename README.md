# Student Management System v4

Bu proje, bir Java staj görevi kapsamında geliştirilmiş; başlangıç düzeyindeki bir konsol uygulamasından, kurumsal yazılım prensipleri (Clean Code, SOLID) ve katmanlı mimari standartlarına(Model-Service-UI-Util) sahip profesyonel bir yönetim sistemidir.

🏗 Mimari Yapı (Layered Architecture)
Uygulama, sorumlulukların net bir şekilde ayrıldığı 4 ana katman üzerine inşa edilmiştir:

- **UI Katmanı (`ConsoleMenu`, `ConsoleInputHelper`):** Kullanıcı etkileşimi, menü akışları ve önyüz girdi doğrulaması (Frontend Validation).
- **Service Katmanı (`StudentManager`):** Çekirdek iş mantığı (Business Logic), kuralların işletilmesi ve katmanlar arası orkestrasyon.
- **Repository Katmanı (`StudentRepository`):** Veri erişimi (Data Access), koleksiyon (HashMap) ve bellek yönetimi.
- **Model Katmanı (`Student`):** Sistemin temel veri yapılarını ve gerçek dünya nesnelerini temsil eden çekirdek varlıklar (Entity).
- **DTO Katmanı (`ServiceResult`):** Katmanlar arasında (Örn: Service -> UI) veriyi, mesajları ve başarı durumlarını güvenle taşıyan transfer nesneleri.
- **Util Katmanı (`FileUtil`):** Dosya sistemi I/O işlemleri ve projeden bağımsız çalışabilen evrensel yardımcı araçlar.

## Özellikler
- 🛠 **CRUD İşlemleri:** Öğrenci ekleme, silme, güncelleme ve listeleme.
- 📊 **Hesaplama:** Sınıfın genel not ortalamasını anlık hesaplama.
- 🛡 **Hata Yönetimi:** Geçersiz veri girişlerine karşı (harf/sayı kontrolü) dayanıklılık.
- 🎨 **Gelişmiş Arayüz:** Kullanımı kolay, renkli ve tablo düzeninde konsol menüsü.

🧠 Öğrenim Çıktıları (Learning Outcomes)
Proje süresince içselleştirilen temel bilgisayar bilimleri kavramları:

- Hashing and Time Complexity: O(n) ile O(1) arasındaki performans farkının pratik uygulaması.
- Data Persistence: Verinin yaşam döngüsünü (lifecycle) yönetme.
- Serialization & Deserialization: Nesne tabanlı verinin dosya formatına dönüştürülmesi.
- Separation of Concerns (SoC): Katmanlar arası bağımlılıkların yönetimi.
- Exception Flow Control: Hataların program akışını bozmadan, zarifçe yönetilmesi.

🏋️ Mühendislik Zorlukları (Challenges Overcome)

- Decoupling: İş mantığını UI'dan ayırırken yaşanan mimari karar süreçleri.
- Mastering Flow Control: if-else kontrolleri ile Custom Exception kullanımı arasındaki dengeyi kurmak.
- Data Transformation: Boolean dönen basit metotlardan, zengin veri taşıyan DTO (ServiceResult) yapısına geçiş.

🛠 Kullanılan Teknolojiler

Dil: Java 25
Veri Saklama: Plain Text / File I/O
Mimariler: DAO/Repository Pattern, DTO Pattern, Layered Architecture
IDE: IntelliJ IDEA

## Nasıl Çalıştırılır?
1. Projeyi bilgisayarınıza klonlayın.
2. `com.mini.project.v4.Main` sınıfını bir IDE (IntelliJ, Eclipse vb.) ile çalıştırın.
3. Uygulama açıldığında varsa mevcut veriler otomatik olarak students.txt dosyasından yüklenecektir.
