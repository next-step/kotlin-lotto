package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoPurchase
import lotto.domain.LottoStatistics
import lotto.uI.InputView
import lotto.uI.OutputView

class LottoController {

    fun purchase(money: Long): LottoList {
        val lottoCount = LottoPurchase(price = money).getLottoCount()

        val lottoList = LottoGenerator.generateLottoList(lottoCount, LottoNumberGenerator)

        OutputView.outputLottoList(lottoList)
        return LottoList(lottoList)
    }

    fun showStatistic(money: Long, lottoList: LottoList) {
        val lastWeekLottoNumber = InputView.inputLastWeekLottoNumbers()

        val lastWeekLotto = LottoGenerator.generateLotto(lastWeekLottoNumber)

        val bonusLottoNumber = LottoNumber(InputView.inputBonusLottoNumber())

        val lottoStatistics = LottoStatistics(lastWeekLotto, bonusLottoNumber)

        val lottoMatchList = lottoStatistics.getWinningStatistics(lottoList)
        OutputView.outputLottoStatistics(lottoMatchList)

        val profit = lottoStatistics.getProfit(money, lottoMatchList)
        val isProfitable = lottoStatistics.isProfitable(profit)
        OutputView.outputLottoProfit(profit, !isProfitable)
    }
}
