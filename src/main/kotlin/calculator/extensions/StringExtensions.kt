package calculator.extensions

fun String.isNumeric(): Boolean {
    return toDoubleOrNull() != null
}

fun String.split(list: List<String>): List<String> {
    return split(delimiters = list.toTypedArray())
}
