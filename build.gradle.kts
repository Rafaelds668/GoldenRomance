// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}
buildscript{
    repositories{
        google()
        jcenter()
    }

    dependencies{
        classpath("com.android.tools.build:gradle:3.5.4")
        classpath("com.google.gms:google-services:4.2.0")
    }
}

