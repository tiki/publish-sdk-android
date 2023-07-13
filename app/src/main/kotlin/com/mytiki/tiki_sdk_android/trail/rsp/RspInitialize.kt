/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.tiki_sdk_android.trail.rsp

import android.util.Log
import com.mytiki.tiki_sdk_android.channel.rsp.Rsp

data class RspInitialize(
    val id: String?,
    val address: String?,
    override val requestId: String?,
) : Rsp {
    companion object {
        fun from(map: Map<String, Any?>): RspInitialize {
            Log.d("TIKI", "RSP IS: $map")
            return RspInitialize(
                map["id"] as String?,
                map["address"] as String?,
                map["requestId"] as String?
            )
        }
    }
}