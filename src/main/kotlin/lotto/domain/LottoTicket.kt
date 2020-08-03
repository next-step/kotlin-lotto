package lotto.domain

const val FIRST_PRICE = 2000000000
const val SECOND_PRICE = 1500000
const val THIRD_PRICE = 50000
const val FOURTH_PRICE = 5000

class LottoTicket(private val totalNumber: Int) {
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
        val list = mutableListOf<LottoSingleLine>()
        for (count in 1..totalNumber) {
            list.add(LottoSingleLine())
        }
        return list
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
