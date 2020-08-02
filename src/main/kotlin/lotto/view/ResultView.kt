package lotto.view

import lotto.domain.SixNumbers

class ResultView() {
    fun viewSixNumbers(amount: Int, lottoList: List<SixNumbers>) {
        println("${amount}개를 구매했습니다")
        lottoList.forEach { sixNumbers -> println(sixNumbers.list.map { it.number }) }
    }

    fun viewResult(result: List<Double>) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${result[0].toInt()}개")
        println("4개 일치 (50000원)- ${result[1].toInt()}개")
        println("5개 일치 (1500000원)- ${result[2].toInt()}개")
        println("6개 일치 (2000000000원)- ${result[3].toInt()}개")
        println("총 수익률은 ${result[4]}입니다.")
    }
}