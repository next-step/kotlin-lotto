package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos

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

        println("3개 일치 (5000원)- ${lottoResult.fifth}개")
        println("4개 일치 (50000원)- ${lottoResult.fourth}개")
        println("5개 일치 (1500000원) - ${lottoResult.third}개")
        println("5개 일치, 보너스 볼 일치 (30000000원)- ${lottoResult.second}개")
        println("6개 일치 (2000000000원)- ${lottoResult.first}개")
        println("총 수익률은 ${lottoResult.incomeRateValue}입니다.")
    }
}
