# Android Character App 📱

Bu Android uygulaması, belirli karakterlerin listesini görüntülemek için bir API ile etkileşime geçer ve kullanıcılara her karakterin ayrıntılarını görüntüleme olanağı sağlar.

## Özellikler ✨

- 📋 Karakter listesini görüntüleme
- 📄 Her karakterin ayrıntılarını görüntüleme
- 🌐 Karakter listesi API'si ile etkileşim

## Teknolojiler 🛠

Bu proje aşağıdaki teknolojileri kullanır:

- [Kotlin](https://kotlinlang.org/): Ana programlama dili
- [Retrofit](https://square.github.io/retrofit/): API ile etkileşim sağlamak için kullanılır
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Android uygulamasının veri yönetimi
- [Data Binding](https://developer.android.com/topic/libraries/data-binding): Verilerin UI ile bağlanmasını kolaylaştırır
- [Moshi](https://github.com/square/moshi): JSON verileri serileştirme ve ayrıştırma için kullanılır
- [RecyclerView](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView): Liste görünümü oluşturmak için kullanılır

## Kullanım 🚀

Bu uygulama, karakter listesini API'den çekmek için [CharacterApiServis](#characterapiservis) kullanır. Karakterlerin ayrıntılarını görüntülemek için [DetailFragment](#detailfragment) kullanılır. [HomeFragment](#homefragment), karakter listesini görüntülemek için kullanılır.

## Örnek Kodlar 📦

Bu projede kullanılan bazı önemli kod örnekleri:

- [CharacterAdapter](#characteradapter): Karakter listesini RecyclerView ile göstermek için kullanılan özel bir adaptör.
- [CharacterModel](#charactermodel): Karakter veri modeli.
- [CharacterApi](#characterapi): Karakterleri API ile iletişim kurmak için kullanılan Retrofit servisi.
- [DetailViewModel](#detailviewmodel): Karakter ayrıntılarına yönelik iş mantığını yöneten ViewModel.
- [HomeViewModel](#homeviewmodel): Karakter listesini ve ayrıntıları yöneten ViewModel.

Daha fazla kod örneği ve ayrıntılar için kodları inceleyin.

## Kurulum 🛠

Bu uygulamayı yerel bir geliştirme ortamında çalıştırmak için aşağıdaki adımları izleyin:

1. Projeyi GitHub'dan klonlayın: `git clone https://github.com/kullanici/character-app.git`
2. Android Studio veya başka bir uygun IDE kullanarak projeyi açın.
3. Gerekli bağımlılıkları (Retrofit, Moshi vb.) projenize ekleyin.
4. API ile etkileşim sağlamak için API anahtarınızı projeye ekleyin (varsayılan olarak `BASE_URL` kullanılır).




## Ekran Görüntüleri 📸
![1](https://github.com/GulayAdgzl/KotlinCase/assets/44726684/2c8f716b-abf4-480f-9e49-7ec11be0245c)

----------------------------
![2](https://github.com/GulayAdgzl/KotlinCase/assets/44726684/04c79097-aebf-4d7c-9893-57b57f11deb4)


Burada uygulamanın çalışırken görüntüleri yer alacak:




