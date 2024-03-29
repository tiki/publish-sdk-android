/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.tiki_sdk_android.trail

enum class TagCommon(val value: String) {
    EMAIL_ADDRESS("email_address"),
    PHONE_NUMBER("phone_number"),
    PHYSICAL_ADDRESS("physical_address"),
    CONTACT_INFO("contact_info"),
    HEALTH("health"),
    FITNESS("fitness"),
    PAYMENT_INFO("payment_info"),
    CREDIT_INFO("credit_info"),
    FINANCIAL_INFO("financial_info"),
    PRECISE_LOCATION("precise_location"),
    COARSE_LOCATION("coarse_location"),
    SENSITIVE_INFO("sensitive_info"),
    CONTACTS("contacts"),
    MESSAGES("messages"),
    PHOTO_VIDEO("photo_video"),
    AUDIO("audio"),
    GAMEPLAY_CONTENT("gameplay_content"),
    CUSTOMER_SUPPORT("customer_support"),
    USER_CONTENT("user_content"),
    BROWSING_HISTORY("browsing_history"),
    SEARCH_HISTORY("search_history"),
    USER_ID("user_id"),
    DEVICE_ID("device_id"),
    PURCHASE_HISTORY("purchase_history"),
    PRODUCT_INTERACTION("product_interaction"),
    ADVERTISING_DATA("advertising_data"),
    USAGE_DATA("usage_data"),
    CRASH_DATA("crash_data"),
    PERFORMANCE_DATA("performance_data"),
    DIAGNOSTIC_DATA("diagnostic_data");

    companion object {
        fun from(value: String): TagCommon? {
            for (type in TagCommon.values()) {
                if (type.value == value) return type
            }
            return null
        }
    }
}