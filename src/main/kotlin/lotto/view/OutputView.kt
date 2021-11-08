package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoResult

class OutputView {

    fun printLottoList(lottoList: List<Lotto>) {
        val auto = lottoList.count { it.isAuto }
        val manual = lottoList.count { it.isManual }
        println("수동으로 ${manual}장, 자동으로 ${auto}개를 구매했습니다.")
        lottoList.forEach { lotto -> println(lotto.numbers) }
        println()
    }

    fun printLottoResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")

        LottoRank.values().forEach { rank ->
            val winners = result.winners(rank)
            val winnings = String.format("%,d", rank.winnings)
            println("${rank.match}개 일치 (${winnings}) - ${winners}개")
        }
        println("총 수익률은 ${result.rateOfReturn}입니다.")
    }
}
