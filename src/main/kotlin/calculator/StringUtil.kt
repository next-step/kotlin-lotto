package calculator

fun String.toPositiveLong(): Long {
    val parsedNumber = requireNotNull(this.toLongOrNull()) { "Invalid number format: $this" }
    require(parsedNumber >= 0) { "Negative numbers not allowed: $parsedNumber" }
    return parsedNumber
}
