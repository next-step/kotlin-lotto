package com.nextstep.lotto

import com.nextstep.lotto.domain.LottoFactory
import com.nextstep.lotto.domain.LottoResult
import com.nextstep.lotto.domain.Lottos
import com.nextstep.lotto.domain.Money
import com.nextstep.lotto.domain.WinningLotto
import com.nextstep.lotto.view.LottoInputView
import com.nextstep.lotto.view.LottoOutputView

fun main() {
    val money = Money(LottoInputView.inputPrice())
    val lottos = drawLottos(money)
    LottoOutputView.showBuyResult(lottos)

    val winningLotto = drawWinningLotto()

    val lottoResult = LottoResult(lottos, winningLotto)

    LottoOutputView.showLottoResult(lottoResult)
}

private fun drawLottos(money: Money): Lottos {
    val numberOfManualLotto = LottoInputView.inputNumberOfManualLotto()
    LottoFactory.checkBuy(money, numberOfManualLotto)
    val manualLottoNumbers = LottoInputView.inputManualLottoNumbers(numberOfManualLotto)
    val manualLottos = LottoFactory.buyManualLotto(money, manualLottoNumbers)
    val autoLottos = LottoFactory.buyAutoLotto(money)
    return Lottos(manualLottos, autoLottos)
}

private fun drawWinningLotto(): WinningLotto {
    val winningNumbers = LottoInputView.inputWinningNumbers()
    val bonusNumber = LottoInputView.inputBonusNumber()
    val winningLotto = LottoFactory.drawWinningLotto(winningNumbers, bonusNumber)
    return winningLotto
}
