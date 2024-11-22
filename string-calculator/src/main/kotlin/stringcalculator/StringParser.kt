package stringcalculator

object StringParser {
    private const val DEFAULT_DELIMITER = ",|:"

    fun String.splitToInt(delimiter: String = DEFAULT_DELIMITER): List<Int> {
        return this.split(delimiter.toRegex()).map { it.toIntOrThrow() }
    }

    private fun String.toIntOrThrow(): Int =
        runCatching {
            this.toInt()
        }.getOrElse { throw IllegalArgumentException("[StringParser] 값을 Int로 변환하는데 실패했습니다. | '$this'") }
}
