package lotto.view

import lotto.domain.Lottos
import lotto.domain.LottosResult
import lotto.domain.LottoRank

object LottoOutputView {
    fun printLottos(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.values.forEach { lotto ->
            println(lotto.numbers.joinToString(", "))
        }
    }

    fun printLottoResults(lottosResult: LottosResult) {
        println("당첨 통계")
        with(lottosResult) {
            println("${LottoRank.FIFTH.matchCount}개 일치 (${LottoRank.FIFTH.winningMoney})- ${lottosResult.winningResults[LottoRank.FIFTH]}개")
            println("${LottoRank.FOURTH.matchCount}개 일치 (${LottoRank.FOURTH.winningMoney}원)- ${lottosResult.winningResults[LottoRank.FOURTH]}개")
            println("${LottoRank.THIRD.matchCount}개 일치 (${LottoRank.THIRD.winningMoney}원)- ${lottosResult.winningResults[LottoRank.THIRD]}개")
            println("${LottoRank.FIRST.matchCount}개 일치 (${LottoRank.FIRST.winningMoney}원)- ${lottosResult.winningResults[LottoRank.FIRST]}개")
            println("수익률은 ${returnOfRate}입니다.")
        }
    }
}
