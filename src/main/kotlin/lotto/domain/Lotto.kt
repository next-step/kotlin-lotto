package lotto.domain

import lotto.LottoUtils.luckyNumbers

data class Lotto(
    private val numbers: List<Int>
) {

    fun hasLuckyNumbers(luckyNumbers: List<Int>): Int {
        return luckyNumbers.filter { numbers.contains(it) }.size
    }

    fun getResult(): Result = Result.getResult(hasLuckyNumbers(luckyNumbers))

    override fun toString(): String {
        return "$numbers"
    }
}
