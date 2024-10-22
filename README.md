Merhabalar.

Bu yazımda sizlere SOLID presnsiplerinde yer alan nesne yönelimli programlamanın temel taşlarından biri olan 
Bağımlılıkların Tersine Çevrilmesi (Dependency Inversion) ilkesini inşallah anlatmaya çalışacağım.

Bağımlılıkların tersine çevrilmesi ilkesi, üst sınıfların alt sınıflara direkt olarak bağımlı olmaması yaklaşımına dayanmaktadır.
Doğrudan bağımlı olma durumunda kaynak kod üzerinde yenilikler, değişimler veya bakım onarım faaliyetleri zaman ve kaynak maliyetlerini oldukça arttıracaktır.
Üst seviye sınıfılarda meydana gelen değişim alt sınıflarda da yüksek oranda değişim gerektiriyor ve bozulmalar meydana geliyorsa bu yaklaşım tercih edilmeyen bir yaklaşımdır.

Özellikle ortak geliştirme ortamlarının mevcut olduğu ve daha sonra iyleştirme gerektiren kaynak kod geliştirme süreçlerinde bu tarz güçlük oluşturan yaklaşımlar yerine 
çoklu geliştirici ve iyleştirme süreçlerine uygun prensipler tercih edilerek kaynak kod geliştirilmelidir.
Bu sayede genel süreci olumsuz etkileyen maliyet problemleri minimuma iner ve kaliteli bir ürün ortaya çıkar.

Bağımlılıkların tersine çevrilmesi ilkesi gereksiz kodlamaları azaltacak ve yenileme faaliyetlerine yüksek ölçüde olumlu etkide bulunacaktır.

Bu yaklaşımı bir sosyal medya platformuna post gönderme servisi örneği ile yanlış ve doğru kullanım akışında izâh etmeye çalışalım.
 
## Sosyal Medya Platformları ve Gönderi İşlemleri

### Tercih edilmeyen yaklaşım

Gönderi orkestrasyonu görevini üstlenen PublishService sınıfı, ilgili sosyal medya platformuna post hazırlanması ve akabinde gönderilmesi için ilgili platforma başlık ve içerik verisi gönderir. Daha sonra bu ilgii platform bu verileri alıp kendi özelinde gönderi hazırlar ve gönderiyi yayınlar.

Fakat bu yaklaşımda istenmeyen bazı durumlar var.

* Yeni bir sosyal medya platformu entegre edildiğinde veya silidindiğinde PublishService sınıfına o platforma özel kodun düzenlemesi gerekecektir. Bu platformların 100'lerce olduğu hayal edilirse her platform için ayrı ayrı ekleme/silme işlemleri bakım ve yenileme faaliyetlerine ekstra maliyet yükü getirecektir.
* Sosyal medya platformlarına özel sınıflarda yer alan gönderi yayınlama fonksiyonun silinmesi/değişmesi gibi durumlar sistemin işleyiş yapısını bozacak ve bozulmalar meyadana gelen yerlerde bakım faaliyetleri yürütülecektir.
* Her platforma özel kod yazılması kod yükünü, sayısını ve bakım zorluğunu arttıracaktır.

Kısacası üst sınıfın alt sınıfa bağlı olması alt sınıfta meydana gelen değişimlere duyarlı hale gelecek ve kendisi de değişime uğramak zorunda kalacaktır.
  

![DependencyInvenrsion1](https://github.com/omerfarukgzl/JavaDesignPattern-DependencyInversion/assets/58605364/02205546-ae4e-44c5-9556-4ddc77b20a58)

Yukarıda görüldüğü üzere örnek sosyal medya platformu sınıflarına yer verilmiştir. Bu platformalar kendi özellerinde gönderi metodlarını barındırmaktadır. Fakat sınıflar sosyal medya sınıfı olduklarını garanti etmemekte ve gönderi metodları kontrolsüz olarak oluşturulmuştur. Kontrolsüzden kasıt ise ortak bir yapıda olmaması ve  sosyal medya sınıfı olduğunu üst sınıflara garanti edememesidir. Bu sebeple meydana gelen kontrolsüz değişimler üst sınıflarda da değişimi zorunlu kılacaktır. Böylece istenmeyen durum olan bağımlılık meydana gelecektir.


![DependencyInvenrsion2](https://github.com/omerfarukgzl/JavaDesignPattern-DependencyInversion/assets/58605364/1a561077-b552-48e8-b7b7-c2374664a289)

![DependencyInvenrsion3](https://github.com/omerfarukgzl/JavaDesignPattern-DependencyInversion/assets/58605364/6a8968f2-5600-4b98-a968-8a1846025e86)

Yukarıda yer alan gönderici servisi her platforma özel metodları barındırmaktadır. Bu durum alt seviye sosyal medya platformları ile bağımlılık oluşturmakta ve değişim etkinliklerine karşı doğrudan etki meydana getirmektedir. Dolayısıyla bu durum istenmemekte ve bağımlılığın tersine çevrilmesi için alt sınıflar soyutlanmalıdır. Doğru ve istenen yöntemi aşağıdaki örnekte anlatacağım.


### Tercih edilen yaklaşım

Gönderi orkestrasyonu görevini üstlenen PublishService sınıfı, ilgili sosyal medya platformuna post hazırlanması ve akabinde gönderilmesi için ilgili platforma başlık ve içerik verisi gönderir. Daha sonra bu ilgii platform bu verileri alıp kendi özelinde gönderi hazırlar ve gönderiyi yayınlar.

Bu yaklaşım istenmeyen duruma nazaran doğru tercihleri ve avantajları içermektedir.

* Yeni bir sosyal medya platformu entegre edildiğinde veya silidindiğinde PublishService sınıfı doğrudan etkilenmeyecek ve soyutlama sayesinde ortak bir kod yapısı ile yeni platformların entegre edilmesi veya bakım faaliyetleri oldukça kolay bir hal alacaktır.
* Sosyal medya platformaları olan alt sınıfların soyutlanması sayesinde polimorfizm gibi yaklaşımlara ön ayak olcaktır.
* Kod maliyeti azalacaktır.
* Arayüz kullanımı, test faaliyetlerinde test edilen metodun imzasının değişmeyeceğini garanti eder. Test odaklı geliştirme yaklaşımında sınıflar oluşturulmadan davranışlar test edilebilir. 

Kısacası oluşturulan sınıfların soyutlanması programlama sürecine avantaj sağlayan özellikler kazandırır. Bu soyutlama türlerin ortak yapıda kullanılmasını sağlayacak ve üst sınıfların alt sınıflara doğrudan bağımlı olmamasını, bağımlılığın tersine çevrilmesini sağlayacaktır.


![DependencyInversion](https://github.com/user-attachments/assets/1c71675b-50f2-4b9d-af39-3ee313046251)

Sosyal Meyda sınıfları aşağıdaki arayüzden yapılandandırılmıştır.


![DependencyInversion2](https://github.com/user-attachments/assets/ada73e3c-c209-42c8-906d-eedc44751507)


Post gönderme işlemlerini yapan Publish Service sınıfı artık tavsiye edilmeyen yaklaşım gibi her platforma ayrı ayrı metod yazmak yerine soyutlama sayesinde genel bir işlev oluşturarak işlemlerini yerine getirecektir.

Soyutlanan Social Media sınıfı türünden sosyal medya sınıflarını parametre alarak generic bir yapı kazandırılmıştır. Bu sayede eklenen veya silinen sosyal medya platformları bu servisi etkilemeyecektir. Soyutlama sayesinde Publish Service sınıfı Sosyal Medya sınıflarına bağımlı olmaktan kurtulmuş ve bağımlılık tersine çevrilmiştir.


![DependencyInversion3](https://github.com/user-attachments/assets/4ac57385-85a9-4a78-9eb0-f8496238be1f)


Tüm bu işlemlerin ardından Main sınıfında ilgili sosyal medya platformları SocialMedia arayüzünden çok biçimlilik (polimorfizm) yaklaşımı ile türetilmiştir. Daha sonra post gönderme işemlerini üstelenen PublishService sınıfının nesnesi üretilmiş ve post yayınlama metoduna SocialMedia arayüzünden türetilen sosyal medya platformlarının nesneleri geçilmiştir. 

![DependencyInversion4](https://github.com/user-attachments/assets/8c7f6feb-f246-4209-aab9-b18b6381d1b1)




