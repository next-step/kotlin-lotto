package lotto.view

import lotto.domain.LottoShop
import lotto.domain.LottoStatistic

fun main() {
    val money = LottoInputController.inputMoney()
    val lottos = LottoShop.sellByMoney(money)
    LottoOutputController.printLottos(lottos)

    val winningNumbers = LottoInputController.inputWinningLottoNumbers()
    val lottoStatistic = LottoStatistic(winningNumbers = winningNumbers, lottos = lottos)
    LottoOutputController.printLottoStatistic(lottoStatistic)
}
