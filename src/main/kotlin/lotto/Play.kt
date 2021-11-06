package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

object Play {

    fun play() {

        val userLottoBuyMoney = InputView.inputLottoBuyPrice()

        val userLottoList = LottoShop.createLottoTicket(userLottoBuyMoney)

        InputView.lottoPurchasesCount(userLottoList.size)

        ResultView.printUserLotto(userLottoList)

        val winningLotto = WinningLotto(InputView.lastWeekLottoNumber())

        val lottoResult = LottoResult(userLottoList, winningLotto)

        ResultView.lottoResult(lottoResult.allPrizeResult())

        val sum = lottoResult.totalPrizeMoney()
        ResultView.statistics(sum, userLottoBuyMoney)

    }

}