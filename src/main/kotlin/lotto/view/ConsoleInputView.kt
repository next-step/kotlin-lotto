package lotto.view

import lotto.model.LottoNumber

object ConsoleInputView : InputView {

    private const val WINNING_NUMBER_DELIMITER = ","

    override fun printPaymentPriceInputMessage() = println("구매금액을 입력해 주세요.")

    override fun printWinningNumbersInputMessage() = println("지난 주 당첨 번호를 입력해 주세요.")

    override fun printBonusNumberInputMessage() = println("보너스 볼을 입력해 주세요.")

    override fun inputPaymentPrice() = readln().toInt()

    override fun inputWinningNumbers() =
        readln().split(WINNING_NUMBER_DELIMITER)
            .map { LottoNumber.valueOf(it.trim().toInt()) }

    override fun inputBonusNumber() = readln().toInt()
}
