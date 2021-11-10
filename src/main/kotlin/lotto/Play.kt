package lotto

import lotto.domain.LottoPrize
import lotto.domain.LottoShop
import lotto.domain.lotto.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

object Play {

    fun play() {

        val userLottoBuyMoney = InputView.inputLottoBuyPrice()

        val userLottoList = LottoShop.createLottoTicket(userLottoBuyMoney)

        InputView.lottoPurchasesCount(userLottoList.size)

        ResultView.printUserLotto(userLottoList)

        val winningLotto = WinningLotto(InputView.lastWeekLottoNumber())

        val lottoWin = LottoPrize(userLottoList, winningLotto)

        ResultView.lottoResult(lottoWin.prizeResult)

        val sum = lottoWin.totalPrizeMoney()
        ResultView.statistics(sum, userLottoBuyMoney)
    }
}
