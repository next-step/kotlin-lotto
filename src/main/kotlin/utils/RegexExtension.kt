package utils

fun String.findByPattern(): MatchResult? = Regex("//(.)\n(.*)").find(this)
