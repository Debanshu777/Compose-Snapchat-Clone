<h1 align="center">
Snapchat Compose Clone👻
<br>
<br>
<img src="https://github.com/Debanshu777/Compose-Snapchat-Clone/blob/dev/imageAssets/SnapchatGif.gif" width=300 height=300/>
</h1>
<h1 align="center">
  <img src="https://github.com/Debanshu777/Compose-Snapchat-Clone/blob/dev/imageAssets/bannerSnapchat.jpg" width=900 height=300/>
</h1>

## Background🌟

***Work in progress***
<p>
This is UI Clone of Snapchat, which is used to show the power of Jetpack Compose. This a personal project with the goal to learn Clean Architecture with Jetpack compose. I have tried to add all the native components like Camera, Mapview and Exoplayer and showcase as an example.
<br>
Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
</p> 

## Dependencies & References⚡

#### Navigation🚀
* <a href="https://developer.android.com/jetpack/compose/navigation"> ***androidx.navigation:navigation-compose:2.4.0-beta02*** </a> <br>The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component’s infrastructure and features.
* Reference <a href="https://blog.mindorks.com/jetpack-compose-navigation">https://blog.mindorks.com/jetpack-compose-navigation</a>
#### Camara📸
camerax_version = "1.0.2"
* <a href="https://developer.android.com/jetpack/androidx/releases/camera"/> ***androidx.camera:camera-core,androidx.camera:camera-camera2,androidx.camera:camera-lifecycle, androidx.camera:camera-view:1.0.0-alpha31*** </a>
* Refernence 
  - <a href="https://proandroiddev.com/compose-camerax-on-android-58578f37e6df"/>https://proandroiddev.com/compose-camerax-on-android-58578f37e6df</a>
  - <a href="https://www.youtube.com/watch?v=gRMznojSHxE&t=321s"/>https://www.youtube.com/watch?v=gRMznojSHxE&t=321s</a>
#### Google Map🗺
* ***com.google.maps.android:android-maps-utils:2.2.3, com.google.android.libraries.maps:maps:3.1.0-beta, com.google.maps.android:maps-v3-ktx:2.2.0, androidx.fragment:fragment-ktx:1.4.0***
* References 
  - <a href="https://medium.com/geekculture/google-maps-in-jetpack-compose-android-ae7b1ad84e9"/>https://medium.com/geekculture/google-maps-in-jetpack-compose-android-ae7b1ad84e9</a>
  - <a href="https://johnoreilly.dev/posts/jetpack-compose-google-maps/"> https://johnoreilly.dev/posts/jetpack-compose-google-maps/ </a>
  - <a href="https://www.youtube.com/watch?v=2tu-hNbyViU"/>https://www.youtube.com/watch?v=2tu-hNbyViU</a>
#### Video Player📽
* <a href="https://github.com/google/ExoPlayer"/> ***com.google.android.exoplayer:exoplayer:2.16.1*** </a> <br> ExoPlayer is an application level media player for Android. It provides an alternative to Android’s MediaPlayer API for playing audio and video both locally and over the Internet. ExoPlayer supports features not currently supported by Android’s MediaPlayer API, including DASH and SmoothStreaming adaptive playbacks. 
* References
  - <a href="https://proandroiddev.com/using-exoplayer-in-lazycolumn-65c47e0ceed5"/>https://proandroiddev.com/using-exoplayer-in-lazycolumn-65c47e0ceed5</a>
  - < ahref="https://medium.com/compose-in-the-room/integrating-exoplayer-in-jetpack-compose-38fca2f76bb4"/>https://medium.com/compose-in-the-room/integrating-exoplayer-in-jetpack-compose-38fca2f76bb4</a>
  - <a href="https://www.youtube.com/watch?v=Ve_bI_HJQy4"/>https://www.youtube.com/watch?v=Ve_bI_HJQy4</a>
#### Coil🍥
* <a href="https://github.com/coil-kt/coil">com.google.android.exoplayer:exoplayer:2.16.1</a> <br> Image loading for Android backed by Kotlin Coroutines.
* References 
  - <a href="https://proandroiddev.com/loading-images-for-jetpack-compose-using-glide-coil-and-fresco-1211261a296e"/>https://proandroiddev.com/loading-images-for-jetpack-compose-using-glide-coil-and-fresco-1211261a296e</a>
  - <a href="https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217"/>https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217</a>
#### Hiding Secrect Key🔑
* <a href="https://github.com/google/secrets-gradle-plugin">***com.google.android.libraries.mapsplatform.secrets-gradle-plugin***</a><br>This Gradle plugin reads secrets from a properties file not checked into version control, such as local.properties, and expose those properties as variables in the Gradle-generated BuildConfig class and in the Android manifest file.
* References
  - <a href="https://www.youtube.com/watch?v=X8lYNW_Or2o">https://www.youtube.com/watch?v=X8lYNW_Or2o</a>
#### Accompanist✨
* <a href="https://github.com/google/accompanist/">com.google.accompanist:accompanist-permissions, com.google.accompanist:accompanist-pager:0.19.0</a><br>Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.
* References
  - <a href="https://google.github.io/accompanist/">https://google.github.io/accompanist/</a>
  - <a href="https://medium.com/surfstudio/accompanist-the-first-chord-a-jetpack-compose-library-reviewed-9e007771db70">https://medium.com/surfstudio/accompanist-the-first-chord-a-jetpack-compose-library-reviewed-9e007771db70</a>
#### Detekt🐱‍🏍
* <a href="https://github.com/detekt/detekt">io.gitlab.arturbosch.detekt</a><br>Static code analysis for Kotlin
* References
  - <a href="https://www.youtube.com/watch?v=o384NbCDB0U">https://www.youtube.com/watch?v=o384NbCDB0U</a>
  
## Clean architecture
***I am still learing and understanding clean architecture so it might be perfectly correct***<br>
In Clean Architecture, instead of relying on Models, you'll communicate with Interactors from the Use Case layer. This layer contains the user interface related code, powered by Android Jetpack!
The outer circle represents the concrete mechanisms that are specific to the platform such as networking and database access. Moving inward, each circle is more abstract and higher-level. The center circle is the most abstract and contains business logic, which doesn’t rely on the platform or the framework you’re using.<br>
<img src="https://miro.medium.com/max/772/1*wOmAHDN_zKZJns9YDjtrMw.jpeg" height=200 width=300/>
<br>
Refer here for more details and description: 
 - <a href="https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started">https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started</a>
 - <a href="https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011">https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011</a>
 - <a href="https://medium.com/swlh/clean-architecture-in-android-a-beginner-approach-be0ce00d806b">https://medium.com/swlh/clean-architecture-in-android-a-beginner-approach-be0ce00d806b</a>
 
## Want to Contribute ?

Awesome! If you want to contribute to this project, you're always welcome!
Have any questions, doubts or want to present your opinions, views? You're always welcome. You can mail me at <b>debanshudatta123@gmail.com</b> or make an issue.
Looking for contributors! Don't be shy. 😁 Feel free to open issues/pull requests to help me improve this project.

- When reporting a new Issue, make sure to attach Screenshots, Videos or GIFs of the problem you are reporting.
- When submitting a new PR, make sure tests are all green. Write new tests if necessary.

## Contributors

- [Debanshu Datta](https://github.com/Debanshu777)

## License
The Snapchat name, artwork, trademark are all property of Snap Inc. This project is provided for educational purposes only. It is not affiliated with and has not been approved by Snap Inc.
  
  
  
  
