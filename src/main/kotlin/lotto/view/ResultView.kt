package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import lotto.domain.LottoStore
import java.math.BigDecimal

class ResultView {

    fun viewPurchaseLotto(lottos: LottoStore) {
        println("수동으로 ${lottos.getManualLottoSize()} 장, 자동으로 ${lottos.getAutoLottoSize()}개를 구매했습니다.")
        lottos.getAllLottos().toList().forEach {
            println(it.convertLottoNumberToInt())
        }
    }

    fun viewLottoResults(lottoResult: LottoResults, totalBenefit: BigDecimal) {
        println("당첨 통계")
        println("--------")
        lottoResult.getResults().forEach {
            val (lottoPrize, count) = it.prizeAndCountPair()
            println("${lottoPrize.matchingNumberCount}개 일치 ${if (lottoPrize == LottoPrize.SECOND) ", 보너스 볼 일치(${lottoPrize.prize})" else "(${lottoPrize.prize})"} - ${count}개")
        }
        println(
            "총 수익률은 ${totalBenefit}입니다.${if (totalBenefit < 1.toBigDecimal()) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "(이득임)"}"
        )
    }
}
