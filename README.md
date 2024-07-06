Merhabalar.

Bu yazımda sizlere SOLID presnsiplerinde yer alan nesne yönelimli programlamanın temel taşlarından biri olan 
Bağımlılıkların Tersine Çevrilmesi (Dependency Inversion) ilkesini inşallah anlatmaya çalışacağım.

Bağımlılıkların tersine çevrilmesi ilkesi, üst sınıfların alt sınıfa direkt olarak bağımlı olmaması yaklaşımına dayanmaktadır.
Doğrudan bağımlı olma durumunda kaynak kod üzerinde yenilikler, değişimler veya bakım onarım faliyetleri zaman ve kaynak maliyetlerini oldukça arttıracaktır.
Üst seviye sınıfılarda meydana gelen değişim alt sınıflarda da yüksek oranda değişim gerektiriyor ve bozulmalar meydana geliyorsa bu yaklaşım tercih edilmeyen bir yaklaşımdır.

Özellikle ortak geliştirme ortamlarının mevcut olduğu ve daha sonra iyleştirme gerektiren kaynak kod geliştirme süreçlerinde bu tarz güçlük oluşturan yaklaşımlar yerine 
çoklu geliştirici ve iyleştirme süreçlerine uygun prensipler tercih edilerek kaynak kod geliştirilmelidir.
Bu sayede genel süreci olumsuz etkileyen maliyet problemleri minimuma inecek ve kaliteli bir ürün ortaya çıkacaktır.

Bağımlılıkların tersine çevrilmesi ilkesi gereksiz kodlamaları azaltacak ve yenileme faliyetlerine yüksek ölçüde olumlu etkide bulunacaktır.

Bu yaklaşımı bir sosyal medya platformuna post gönderme servisi örneği ile yanlış ve doğru kullanım akışında izâh etmeye çalışalım.
 
# Bir Sosyal Medya Platformuna Post Atılması

## Tercih edilmeyen yaklaşım

Gönderi orkestrasyonu görevini üstlenen PublishService sınıfı, ilgili sosyal medya platformuna post hazırlanması ve akabinde gönderilmesi için ilgili platforma başlık ve içerik verisi gönderir. Daha sonra bu ilgii platform bu verileri alıp kendi özelinde gönderi hazırlar ve gönderiyi yayınlar.

Fakat bu yaklaşımda istenmeyen bazı durumlar var.

* Yeni bir sosyal medya platformu entegre edildiğinde veya silidindiğinde PublishService sınıfına o platforma özel kodun düzenlemesi gerekecek. Bu platformların 100'lerce olduğu hayal edilirse her platform için ayrı ayrı ekleme/silme işlemleri bakım ve yenileme faliyetlerine ekstra maliyet yükü getirecektir.
* Sosyal medya platformlarına özel sınıflarda yer alan gönderi yayınlama fonksiyonun silinmesi/değişmesi gibi durumlar sistemin işleyiş yapısını bozacak ve bozulmalar meyadana gelen yerlerde bakım faliyetleri yürütülecektir.
* Her platforma özel kod yazılması kod yükünü, sayısını ve bakım zorluğunu arttıracaktır.

Kısacası üst sınıfın alt sınıfa bağlı olması alt sınıfta meydana gelen değişimlere duyarlı hale geelecek ve kendisi de değişime uğramak zorunda kalacaktır.
  

![DependencyInvenrsion1](https://github.com/omerfarukgzl/JavaDesignPattern-DependencyInversion/assets/58605364/02205546-ae4e-44c5-9556-4ddc77b20a58)
