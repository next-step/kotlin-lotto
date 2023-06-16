package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.LottoReward
import com.nextstep.second.lotto.service.LottoVendingMachine
import com.nextstep.second.lotto.view.InputView
import com.nextstep.second.lotto.view.OutputView

fun main() {
    val inputMoney = InputView.getMoney()
    val buyLottos = LottoVendingMachine.buyLottoInRandom(inputMoney)
    OutputView.showBuyLotto(buyLottos)

    val winnerNumber = InputView.getWinnerNumber()
    val winnerLotto = LottoVendingMachine.getWinnerLotto(winnerNumber)
    val lottoResult = LottoVendingMachine.checkThisWeekLottoResult(winnerLotto, buyLottos)

    OutputView.showLottoResult(inputMoney, lottoResult, LottoReward.getRewards())
}
