package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoBall
import lotto.domain.LottoStore
import lotto.domain.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoStore = LottoStore(RandomLottoGenerator())

    val money = InputView.askLottoBuyMoney()
    val lottos = lottoStore.buy(money)
    OutputView.printLottos(lottos)
    val winningLotto = Lotto(InputView.askWinningLottoBall().map {
        LottoBall(it.trim().toInt())
    })
    val rewards = lottos.matchNumbers(winningLotto)
    OutputView.printRewards(rewards, money)
}
