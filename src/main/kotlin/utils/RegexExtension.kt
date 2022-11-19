package utils

fun String.findPattern(): MatchResult? = Regex("//(.)\n(.*)").find(this)
