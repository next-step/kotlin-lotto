package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoPurchase
import lotto.domain.LottoStatistics
import lotto.uI.InputView
import lotto.uI.OutputView

class LottoController {

    fun purchase(money: Long): List<Lotto> {
        val lottoCount = LottoPurchase(price = money).getLottoCount()

        val lottoList: List<Lotto> =
            (1..lottoCount).map {
                Lotto(LottoGenerator.generateLottoNumbers())
            }

        OutputView.outputLottoList(lottoList)
        return lottoList
    }

    fun showStatistic(money: Long, lottoList: List<Lotto>) {
        val lastWeekLotto = InputView.inputLastWeekLottoNumbers()

        val lottoStatistics = LottoStatistics(lastWeekLotto)

        val lottoMatchList = lottoStatistics.getWinningStatistics(lottoList)
        OutputView.outputLottoStatistics(lottoMatchList)

        val profit = lottoStatistics.getProfit(money, lottoMatchList)
        val isProfitable = lottoStatistics.isProfitable(profit)
        OutputView.outputLottoProfit(profit, !isProfitable)
    }
}
