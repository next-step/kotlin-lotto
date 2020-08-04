package lotto.view

import lotto.domain.Lotto

object ResultView {
    fun viewLottos(amount: Int, lottoList: List<Lotto>) {
        println("${amount}개를 구매했습니다")
        lottoList.forEach { lotto -> println(lotto.numbers.map { it.number }) }
    }

    fun viewResult(ranks: Map<String, Int>, rateOfReturn: Double) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${ranks["5등"]}개")
        println("4개 일치 (50000원)- ${ranks["4등"]}개")
        println("5개 일치 (1500000원)- ${ranks["3등"]}개")
        println("5개 일치, 보너스 볼 일치(30000000원)- ${ranks["2등"]}개")
        println("6개 일치 (2000000000원)- ${ranks["1등"]}개")
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
