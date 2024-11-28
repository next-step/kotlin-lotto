package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Result

class ConsoleOutputView : OutputView {
    override fun printLottoQuantity(quantity: Int) {
        println("$quantity 개를 구매했습니다.")
    }

    override fun printLottoNumbers(lottos: Lottos) {
        lottos.lottos.forEach {
            println(it.sortedNumbers.joinToString(", ", "[", "]"))
        }
    }

    override fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")

        lottoResult.ranks
            .filter { it.key != Result.MISS }
            .toSortedMap(compareBy(Result::count))
            .forEach { (result, count) ->
                println("${result.count}개 일치 ${if (result.needBonus) ", 보너스 볼 일치" else ""} (${result.prize}원) - ${count}개")
            }
        println("총 수익률은 ${lottoResult.incomeRateValue}입니다.")
    }
}
