package com.codewave.gymmanagement.appdata

data class MemberInfo(
    var name: String,
)

fun getAllMember(): List<MemberInfo> {
    return listOf(
        MemberInfo("Anahi"),
        MemberInfo("Cris"),
        MemberInfo("Dari"),
        MemberInfo("David")
    )
}