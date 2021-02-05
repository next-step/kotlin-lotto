package com.nextstep.lotto

import com.nextstep.lotto.domain.LottoFactory
import com.nextstep.lotto.domain.LottoResult
import com.nextstep.lotto.domain.Money
import com.nextstep.lotto.view.LottoInputView
import com.nextstep.lotto.view.LottoOutputView

fun main() {
    val money = Money(LottoInputView.inputPrice())
    val numberOfManualLotto = LottoInputView.inputNumberOfManualLotto()
    LottoFactory.checkBuy(money, numberOfManualLotto)
    val manualLottoNumbers = LottoInputView.inputManualLottoNumbers(numberOfManualLotto)
    LottoFactory.buyManualLotto(money, manualLottoNumbers)
    val lottos = LottoFactory.buyAutoLotto(money)
    LottoOutputView.showBuyResult(lottos)

    val winningNumbers = LottoInputView.inputWinningNumbers()
    val bonusNumber = LottoInputView.inputBonusNumber()
    val winningLotto = LottoFactory.drawWinningLotto(winningNumbers, bonusNumber)

    val lottoResult = LottoResult(lottos, winningLotto)

    LottoOutputView.showLottoResult(lottoResult)
}
