package com.mytiki.tiki_sdk_android

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.mytiki.tiki_sdk_flutter_plugin.TikiSdkDestination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp

const val API_KEY: String = "a49fe762-124e-4ced-9b88-9814d64c131b"
const val ORIGIN: String = "com.mytiki..tiki_sdk_android.test"

@RunWith(AndroidJUnit4::class)
class TikiSdkTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
    @Test
    fun init_tiki_sdk() {
        getInstrumentation().runOnMainSync {
            val context = getInstrumentation().targetContext
            val tikiSdk = TikiSdk(ORIGIN, API_KEY, context)
            Assert.assertNotNull(tikiSdk)
        }
    }
//
//    @Test
//    fun assign_onwership() {
//        lateinit var tikiSdk: TikiSdk;
//        getInstrumentation().runOnMainSync {
//            val context = getInstrumentation().targetContext
//            tikiSdk = TikiSdk(ORIGIN, API_KEY, context)
//        }
//        runTest {
//            assertEquals(1,1)
//        }
//    }
//
//    @Test
//    fun give_consent() {
//        getInstrumentation().runOnMainSync {
//            val context = getInstrumentation().targetContext
//            val sdk = TikiSdk(context, apiKey)
//            sdk.assignOwnership("com.mytiki.test", "pool", listOf("email"))
//            sdk.modifyConsent("com.mytiki.test", TikiSdkDestination(listOf("*"), listOf("*")))
//            assertEquals(1, 1)
//        }
//    }
//
//    @Test
//    fun modify_consent() {
//        getInstrumentation().runOnMainSync {
//            val context = getInstrumentation().targetContext
//            val sdk = TikiSdk(context, apiKey)
//            sdk.assignOwnership("com.mytiki.test", "pool", listOf("email"))
//            sdk.modifyConsent("com.mytiki.test", TikiSdkDestination(listOf("*"), listOf("*")))
//            sdk.modifyConsent("com.mytiki.test", TikiSdkDestination(listOf(), listOf()))
//            assertEquals(1, 1)
//        }
//    }
//
//    @Test
//    fun apply_consent() {
//        getInstrumentation().runOnMainSync {
//            var ok = false
//            val context = getInstrumentation().targetContext
//            val sdk = TikiSdk(context, apiKey)
//            sdk.assignOwnership("com.mytiki.test", "pool", listOf("email"))
//            sdk.modifyConsent("com.mytiki.test", TikiSdkDestination(listOf("*"), listOf("*")))
//            sdk.applyConsent("com.mytiki.test", TikiSdkDestination(listOf("*"), listOf("*")),
//                "apply",
//                request = {
//                    ok = true
//                },
//                onBlock = {
//                    ok = false
//                })
//            Thread.sleep(1000)
//            assertEquals(true, ok)
//        }
//    }
}