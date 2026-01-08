package com.hwasfy.pocsdk.ui

import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ExportObjCClass
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalObjCName

//@OptIn(ExperimentalForeignApi::class)
//fun WeatherViewController() = ComposeUIViewController { WeatherScreen() }

//object WeatherSDKFactory {
//    fun makeViewController(): UIViewController {
//        return ComposeUIViewController {
//            MaterialTheme {
//                WeatherScreen()
//            }
//        }
//    }
//}


@OptIn(ExperimentalObjCName::class, BetaInteropApi::class)
@ExportObjCClass
@ObjCName("POCWeatherViewController", exact = true)
class WeatherViewControllerFactory {

    @OptIn(ExperimentalForeignApi::class)
    fun create(): UIViewController {
        return ComposeUIViewController {
            WeatherScreen()
        }
    }
}

