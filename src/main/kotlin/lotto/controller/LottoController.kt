package lotto.controller

import lotto.domain.LottoCustomGenerator
import lotto.domain.LottoList
import lotto.domain.LottoListGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoPurchase
import lotto.domain.WinningLotto
import lotto.domain.WinningLottoStatistics
import lotto.uI.InputView
import lotto.uI.OutputView

class LottoController {

    fun purchase(money: Long, manualLottoCount: Long): LottoList {
        val autoLottoCount = LottoPurchase(price = money, manualLottoCount = manualLottoCount).getAutoLottoCount()

        val manualLottoList = InputView.inputManualLottoList(manualLottoCount)

        val autoLottoList = LottoListGenerator.generateLottoList(autoLottoCount, LottoCustomGenerator)

        val lottoList = manualLottoList.addLottoList(autoLottoList)

        OutputView.outputLottoList(
            manualLottoCount = manualLottoCount,
            autoLottoCount = autoLottoCount,
            lottoList = lottoList
        )
        return lottoList
    }

    fun showStatistic(money: Long, lottoList: LottoList) {
        val lastWeekLottoNumber = InputView.inputLastWeekLottoNumbers()

        val lastWeekWinningLotto = LottoCustomGenerator.generateLotto(lastWeekLottoNumber)

        val bonusLottoNumber = LottoNumber(InputView.inputBonusLottoNumber())

        val winningLotto = WinningLotto(lastWeekWinningLotto, bonusLottoNumber)
        val winningLottoStatistics = WinningLottoStatistics(winningLotto)

        val lottoMatchList = winningLottoStatistics.getWinningStatistics(lottoList)
        OutputView.outputLottoStatistics(lottoMatchList)

        val profit = winningLottoStatistics.getProfit(money, lottoMatchList)
        val isProfitable = winningLottoStatistics.isProfitable(profit)
        OutputView.outputLottoProfit(profit, !isProfitable)
    }
}
