package lotto.view

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_TOTAL_COUNT

const val WINNER_NUMBER_DELIMITER = ","

object InputView {
    fun getAmountOfMoney(): Int {
        println("구입금액을 입력해 주세요.")

        return readLine()!!.toInt()
    }

    fun getWinnerLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winner = readLine().toString().split(WINNER_NUMBER_DELIMITER)

        require(winner.size == LOTTO_NUMBER_TOTAL_COUNT) { "당첨 번호는 ${LOTTO_NUMBER_TOTAL_COUNT}개 입니다." }

        return winner.map { it.toInt() }
    }
}
