package lotto

import lotto.domain.LottoMatch
import lotto.domain.LottoPrize
import lotto.domain.LottoShop
import lotto.domain.entity.generator.LottoGenerator
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

object Play {

    fun start() {

        val userLottoBuyMoney = userLottoBuy()

        val userLottoList = userLottoInput(userLottoBuyMoney)

        val winningLotto = winningLottoInput()

        val totalPrizeMoney = lottoPrize(userLottoList, winningLotto)

        lottoResult(totalPrizeMoney, userLottoBuyMoney)
    }

    private fun userLottoBuy(): Int = InputView.inputLottoBuyPrice()

    private fun userLottoInput(userLottoBuyMoney: Int): List<Lotto> {

        val userLottoList = LottoShop.createLottoTicket(userLottoBuyMoney)

        ResultView.lottoPurchasesCount(userLottoList.size)

        ResultView.printUserLotto(userLottoList)

        return userLottoList
    }

    private fun winningLottoInput(): WinningLotto = WinningLotto(LottoGenerator.generatorWinningLotto(InputView.lastWeekLottoNumber()))

    private fun lottoPrize(userLottoList: List<Lotto>, winningLotto: WinningLotto): Int {

        val lottoPrize = LottoPrize(LottoMatch.match(userLottoList, winningLotto))

        ResultView.lottoResult(lottoPrize.allPrize())

        return lottoPrize.totalPrizeMoney()
    }

    private fun lottoResult(totalPrizeMoney: Int, userLottoBuyMoney: Int) =
        ResultView.statistics(totalPrizeMoney, userLottoBuyMoney)
}
