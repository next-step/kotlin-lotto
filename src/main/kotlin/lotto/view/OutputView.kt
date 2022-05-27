package lotto.view

import lotto.constants.Messages
import lotto.model.LottoResult
import lotto.model.LottoTicket
import lotto.model.Prize

/**
 * 출력을 위한 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object OutputView {
    private const val NOT_HAVE_TICKET_COUNT = 0

    fun printTicket(tickets: List<LottoTicket>) {
        println("${tickets.size}${Messages.BUY_AMOUNT_LOTTO}")
        tickets.forEach {
            println(it.numbers.toString())
        }
    }

    fun printLottoResult(lottoResults: List<LottoResult>) {
        println(Messages.LOTTO_RESULT)
        println(
            Messages.CORRECT_THREE.format(
                lottoResults.find { it.prize == Prize.FOURTH_PLACE }?.count ?: NOT_HAVE_TICKET_COUNT
            )
        )
        println(
            Messages.CORRECT_FOUR.format(
                lottoResults.find { it.prize == Prize.THIRD_PLACE }?.count ?: NOT_HAVE_TICKET_COUNT
            )
        )
        println(
            Messages.CORRECT_FIVE.format(
                lottoResults.find { it.prize == Prize.SECOND_PLACE }?.count ?: NOT_HAVE_TICKET_COUNT
            )
        )
        println(
            Messages.CORRECT_SIX.format(
                lottoResults.find { it.prize == Prize.FIRST_PLACE }?.count ?: NOT_HAVE_TICKET_COUNT
            )
        )
    }

    fun printYield(yields: Double) {
        println(Messages.PRINT_YIELD.format(yields))
    }
}
