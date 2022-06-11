package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber

interface InputView {

    fun printPaymentPriceInputMessage()

    fun printCustomLottoCountInputMessage()

    fun printCustomLottoInputMessage()

    fun printWinningNumbersInputMessage()

    fun printBonusNumberInputMessage()

    fun inputPaymentPrice(): Int

    fun inputCustomLottoCount(): Int

    fun inputCustomLotto(): Lotto

    fun inputWinningNumbers(): List<LottoNumber>

    fun inputBonusNumber(): Int
}
