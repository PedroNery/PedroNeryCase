@file:Suppress("unused")

import org.gradle.api.JavaVersion

object Config {
    val javaVersion = JavaVersion.VERSION_1_8

    const val sdk_tools_linux = "4333796"
    const val minSdk = 26
    const val compileSdk = 31
    const val targetSdk = 31
    const val applicationId = "com.projeto.pedronerycase"
    const val versionCode = 1
    const val versionName = "1.0"

    const val genericRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val packageToRunner = "br.com.brmalls.customer."
    const val orchestrator = "ANDROIDX_TEST_ORCHESTRATOR"
}

object Versions {
    // Tools
    const val kotlin = "1.5.30"
    const val android_gradle_plugin = "7.0.0"

    // Others
    const val ktx = "1.7.0"
    const val retrofit = "2.9.0"
    const val retrofit_coroutines_adapter = "0.9.2"
    const val okhttp_logging_interceptor = "4.2.2"
    const val support = "1.3.1"
    const val material = "1.4.0"
    const val recyclerview = "1.0.0"
    const val constraint_layout = "2.1.1"
    const val fragment_androidx = "1.3.6"
    const val lifecycle = "2.4.0"
    const val coroutines = "1.5.2"
    const val rxJavaVersion = "2.2.17"
    const val rxAndroidVersion = "2.1.1"
    const val koin = "2.2.3"
    const val hawk = "2.0.1"
    const val glide = "4.9.0"
    const val navigation = "2.3.5"
    const val startup = "1.1.0"
    const val timber = "5.0.1"

    // Tests
    const val lifecycle_testing = "2.1.0"
    const val androidTestVersion = "1.4.0"
    const val androidxJunit = "1.1.3"
    const val androidxTruth = "1.4.0"
    const val espresso = "3.4.0"
    const val espressoIntents = "3.4.0"
    const val espressoIdling = "3.4.0"
    const val coroutinesTest = "1.5.1"
    const val jUnit = "4.12"
    const val orchestrator = "1.1.1"
    const val mockk = "1.12.0"
    const val mockwebserver = "4.2.2"
    const val roboelectric = "4.5.1"
    const val testRunner = "1.2.0"

    // Compose
    const val compose = "1.1.0-beta03"
    const val composePreview = "1.1.0-alpha04"
    const val composeActivity = "1.3.0"
    const val composeCoil = "1.3.1"
    const val composeAccompanist = "0.16.0"
    const val constraintLayoutCompose = "1.0.0-beta02"
}

object Deps {
    // Tools Dependencies
    const val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val tools_android_gradle = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val tools_navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    //Others Dependencies
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlin_ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit_coroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_coroutines_adapter}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_logging_interceptor}"
    const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"
    const val support_app_compat = "androidx.appcompat:appcompat:${Versions.support}"
    const val support_material = "com.google.android.material:material:${Versions.material}"
    const val support_recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val support_constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxJava2Android = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koin}"
    const val koin_core = "io.insert-koin:koin-core:${Versions.koin}"
    const val koin_viewmodel = "io.insert-koin:koin-android-viewmodel:${Versions.koin}"
    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_annotation = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val fragment_androidx = "androidx.fragment:fragment-ktx:${Versions.fragment_androidx}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Debug Dependencies
    const val fragment_androidx_testing = "androidx.fragment:fragment-testing:${Versions.fragment_androidx}"

    // Test Dependencies
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.lifecycle_testing}"
    const val androidTest = "androidx.test:core:${Versions.androidTestVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockk_android = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockkAgentJVM = "io.mockk:mockk-agent-jvm:${Versions.mockk}"
    const val junit = "junit:junit:${Versions.jUnit}"
    const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockwebserver}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
    const val robolectric_annotation = "org.robolectric:annotations:${Versions.roboelectric}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val koin_test = "io.insert-koin:koin-test:${Versions.koin}"
    const val androidxJunit = "androidx.test.ext:truth:${Versions.androidxTruth}"
    const val androidxTruth = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val espressoIdling = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdling}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val orchestrator = "androidx.test:orchestrator:${Versions.orchestrator}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"

    // Compose
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeCoil = "io.coil-kt:coil-compose:${Versions.composeCoil}"
    const val composeKoin = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    const val composeAccompanistPlaceholder = "com.google.accompanist:accompanist-placeholder-material:${Versions.composeAccompanist}"
    const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:${Versions.composeAccompanist}"
    const val accompanistPagerIndicator  = "com.google.accompanist:accompanist-pager-indicators:${Versions.composeAccompanist}"
    const val accompanistSwipeRefresh  = "com.google.accompanist:accompanist-swiperefresh:${Versions.composeAccompanist}"
}

object Repo {
    const val jitpack = "https://jitpack.io"
    const val sonatype = "https://oss.sonatype.org/content/repositories/snapshots"
    const val fabric = "https://maven.fabric.io/public"
    const val mktcloud = "https://salesforce-marketingcloud.github.io/MarketingCloudSDK-Android/repository"
    const val gradle = "https://plugins.gradle.org/m2/"
}

object LocalLibs {
    const val common = ":common"
    const val navigation = ":navigation"
    const val app = ":app"
    const val movieList = ":movielist"
    const val movieDetail = ":moviedetail"
    const val test = ":test"
}