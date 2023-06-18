package lotto.view

import lotto.domain.Lottos
import lotto.domain.LottosResult
import lotto.domain.Rank

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
            println("${Rank.FIFTH.matchCount}개 일치 (${Rank.FIFTH.winningMoney})- ${lottosResult.winningResults[Rank.FIFTH]}개")
            println("${Rank.FOURTH.matchCount}개 일치 (${Rank.FOURTH.winningMoney}원)- ${lottosResult.winningResults[Rank.FOURTH]}개")
            println("${Rank.THIRD.matchCount}개 일치 (${Rank.THIRD.winningMoney}원)- ${lottosResult.winningResults[Rank.THIRD]}개")
            println("${Rank.FIRST.matchCount}개 일치 (${Rank.FIRST.winningMoney}원)- ${lottosResult.winningResults[Rank.FIRST]}개")
            println("수익률은 ${returnOfRate}입니다.")
        }
    }
}
