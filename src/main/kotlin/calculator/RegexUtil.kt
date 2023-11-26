package calculator

fun isNumber(number: String): Boolean {
    return Regex("[0-9]+").matches(number)
}

fun findCustomDelimiter(text: String): String {
    return Regex("//(.)\n(.*)").find(text)?.groupValues?.get(1) ?: ""
}