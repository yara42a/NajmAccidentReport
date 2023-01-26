package com.example.finalproject

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportModel(
    val firstName: String? = null,
    val firstPhoneNum: String? = null,
    val firstCarNum: String? = null,
    val Check1: String? = null,
    val Secondtname: String? = null,
    val SecondPNum: String? = null,
    val SecondCarNum: String? = null,
    val Check2: String? = null
) : Parcelable