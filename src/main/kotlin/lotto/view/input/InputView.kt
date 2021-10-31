package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoPurchaseCount

interface InputView {
    fun getPurchaseAmount(): LottoPurchaseAmount
    fun getManualPurchaseCount(): LottoPurchaseCount
    fun getWinningNumbers(): LottoNumberPackage
    fun getBonusNumber(winningNumbers: LottoNumberPackage): LottoNumber
}
