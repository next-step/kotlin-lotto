package com.example.mylotto.view

import com.example.mylotto.model.LottoResult
import com.example.mylotto.model.LottoTicket

class ResultView {
    fun displayPurchasedTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println(ticket.numbers.joinToString(prefix = "[", postfix = "]") { it.number.toString() })
        }
    }

    fun displayWinningStatistics(result: LottoResult) {
        result.rankCountMap.forEach { (rank, count) ->
            println("${rank.name} (${rank.countOfMatch}개 일치): ${count}개 당첨")
        }
        println("총 수익률은 ${"%.2f".format(result.profitRate)}입니다.")
    }
}
