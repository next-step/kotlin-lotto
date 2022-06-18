package calculator

class StringAddCalculator {
    fun add(source: String?): Long {
        if (source.isNullOrEmpty()) {
            return 0
        }
        return source.split("[,:]".toRegex())
            .sumOf { it.toLong() }
    }
}