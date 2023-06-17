package calculator

fun String.isInt(): Boolean {
    val intRegex = "^-?\\d+\$"
    return matches(Regex(intRegex))
}
