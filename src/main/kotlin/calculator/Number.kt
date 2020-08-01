package calculator

fun parse(string: String, delimiter: String) = string.split(delimiter)

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

class Number(val number: String) {

    companion object {
        val NUMERIC_REGEX = Regex("[0-9]")
    }

    fun isNatural(): Boolean {
        if (NUMERIC_REGEX.matches(number)) {
            return true
        }
        return false
    }
}
