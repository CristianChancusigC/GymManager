package com.codewave.gymmanagement.appdata

data class SubscriptionsInfo(
    var typeSub: String
)

fun getAllTypeSubs(): List<SubscriptionsInfo>{
    return listOf(
        SubscriptionsInfo("Monthly"),
        SubscriptionsInfo("Year")
    )
}