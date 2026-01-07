import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("com.android.kotlin.multiplatform.library")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
    `maven-publish`
}

kotlin {
    androidLibrary {
        namespace = "com.hwasfy.pocsdk"
        compileSdk = libs.versions.android.compileSdk.get().toInt()

        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    val isAppleSilicon = System.getProperty("os.arch") == "aarch64"


    listOf(
        iosArm64(),
        if (isAppleSilicon) iosSimulatorArm64() else iosX64()  // simulator depending on host
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "POC"
            isStatic = true
            freeCompilerArgs += listOf("-Xbinary=bundleId=com.hassanwasfy.POC")
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-okhttp:2.3.7")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation("io.ktor:ktor-client-core:2.3.7")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.7")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

afterEvaluate {
    publishing {
        repositories {
            mavenLocal()
        }
        publications {
            withType<MavenPublication>().configureEach {
                groupId = "com.hwasfy"
                artifactId = "poc-sdk"
                version = "0.2.0"
            }
        }
    }
}

tasks.register<Exec>("assembleXCFramework") {
    group = "build"
    description = "Assemble XCFramework for CocoaPods"

    dependsOn(
        "linkReleaseFrameworkIosArm64",
        if (System.getProperty("os.arch") == "aarch64") "linkReleaseFrameworkIosSimulatorArm64" else "linkReleaseFrameworkIosX64"
    )

    commandLine(
        "xcodebuild",
        "-create-xcframework",
        "-framework",
        "build/bin/iosArm64/releaseFramework/POC.framework",
        "-framework",
        if (System.getProperty("os.arch") == "aarch64") "build/bin/iosSimulatorArm64/releaseFramework/POC.framework" else "build/bin/iosX64/releaseFramework/POC.framework",
        "-output",
        "build/POC.xcframework"
    )
}


