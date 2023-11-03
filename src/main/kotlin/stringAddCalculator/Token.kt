package stringAddCalculator

@JvmInline
value class Token(
    val tokens: List<String>
) {
    init {
        tokens.forEach {
            require(it.toInt() > 0) { throw RuntimeException() }
        }
    }

    fun toInt(): Int {
        return tokens.first().toInt()
    }

    fun sumOf(): Int {
        return tokens.sumOf { it.toInt() }
    }
}
