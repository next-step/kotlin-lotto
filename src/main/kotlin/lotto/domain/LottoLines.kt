package lotto.domain

const val FIRST_PRICE = 2_000_000_000
const val SECOND_PRICE = 1_500_000
const val THIRD_PRICE = 50_000
const val FOURTH_PRICE = 5_000

class LottoLines(private val totalNumber: Int) {
    private val lottoLines = createLottoTicket(totalNumber)

    fun checkResult(result: List<Int>): ResultData {
        val first = getFirst(result)
        val second = getSecond(result)
        val third = getThird(result)
        val fourth = getFourth(result)
        val price = (first * FIRST_PRICE) + (second * SECOND_PRICE) + (third * THIRD_PRICE) + (fourth * FOURTH_PRICE)
        return ResultData(first, second, third, fourth, price)
    }

    fun getLines(): List<LottoSingleLine> {
        return lottoLines
    }

    private fun createLottoTicket(totalNumber: Int): List<LottoSingleLine> {
        return (1..totalNumber).toList().map { LottoSingleLine() }
    }

    private fun getFirst(result: List<Int>): Int {
        return lottoLines.filter { it.matching(result) == 6 }.size
    }

    private fun getSecond(result: List<Int>): Int {
        return lottoLines.filter { it.matching(result) == 5 }.size
    }

    private fun getThird(result: List<Int>): Int {
        return lottoLines.filter { it.matching(result) == 4 }.size
    }

    private fun getFourth(result: List<Int>): Int {
        return lottoLines.filter { it.matching(result) == 3 }.size
    }
}
