package camp.nextstep.edu.step.step2.view

import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import camp.nextstep.edu.step.step2.domain.result.LottoResult

class OutputView {

    fun displayTicketsNumbers(ticketsAmount: Int, ticketNumbers: List<List<Int>>) {
        println("${ticketsAmount}개를 구매했습니다.")

        for (ticketNumber in ticketNumbers) {
            println(ticketNumber)
        }
    }

    fun displayLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoMatch.values().reversed().forEach {
            val count = lottoResult.getResultCount(it)
            println("${it.matchCount}개 일치 (${it.prize}원) - ${count}개")
        }
        println("총 수익률은 ${lottoResult.calculateProfitRate()}입니다.")
    }

}
