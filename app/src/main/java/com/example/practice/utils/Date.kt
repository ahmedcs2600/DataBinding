package com.example.practice.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
const val DATE_FORMAT = "yyyy-MM-dd"
const val TIME_FORMAT = "HH:mm:ss"
const val DATE_FORMAT2 = "MMM dd yyyy"


const val UTC_TIME_ZONE = "UTC"

val getCurrentTimeStamp : String
get() = SimpleDateFormat(DATE_TIME_FORMAT, Locale.US).run { format(Timestamp(Date().time)) }

val Date.toCalendar : Calendar
get() = Calendar.getInstance().also { it.time = this }

val String.stringToDate : Date
get() = SimpleDateFormat(DATE_FORMAT).let { it.parse(this) }


fun String.getLocalTimeDate() : String = SimpleDateFormat(DATE_TIME_FORMAT).let {
    it.timeZone = TimeZone.getTimeZone(UTC_TIME_ZONE)
    it.parse(this)
}.let {
    SimpleDateFormat(DATE_TIME_FORMAT).run {
        timeZone = TimeZone.getDefault()
        format(this)
    }
}
fun String.getFormatedDate(mCurrentFormat: String, desiredFormat: String) : String =
    SimpleDateFormat(mCurrentFormat).run { parse(this@getFormatedDate) }.run {
        SimpleDateFormat(desiredFormat).run { format(this) }
}


