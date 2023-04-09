/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */
package com.mytiki.tiki_sdk_android.core.rsp

import com.mytiki.tiki_sdk_android.TitleRecord
import org.json.JSONObject

data class RspTitle(
    val title: TitleRecord?
) {
    companion object {
        fun fromJson(json: String): RspTitle {
            val jsonObject = JSONObject(json)
            val titleStr = jsonObject.getString("title")
            return RspTitle(TitleRecord.fromJson(titleStr))
        }
    }
}