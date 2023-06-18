package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoStatistic
import lotto.domain.Lottos

object LottoOutputController {
    fun printLottos(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.values.forEach { lotto ->
            println(lotto.numbers.joinToString(", "))
        }
    }

    fun printLottoStatistic(lottoStatistic: LottoStatistic) {
        println("당첨 통계")
        with(lottoStatistic) {
            println("${LottoPrize.FIFTH.matchCount}개 일치 (${LottoPrize.FIFTH.reward})- ${result.numberOfFifth}개")
            println("${LottoPrize.FOURTH.matchCount}개 일치 (${LottoPrize.FOURTH.reward}원)- ${result.numberOfFourth}개")
            println("${LottoPrize.THIRD.matchCount}개 일치 (${LottoPrize.THIRD.reward}원)- ${result.numberOfThird}개")
            println("${LottoPrize.FIRST.matchCount}개 일치 (${LottoPrize.FIRST.reward}원)- ${result.numberOfFirst}개")
            println("수익률은 ${returnOfRate}입니다.")
        }
    }
}
