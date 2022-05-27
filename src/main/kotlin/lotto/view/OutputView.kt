package lotto.view

import lotto.constants.Messages
import lotto.model.LottoResult
import lotto.model.LottoTicket

/**
 * 출력을 위한 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object OutputView {
    fun printTicket(tickets: List<LottoTicket>) {
        println("${tickets.size}${Messages.BUY_AMOUNT_LOTTO}")
        tickets.forEach {
            println(it.numbers.toString())
        }
    }

    fun printLottoResult(lottoResults: List<LottoResult>) {
        println(Messages.LOTTO_RESULT)
        lottoResults.forEach {
            it.prizeMessage?.let { message ->
                println(message)
            }
        }
    }

    fun printYield(yields: Double) {
        println(Messages.PRINT_YIELD.format(yields))
    }
}
