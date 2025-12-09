package com.example.mylotto.view

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoNumbers
import com.example.mylotto.model.LottoResult

class ResultView {
    fun displayPurchasedTickets(
        manualLottoNumbers: List<LottoNumbers>,
        autoLottoNumbers: List<LottoNumbers>,
    ) {
        println("수동으로 ${manualLottoNumbers.size}장, 자동으로 ${autoLottoNumbers.size}개를 구매했습니다.")
        (manualLottoNumbers + autoLottoNumbers).forEach { ticket ->
            println(ticket.numbers.joinToString(prefix = "[", postfix = "]") { it.number.toString() })
        }

        println()
    }

    fun displayWinningStatistics(result: LottoResult) {
        println()
        println("당첨 통계")
        println("---------")

        Rank.entries
            .filter { it != Rank.MISS }
            .sortedBy { it.winningMoney }
            .forEach { rank ->
                val count = result.rankCountMap.getOrDefault(rank, 0)
                println("${rank.countOfMatch}개 일치${if (rank == Rank.SECOND) ", 보너스 볼 일치" else ""} (${rank.winningMoney}원)- ${count}개")
            }

        print("총 수익률은 ${"%.2f".format(result.profitRate)}입니다.")

        if (result.profitRate < 1.0) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        } else {
            println("(이득)")
        }
    }
}
