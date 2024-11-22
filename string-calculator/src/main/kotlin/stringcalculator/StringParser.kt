package stringcalculator

object StringParser {
    const val 공백 = ""
    const val 줄바꿈 = "\\n"

    fun String.toCalculateRequest(): StringCalculateRequest {
        val payload = this.split(줄바꿈).last()
        return StringCalculateRequest(delimiter = Delimiter(this), payload = payload)
    }

    fun String.splitToInts(delimiter: Delimiter): List<Int> {
        return this.split(delimiter.regex)
            .asSequence()
            .filter { it.isNotBlank() }
            .map { it.toIntOrThrow() }
            .toList()
    }

    fun String.splitWithDefault(
        delimiter: String,
        default: String = 공백,
    ): List<String> = this.split(delimiter)
        .takeIf { it.size >= 2 }
        ?: listOf(default, this)

    private fun String.toIntOrThrow(): Int =
        runCatching {
            this.toInt().takeIf { it >= 0 } ?: throw RuntimeException("[StringParser] 음수는 허용되지 않습니다. | input: '$this'")
        }.getOrElse { throw RuntimeException("[StringParser] 값을 Int로 변환하는데 실패했습니다. | input: '$this'") }
}
