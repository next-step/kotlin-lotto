package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoBall
import lotto.domain.LottoStore
import lotto.domain.ProfitCalculator
import lotto.domain.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoStore = LottoStore(RandomLottoGenerator())

    val money = InputView.askLottoBuyMoney()
    val lottos = lottoStore.buy(money)
    OutputView.printLottos(lottos)
    val winningLotto = Lotto.of(
        InputView.askWinningLottoBall().map {
            it.trim().toInt()
        }
    )

    val bonusBall = LottoBall(InputView.askBonusBall())
    if (winningLotto.containsBall(bonusBall)) {
        throw IllegalArgumentException("보너스볼은 이미 추첨된 번호가 될 수 없습니다.")
    }
    val rewards = lottos.matchNumbers(winningLotto, bonusBall)
    val profit = ProfitCalculator().calculateProfit(rewards, money)
    OutputView.printRewards(rewards, profit)
}
