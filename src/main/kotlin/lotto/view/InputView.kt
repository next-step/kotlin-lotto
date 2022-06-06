package lotto.view

import lotto.model.LottoNumber

interface InputView {

    fun printPaymentPriceInputMessage()

    fun printWinningNumbersInputMessage()

    fun printBonusNumberInputMessage()

    fun inputPaymentPrice(): Int

    fun inputWinningNumbers(): List<LottoNumber>

    fun inputBonusNumber(): Int
}
