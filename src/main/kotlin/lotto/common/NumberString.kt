package lotto.common

class NumberString(
    private val string: String
) {
    init {
        require(string.isNotBlank()) { "값이 비어있습니다." }
        require(isNumber()) { "숫자가 아닙니다. (입력값:$string)" }
    }

    private fun isNumber(): Boolean {
        return string.toCharArray().all { it in '0'..'9' }
    }

    fun toIntegerNumber(): Int {
        return string.toInt()
    }
}
