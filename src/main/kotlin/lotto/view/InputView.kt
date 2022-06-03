package lotto.view

import lotto.model.LottoNumber

object InputView {

    private const val WINNING_NUMBER_DELIMITER = ","

    fun printPaymentPriceInputMessage() = println("구매금액을 입력해 주세요.")

    fun printWinningNumbersInputMessage() = println("지난 주 당첨 번호를 입력해 주세요.")

    fun inputPaymentPrice() = readln().toInt()

    fun inputWinningNumbers() =
        readln().split(WINNING_NUMBER_DELIMITER)
            .map { LottoNumber.valueOf(it.trim().toInt()) }
}
