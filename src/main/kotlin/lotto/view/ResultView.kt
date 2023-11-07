package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatResult

object ResultView {
    fun showPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.count()}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }

    fun showLottoStatResult(lottoStatResult: LottoStatResult) {
        val returnRate = lottoStatResult.getReturnRate()

        println("\n당첨 통계\n---------")
        println("3개 일치 (${LottoStatResult.FIFTH_PLACE_REWARD}원)- ${lottoStatResult.fifthCount}개")
        println("4개 일치 (${LottoStatResult.FOURTH_PLACE_REWARD}원)- ${lottoStatResult.fourthCount}개")
        println("5개 일치 (${LottoStatResult.THIRD_PLACE_REWARD}원)- ${lottoStatResult.thirdCount}개")
        println("6개 일치 (${LottoStatResult.FIRST_PLACE_REWARD}원)- ${lottoStatResult.firstCount}개")
        println("총 수익률은 ${returnRate}입니다.${if (returnRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }
}
