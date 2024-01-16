plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.goldenromance"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.goldenromance"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation ("fileTree(dir: 'libs', include: ['*.jar'])")
    implementation ("'androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test:runner:1.3.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")


    implementation ("com.onesignal:OneSignal:3.10.1")


    implementation ("com.google.firebase:firebase-auth:17.0.0")
    implementation ("com.google.firebase:firebase-storage:17.0.0")
    implementation ("com.google.firebase:firebase-messaging:19.0.0")

    implementation ("com.github.bumptech.glide:glide:3.7.0")
    implementation ("com.lorentzos.swipecards:library:1.0.9")
    implementation ("com.google.firebase:firebase-core:17.0.0")
    implementation ("com.google.android.material:material:1.1.0-alpha03")
    implementation ("com.google.firebase:firebase-database:18.0.0")
    //navigation
    implementation ("com.github.ittianyu:BottomNavigationViewEx:1.2.4")

    //Circle ImageView
    implementation ("de.hdodenhof:circleimageview:2.2.0")
    implementation ("com.github.dimorinny:show-case-card-view:0.0.1")

    implementation ("com.github.BakerJQ:Android-InfiniteCards:1.0.5")
    implementation ("com.google.firebase:firebase-ads:19.7.0")

//    implementation 'com.google.android.gms:play-services-ads:19.7.0'
//
//    implementation 'com.google.android.gms:play-services-basement:17.6.0'
}
