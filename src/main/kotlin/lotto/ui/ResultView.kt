package lotto.ui

import lotto.vo.AutoLotto
import lotto.vo.LottoMachine
import lotto.vo.LottoNumber
import lotto.vo.Lottos
import lotto.vo.ManualLotto
import lotto.vo.WinningLotto
import lotto.winningpoint.WinningRank
import lotto.winningpoint.WinningStatistics

object ResultView {

    fun promptForBuyCount(manualLottoCount: Long, price: Long): Long {
        val autoLottoCount = LottoMachine(price).calculateAutoLottoCount(manualLottoCount)
        val autoLottoBuyPrice = LottoMachine(price).calculateAutoLottoBuyPrice(manualLottoCount)
        println("수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}개를 구매했습니다.")
        return autoLottoBuyPrice
    }

    fun promptForManualLotto(manualLottos: List<ManualLotto>) {
        manualLottos.forEach { manualLotto ->
            println(manualLotto.numbers)
        }
    }

    fun promptForAutoLotto(autoLottoBuyPrice: Long): AutoLotto {
        val autoLotto = AutoLotto(autoLottoBuyPrice)
        autoLotto.lottos.forEach { lotto ->
            println(lotto.numbers)
        }
        return autoLotto
    }

    fun printWinningPoints(autoLotto: AutoLotto, winningLotto: WinningLotto) {
        val statistics = WinningStatistics.calculateStatistics(autoLotto, winningLotto)

        println("당첨 통계")
        println("---------")
        WinningRank.values().forEach { rank ->
            if (WinningRank.isWinningRank(rank)) {
                println("${rank.matchingCount}개 일치 (${rank.winningPrice}원) - ${statistics.getValue(rank)}개")
            }
        }
        val totalWinningPrice = winningLotto.calculateTotalWinningPrice(lottos = autoLotto.lottos)
        println("총 수익률은 ${autoLotto.getProfitRate(totalWinningPrice)}입니다.")
    }
}
