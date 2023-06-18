package lotto.view

import lotto.domain.Lottos
import lotto.domain.LottosResult

object LottoOutputView {
    fun printLottos(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.values.forEach { lotto ->
            println(lotto.numbers.values.joinToString(", "))
        }
    }

    fun printLottoResults(lottosResult: LottosResult) {
        println("당첨 통계")
        println("---------")
        lottosResult.winningResults.forEach { (lottoRank, matchCount) ->
            println("${lottoRank.matchCount}개 일치 (${lottoRank.winningMoney})- ${matchCount}개")
        }
        println("수익률은 ${lottosResult.returnOfRate}입니다.")
    }
}
