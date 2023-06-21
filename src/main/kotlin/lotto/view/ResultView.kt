package lotto.view

import lotto.domain.Lotto
import lotto.domain.Winner

class ResultView {

    fun showLottoCount(lottos: List<Lotto>) {
        return println("${lottos.size}개를 구매했습니다.")
    }
    fun showLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.lottoNumbers)
        }
    }

    fun showStatisticsResult(resultMap: Map<Winner, Int>) {
        resultMap.forEach {
            println("${it.key.matchCount}개 일치 (${it.key.reward}원) - ${it.value}")
        }
    }

    fun showWinRating(rating: Double) {
        println("총 수익률은 ${rating}입니다.")
    }
}
