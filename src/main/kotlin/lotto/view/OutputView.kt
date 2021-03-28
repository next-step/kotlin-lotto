package lotto.view

import lotto.model.LottoResult
import lotto.model.LottoTickets

object OutputView {
    fun printTickets(tickets: LottoTickets) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.lottoNumbers.joinToString(separator = ", ", prefix = "[", postfix = "]"))
        }
    }

    fun printResult(result: LottoResult) {
        println("당첨 통계")
        result.winningCounter.forEach { (lottoPlace, count) ->
            println("${lottoPlace.count}개 일치${if (lottoPlace.bonusExist) ", 보너스 볼 일치" else ""} (${lottoPlace.price.amount}원)- ${count}개")
        }
        println("총 수익률은 ${result.benefitRate}입니다.")
    }
}
