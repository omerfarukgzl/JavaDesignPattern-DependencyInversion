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

Sosyal medya platformlarına gönderilen başlık ve içerik bilgisi ile gönderi hazırlanır ve daha sonra bu platformun servisi 
