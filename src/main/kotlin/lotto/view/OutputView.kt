package lotto.view

import lotto.constants.Messages
import lotto.domain.LottoResults
import lotto.domain.LottoTickets
import lotto.domain.Prize

/**
 * 출력을 위한 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object OutputView {
    fun printTicket(lottoTickets: LottoTickets, manualCount: Int) {
        println(Messages.BUY_AMOUNT_LOTTO.format(manualCount, lottoTickets.getSize() - manualCount))
        lottoTickets.tickets.forEach { ticket ->
            println(ticket.numbers.map { it.value }.toString())
        }
    }

    fun printLottoResult(lottoResults: LottoResults) {
        println(Messages.LOTTO_RESULT)

        enumValues<Prize>().map { prize ->
            val count = lottoResults.getPrizeCount(prize)
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
