package specific.study

import specific.study.Delimiter.Companion.tokenize

object StringAddCalculator {
    fun calculate(input: String?): Int {
        if(input.isNullOrBlank()) {
            return 0
        }
        val numbers: List<Int> = input.parse()
        require(numbers.all { it >= 0 }) { "negative numbers cannot be calculated" }
        return numbers.sum()
    }

    private fun String.parse(): List<Int> =
        tokenize()
            .map { it.toIntOrThrow { "cannot convert '${it}' to Int type" } }
}

private fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
    require(!isNullOrBlank()) { lazyMessage }
    return this.toIntOrNull()
        ?: throw IllegalArgumentException(lazyMessage().toString())
}
