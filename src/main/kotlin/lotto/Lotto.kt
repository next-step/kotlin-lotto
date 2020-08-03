package lotto

import lotto.LottoUtils.luckyNumbers

data class Lotto(
    private var numbers: List<Int>,
    private var match: Int = 0
) {

    fun hasLuckyNumber(luckyNumbers: List<Int>): Int {
        luckyNumbers.forEach { if (numbers.contains(it)) match++ }
        return match
    }

    fun findResult(): Result = Result.findResult(hasLuckyNumber(luckyNumbers))

    override fun toString(): String {
        return "$numbers"
    }
}
