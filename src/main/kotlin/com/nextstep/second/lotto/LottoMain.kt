package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.LottoReward
import com.nextstep.second.lotto.service.LottoService
import com.nextstep.second.lotto.view.InputView
import com.nextstep.second.lotto.view.OutputView

fun main() {
    val inputMoney = InputView.getMoney()
    val buyLottos = LottoService.buyLottoInRandom(inputMoney)
    OutputView.showBuyLotto(buyLottos)

    val winnerNumber = InputView.getWinnerNumber()
    val bonusNumber = InputView.getBonusNumber()
    val winnerLotto = LottoService.getWinnerLotto(winnerNumber, bonusNumber)

    val lottoResult = LottoService.checkThisWeekLottoResult(winnerLotto, buyLottos)

    OutputView.showLottoResult(inputMoney, lottoResult, LottoReward.getRewardsForCelebrate())
}
