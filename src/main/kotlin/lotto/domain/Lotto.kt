package lotto.domain

import lotto.LottoUtils.luckyNumbers

data class Lotto(
    private var numbers: List<Int>,
    private var matchSuccess: Int = 0
) {

    fun hasLuckyNumber(luckyNumbers: List<Int>): Int {
        luckyNumbers.forEach { if (numbers.contains(it)) matchSuccess++ }
        return matchSuccess
    }

    fun getResult(): Result = Result.getResult(hasLuckyNumber(luckyNumbers))

    override fun toString(): String {
        return "$numbers"
    }
}
