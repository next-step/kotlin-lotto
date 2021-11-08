package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoStatisticFormat

/**
 * 로또 관련된 결과를 알려주는 클래스
 * */
class OutputView {
    fun resultLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printWinNumbers(lottos: List<Lotto>) {
        lottos
            .forEach { lottoNumber ->
                println("[${lottoNumber.numbers.map { it.number }.joinToString()}]")
            }
        println("")
    }

    fun printWinStatistic(result: LottoStatisticFormat) {
        println("당첨 통계")
        println("---------")
        printRankingList(result)
        println("총 수익률은 ${result.profit}입니다. ")
    }

    private fun printRankingList(result: LottoStatisticFormat) {
        LottoRank
            .getRankListByMoneyExceptValue(LottoRank.MISS)
            .forEach { rank ->
                when (rank) {
                    LottoRank.SECOND -> println("${rank.countOfMatch}개 일치, 보너스 볼 일치 (${rank.winningMoney}${rank.moneyUnion})- ${result.winList[rank] ?: 0}개")
                    else -> println("${rank.countOfMatch}개 일치 (${rank.winningMoney}${rank.moneyUnion})- ${result.winList[rank] ?: 0}개")
                }
            }
    }
}
