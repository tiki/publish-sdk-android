/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.tiki_sdk_android.tiki_platform_channel.req

import com.squareup.moshi.JsonClass

/**
 * The request for the `build` method call in the Platform Channel.
 *
 * It requires an *publishingId]* and an *origin]*. If no *address* is provided the SDK
 * will create a new one
 *

 * @property publishingId
 * @property origin
 * @property address
 * @constructor Create empty Req build
 */
@JsonClass(generateAdapter = true)
data class ReqBuild(
    val publishingId: String,
    val origin: String,
    val address: String? = null
)
