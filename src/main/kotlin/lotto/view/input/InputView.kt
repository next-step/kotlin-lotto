package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseAmount
import lotto.domain.WinningInfo

interface InputView {
    fun getPurchaseAmount(): LottoPurchaseAmount
    fun getWinningNumbers(): WinningInfo
    fun getBonusNumber(winningNumbers: LottoNumberPackage): LottoNumber
}
