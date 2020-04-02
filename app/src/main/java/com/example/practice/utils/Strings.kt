package com.example.practice.utils

import java.util.regex.Pattern

const val EMAIL_REGEX = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
const val NUMBER_REGEX ="[0-9+-.]+"

val String.isValidEmailAddress
get() = isValidString(EMAIL_REGEX)


val String.isValidNumber
get() = isValidString(NUMBER_REGEX)


fun String.isValidString(mPattern : String) = Pattern.compile(mPattern, Pattern.CASE_INSENSITIVE).let { it.matcher(this) }.run { matches() }




