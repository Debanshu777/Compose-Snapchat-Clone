<h1 align="center">
Snapchat Compose Clone👻
<br>
<br>
**Facing with the camaraX for API 30 and above, looking into this issue**
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

#### General Dependencies

* <a href="https://developer.android.com/jetpack/compose"> ***Compose-version: 1.4.0-beta02*** </a> <br>Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
* ***Gradle Version: 7.5***
* ***Kotlin Version: 1.8.10***

#### Navigation🚀

* <a href="https://developer.android.com/jetpack/compose/navigation"> ***androidx.navigation:navigation-compose:2.5.3*** </a> <br>The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component’s infrastructure and features.
*
Reference <a href="https://blog.mindorks.com/jetpack-compose-navigation">https://blog.mindorks.com/jetpack-compose-navigation</a>

#### Camara📸

camerax_version = "1.2.1"

* <a href="https://developer.android.com/jetpack/androidx/releases/camera"> ***androidx.camera:camera-coreandroidx.camera:camera-camera2, androidx.camera:camera-lifecycle,  androidx.camera:camera-view, androidx.camera:camera-lifecycle, androidx.camera:camera-video, androidx.camera:camera-extensions*** </a>
* Reference
  - <a href="https://proandroiddev.com/compose-camerax-on-android-58578f37e6df"/>https://proandroiddev.com/compose-camerax-on-android-58578f37e6df</a>
  - <a href="https://www.youtube.com/watch?v=gRMznojSHxE&t=321s"/>https://www.youtube.com/watch?v=gRMznojSHxE&t=321s</a>

#### Google Map🗺

* ***com.google.maps.android:maps-compose:2.1.0, com.google.android.gms:play-services-maps:18.1.0***
* References
  - <a href="https://medium.com/geekculture/google-maps-in-jetpack-compose-android-ae7b1ad84e9"/>https://medium.com/geekculture/google-maps-in-jetpack-compose-android-ae7b1ad84e9</a>
  - <a href="https://johnoreilly.dev/posts/jetpack-compose-google-maps/"> https://johnoreilly.dev/posts/jetpack-compose-google-maps/ </a>
  - <a href="https://www.youtube.com/watch?v=2tu-hNbyViU"/>https://www.youtube.com/watch?v=2tu-hNbyViU</a>

#### Video Player with Media 3📽

* <a href="https://developer.android.com/jetpack/androidx/releases/media3"> ***androidx.media3:media3-exoplayer:1.0.0-rc01, androidx.media3:media3-ui:1.0.0-rc01*** </a> <br>We have several existing media APIs: Jetpack Media also known as MediaCompat, Jetpack Media2, and ExoPlayer. These libraries were developed with different goals, and have several areas of overlapping functionality.

It can be challenging to decide which library to use for a given use case, and objects from
different libraries are often not compatible, requiring adapters or connecting code. Media3 removes
these challenges by providing a single set of libraries which work well together.

* References
  - <a href="https://medium.com/backyard-programmers/media3-exoplayer-in-jetpack-compose-to-make-snapchat-spotlight-75e384e2ef56"/>https://medium.com/backyard-programmers/media3-exoplayer-in-jetpack-compose-to-make-snapchat-spotlight-75e384e2ef56</a>

#### Coil🍥

* <a href="https://github.com/coil-kt/coil">io.coil-kt:coil-compose:2.2.2</a> <br> Image loading for
  Android backed by Kotlin Coroutines.
* References
  - <a href="https://proandroiddev.com/loading-images-for-jetpack-compose-using-glide-coil-and-fresco-1211261a296e"/>https://proandroiddev.com/loading-images-for-jetpack-compose-using-glide-coil-and-fresco-1211261a296e</a>
  - <a href="https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217"/>https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217</a>

#### Accompanist✨

* <a href="https://github.com/google/accompanist/">com.google.accompanist:accompanist-permissions:
  0.23.1 , com.google.accompanist:accompanist-pager:0.25.1</a><br>Accompanist is a group of
  libraries that aim to supplement Jetpack Compose with features that are commonly required by
  developers but not yet available.
* References
  - <a href="https://google.github.io/accompanist/">https://google.github.io/accompanist/</a>
  - <a href="https://medium.com/surfstudio/accompanist-the-first-chord-a-jetpack-compose-library-reviewed-9e007771db70">https://medium.com/surfstudio/accompanist-the-first-chord-a-jetpack-compose-library-reviewed-9e007771db70</a>

#### Dokka and KDoc🚀

* <a href="https://github.com/Kotlin/dokka">org.jetbrains.dokka:dokka-gradle-plugin:1.7.10</a><br>
  Dokka is a documentation engine for Kotlin, performing the same function as javadoc for Java. Just
  like Kotlin itself, Dokka fully supports mixed-language Java/Kotlin projects. It understands
  standard Javadoc comments in Java files and KDoc comments in Kotlin files, and can generate
  documentation in multiple formats including standard Javadoc, HTML and Markdown.
* References
  - <a href="https://medium.com/androiddevnotes/how-to-use-dokka-documentation-engine-for-android-gradle-to-generate-kdoc-or-javadoc-comments-2b5f177595ec">https://medium.com/androiddevnotes/how-to-use-dokka-documentation-engine-for-android-gradle-to-generate-kdoc-or-javadoc-comments-2b5f177595ec</a>
  - <a href="https://www.youtube.com/watch?v=GesMbOt5hIo">https://www.youtube.com/watch?v=GesMbOt5hIo</a>
#### Detekt🐱‍🏍

* <a href="https://github.com/detekt/detekt">io.gitlab.arturbosch.detekt:detekt-gradle-plugin:
  1.18.1</a><br>Static code analysis for Kotlin
* References
  - <a href="https://www.youtube.com/watch?v=o384NbCDB0U">https://www.youtube.com/watch?v=o384NbCDB0U</a>

## Clean architecture

***I am still learning and understanding clean architecture so it might be perfectly correct***<br>
In Clean Architecture, instead of relying on Models, you'll communicate with Interactors from the
Use Case layer. This layer contains the user interface related code, powered by Android Jetpack!
The outer circle represents the concrete mechanisms that are specific to the platform such as
networking and database access. Moving inward, each circle is more abstract and higher-level. The
center circle is the most abstract and contains business logic, which doesn’t rely on the platform
or the framework you’re using.<br>
<img src="https://miro.medium.com/max/772/1*wOmAHDN_zKZJns9YDjtrMw.jpeg" height=200 width=300/>
<br>
Refer here for more details and description:

- <a href="https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started">https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started</a>
- <a href="https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011">https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011</a>
- <a href="https://medium.com/swlh/clean-architecture-in-android-a-beginner-approach-be0ce00d806b">https://medium.com/swlh/clean-architecture-in-android-a-beginner-approach-be0ce00d806b</a>

## Want to Contribute ?

Awesome! If you want to contribute to this project, you're always welcome!
Have any questions, doubts or want to present your opinions, views? You're always welcome. You can
mail me at <b>debanshudatta123@gmail.com</b> or make an issue.
Looking for contributors! Don't be shy. 😁 Feel free to open issues/pull requests to help me improve
this project.

- When reporting a new Issue, make sure to attach Screenshots, Videos or GIFs of the problem you are
  reporting.
- When submitting a new PR, make sure tests are all green. Write new tests if necessary.

## Contributors

- [Debanshu Datta](https://github.com/Debanshu777)

## License
The Snapchat name, artwork, trademark are all property of Snap Inc. This project is provided for educational purposes only. It is not affiliated with and has not been approved by Snap Inc.
