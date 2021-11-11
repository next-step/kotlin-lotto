package lotto

import lotto.domain.LottoPrize
import lotto.domain.LottoShop
import lotto.domain.lotto.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val userLottoBuyMoney = InputView.inputLottoBuyPrice()

    val userLottoList = LottoShop.createLottoTicket(userLottoBuyMoney)

    ResultView.lottoPurchasesCount(userLottoList.size)

    ResultView.printUserLotto(userLottoList)

    val winningLotto = WinningLotto(InputView.lastWeekLottoNumber())

    val lottoResult = LottoPrize(userLottoList, winningLotto)

    ResultView.lottoResult(lottoResult.prizeResult)

    val sum = lottoResult.totalPrizeMoney()

    ResultView.statistics(sum, userLottoBuyMoney)
}
