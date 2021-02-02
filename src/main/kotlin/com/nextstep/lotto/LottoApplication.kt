package com.nextstep.lotto

import com.nextstep.lotto.domain.LottoFactory
import com.nextstep.lotto.domain.LottoResult
import com.nextstep.lotto.domain.WinningLotto
import com.nextstep.lotto.view.LottoInputView
import com.nextstep.lotto.view.LottoOutputView

fun main() {
    val price = LottoInputView.inputPrice()
    val lottos = LottoFactory.buyLotto(price)
    LottoOutputView.showBuyResult(lottos)

    val winningNumbers = LottoInputView.inputWinningNumbers()
    val winningLotto = WinningLotto.generate(winningNumbers)

    val lottoResult = LottoResult(lottos, winningLotto)

    LottoOutputView.showLottoResult(lottoResult)
}
