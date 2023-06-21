package lotto.view

import lotto.domain.Lotto
import lotto.domain.Winner

class ResultView {

    fun showLottoCount(lottos: List<Lotto>) {
        return println("${lottos.size}개를 구매했습니다.")
    }
    fun showLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.lottoNumbers.numbers)
        }
    }

    fun showStatisticsResult(resultMap: Map<Winner, Int>) {
        resultMap.forEach {
            showContainsBonusResult(it)
        }
    }

    private fun showContainsBonusResult(data: Map.Entry<Winner, Int>) {
        if (data.key == Winner.SECOND_PLACE_WITH_BONUS && data.value > 0) {
            println("${data.key.matchCount}개 일치 보너스 볼 일치(${data.key.reward}원) - ${data.value}")
        } else println("${data.key.matchCount}개 일치 (${data.key.reward}원) - ${data.value}")
    }

    fun showWinRating(rating: Double) {
        println("총 수익률은 ${rating}입니다.")
    }
}
