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

        enumValues<Prize>().map { prize ->
            val count = lottoResults.find { it.prize == prize }?.count ?: NOT_HAVE_TICKET_COUNT
            when (prize) {
                Prize.LOSER -> return@map
                Prize.SECOND -> printSecondPrize(count)
                else -> printPrize(prize, count)
            }
        }
    }

    private fun printSecondPrize(count: Int) {
        println(
            Messages.CORRECT_OUTPUT_FOR_SECOND.format(count)
        )
    }

    private fun printPrize(prize: Prize, count: Int) {
        println(
            Messages.CORRECT_OUTPUT.format(
                prize.matchCount,
                prize.reward,
                count
            )
        )
    }

    fun printYield(yields: Double) {
        println(Messages.PRINT_YIELD.format(yields))
    }
}
