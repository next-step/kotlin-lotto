package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.LottoPurchase
import com.nextstep.second.lotto.domain.LottoReward
import com.nextstep.second.lotto.service.LottoService
import com.nextstep.second.lotto.view.InputView
import com.nextstep.second.lotto.view.OutputView

fun main() {
    val money = InputView.getMoney()
    val manualLottoCnt = InputView.getManualLottoCount()
    val lottoPurchase = LottoPurchase.of(money, manualLottoCnt)

    val manualLottos = InputView.getManualLottoNumber(manualLottoCnt)
    val buyLottos = LottoService.buyLotto(lottoPurchase, manualLottos)
    OutputView.showBuyLotto(buyLottos)

    val winnerNumber = InputView.getWinnerNumber()
    val bonusNumber = InputView.getBonusNumber()
    val winnerLotto = LottoService.getWinnerLotto(winnerNumber, bonusNumber)

    val lottoResult = LottoService.checkThisWeekLottoResult(winnerLotto, buyLottos)

    OutputView.showLottoResult(money, lottoResult, LottoReward.getRewardsForCelebrate())
}
