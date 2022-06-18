package calculator

class StringAddCalculator {
    fun add(source: String?): Long {
        if (source.isNullOrEmpty()) {
            return 0
        }
        return source.split("[,:]".toRegex())
            .sumOf { it.toPositiveValue() }
    }
}

private fun String.toPositiveValue(): Long {
    val convertedNumber = this.toLong()
    if (convertedNumber < 0) throw RuntimeException()
    return convertedNumber
}
