package stringcalculator.domain

class Token {
    var value: Int = 0
        private set
    private constructor(value: Int) {
        if (isNegativeNumber(value)) {
            throw RuntimeException("음수는 토큰이 될 수 없습니다.")
        }
        this.value = value
    }

    private fun isNegativeNumber(number: Int): Boolean = number < 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Token

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        private const val MINIMUM_CACHE_NUMBER = 0
        private const val MAXIMUM_CACHE_NUMBER = 100
        private val cache: MutableMap<Int, Token> = hashMapOf()

        fun from(stringValue: String): Token {
            return Token(stringValue.toIntOrThrowsRuntimeException())
        }

        init {
            (MINIMUM_CACHE_NUMBER..MAXIMUM_CACHE_NUMBER).forEach {
                cache[it] = from(it.toString())
            }
        }
    }
}
