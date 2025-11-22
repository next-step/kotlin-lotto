package com.example.mylotto.view

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoResult
import com.example.mylotto.model.LottoTicket

class ResultView {
    fun displayPurchasedTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println(ticket.numbers.joinToString(prefix = "[", postfix = "]") { it.number.toString() })
        }

        println()
    }

    fun displayWinningStatistics(result: LottoResult) {
        println(
            """
            
            당첨 통계
            ---------
            """.trimIndent(),
        )

        Rank.entries
            .filter { it != Rank.MISS }
            .sortedBy { it.winningMoney }
            .forEach { rank ->
                val count = result.rankCountMap.getOrDefault(rank, 0)
                println("${rank.countOfMatch}개 일치 (${rank.winningMoney}원)- ${count}개")
            }

        print("총 수익률은 ${"%.2f".format(result.profitRate)}입니다.")

        if (result.profitRate < 1.0) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        } else {
            println("(이득)")
        }
    }
}
