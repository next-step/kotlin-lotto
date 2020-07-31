package calculator

class StringAddCalculator(text: String?) {
    private var numList = listOf(0)
    private var result: MatchResult? = null

    init {
        if (text.isNullOrBlank()) {
            numList = listOf(0)
        } else {
            result = Regex("//(.)\n(.*)").find(text)
            makeNumList(text)
            checkMinus()
        }
    }

    fun plus(): Int {
        return numList.sum()
    }

    private fun makeNumList(text: String) {
        result?.let {
            val custom = it.groupValues[1]
            numList = toIntList(it.groupValues[2].split(",", ":", custom).map { it.trim() })
        } ?: {
            numList = toIntList(text.split(",", ":").map { it.trim() })
        } ()
    }

    private fun toIntList(list: List<String>): List<Int> {
        try {
            return list.map { it.toInt() }
        } catch (e: Exception) {
            throw RuntimeException("숫자 이외의 값이 있습니다.")
        }
    }

    private fun checkMinus() {
        numList.forEach { isMinus(it) }
    }

    private fun isMinus(int: Int) {
        if (int < 0) {
            throw RuntimeException("음수값은 계산 할수없습니다.")
        }
    }
}
