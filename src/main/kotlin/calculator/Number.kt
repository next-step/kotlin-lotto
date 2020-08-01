fun customDelimeter(string: String): String? {
    val matchResult = Regex("//(.*)\n").find(string)
    if (matchResult != null && matchResult.groupValues[1].isNotBlank()) {
        return matchResult.groupValues[1]
    }
    return null
}

fun hasCustomDelimeter(string: String): Boolean {
    if (customDelimeter(string).isNullOrBlank()) {
        return false
    }
    return true
}
