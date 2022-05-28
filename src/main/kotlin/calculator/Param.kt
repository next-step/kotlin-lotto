package calculator

class Param(text: String) {
    val value: Int

    constructor(intValue: Int) : this(intValue.toString())

    init {
        if (text.matches(PARAM_NOT_MATCH_VALIDATOR)) {
            throw RuntimeException("숫자가 아닌 입력은 들어올 수 없습니다. (음수도 안됩니다!)")
        }
        value = if (text.isBlank()) {
            0
        } else {
            text.toInt()
        }
    }

    fun operation(that: Param, operation: (Int, Int) -> Int): Param {
        return Param(operation(value, that.value))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Param

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        private val PARAM_NOT_MATCH_VALIDATOR = ".*[^\\d^\\s]+.*".toRegex()
        val EMPTY_PARAM = Param(0)
    }
}
