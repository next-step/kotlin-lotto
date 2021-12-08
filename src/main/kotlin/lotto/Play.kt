package lotto

import lotto.domain.LottoMatch
import lotto.domain.LottoPrize
import lotto.domain.LottoShop
import lotto.domain.entity.common.LottoNumber
import lotto.domain.generator.LottoGenerator
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.BonusNumber
import lotto.domain.entity.winning.WinningLotto
import lotto.filter.LottoFilter
import lotto.filter.LottoMoneyFilter
import lotto.view.InputView
import lotto.view.ResultView

object Play {

    fun start() {

        val userLottoBuyMoney = userLottoBuy()

        val userLottoList = userLottoInput(userLottoBuyMoney)

        val winningLotto = winningLottoInput()

        val bonusNumber = bonusNumberInput()

        val totalPrizeMoney = lottoPrize(userLottoList, winningLotto, bonusNumber)

        lottoResult(totalPrizeMoney, userLottoBuyMoney)
    }

    private fun userLottoBuy(): Int = InputView.lottoBuyPrice()

    private fun userLottoInput(userLottoBuyMoney: Int): List<Lotto> {

        val ticketingCount = LottoMoneyFilter.verify(userLottoBuyMoney)

        val lottoManualBuyCount = InputView.lottoManualBuyCount()

        val userLottoList = LottoShop.createLottoTicket(ticketingCount)

        ResultView.lottoPurchasesCount(0, userLottoList.size)

        ResultView.printUserLotto(userLottoList)

        return userLottoList
    }

    private fun winningLottoInput(): WinningLotto = WinningLotto(LottoGenerator.generatorWinningLotto(InputView.lastWeekLottoNumber()))

    private fun bonusNumberInput(): BonusNumber {

        val bonusNumber = LottoFilter.verify(InputView.lastWeekBonusNumber())

        return BonusNumber(LottoNumber(bonusNumber))
    }

    private fun lottoPrize(userLottoList: List<Lotto>, winningLotto: WinningLotto, bonusNumber: BonusNumber): Int {

        val lottoPrize = LottoPrize(LottoMatch.match(userLottoList, winningLotto, bonusNumber))

        ResultView.lottoResult(lottoPrize.getPrize)

        return lottoPrize.totalPrizeMoney()
    }

    private fun lottoResult(totalPrizeMoney: Int, userLottoBuyMoney: Int) =
        ResultView.statistics(totalPrizeMoney, userLottoBuyMoney)
}
