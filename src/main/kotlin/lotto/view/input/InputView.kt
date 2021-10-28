package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseAmount

interface InputView {
    fun getPurchaseAmount(): LottoPurchaseAmount
    fun getWinningNumbers(): LottoNumberPackage
    fun getBonusNumber(winningNumbers: LottoNumberPackage): LottoNumber
}
