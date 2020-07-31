package calculator

class StringAddCalculator(private val text: String? = "") {
    private val numberList = makeNumberList()

    init {
        checkMinus()
    }

    fun plus(): Int {
        return numberList.sum()
    }

    private fun makeNumberList(): List<Int> {
        return if (text.isNullOrBlank()) {
            listOf(0)
        } else {
            val stringNumberList = text.split(",", ":").map { it.trim() }
            toIntList(stringNumberList)
        }
    }

    private fun toIntList(stringList: List<String>): List<Int> {
        try {
            return stringList.map { it.toInt() }
        } catch (e: Exception) {
            throw RuntimeException("숫자가 아닌 값은 계산할수없습니다.")
        }
    }

    private fun checkMinus() {
        numberList.forEach { isMinus(it) }
    }

    private fun isMinus(int: Int) {
        if (int < 0) {
            throw RuntimeException("음수가 입력되었습니다.")
        }
    }
}
