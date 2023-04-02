package com.mytiki.tiki_sdk_android.core.rsp

import com.mytiki.tiki_sdk_android.LicenseRecord
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RspLicense(
    val license: LicenseRecord?
)