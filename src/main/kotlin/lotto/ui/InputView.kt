package lotto.ui

import lotto.domain.LottoNumber

object InputView {

    private const val INPUT_MATCHING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    private const val DELIMITER = ","

    fun readMatchingNumber(): List<LottoNumber> {
        println(INPUT_MATCHING_NUMBER_MESSAGE)
        return readln().split(DELIMITER).map { LottoNumber(it.trim().toInt()) }
    }

    fun readPrice(): Int {
        println(INPUT_PRICE_MESSAGE)
        return readln().toInt()
    }
}
