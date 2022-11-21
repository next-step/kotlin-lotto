package lotto.view

import lotto.dto.LottoTicketBulkDto
import lotto.dto.StatisticResult

class OutputView {

    companion object {
        fun printPurchase(autoPurchaseCount: Int, manualPurchaseCount: Int) {
            println("수동으로 ${autoPurchaseCount}장, 자동으로 ${manualPurchaseCount}개를 구매했습니다.")
        }

        fun printLottoNumbers(lottoTicketBulkDto: LottoTicketBulkDto) {
            lottoTicketBulkDto.tickets.forEach {
                println(it.joinToString(separator = ", ", prefix = "[", postfix = "]"))
            }
            println()
        }

        fun printStatistics(statistics: List<StatisticResult>, profitRate: Double) {
            println("당첨 통계")
            println("---------")
            statistics.forEach {
                print("${it.lottoResult.matchCount}개 일치")
                if (it.lottoResult.matchBonus)
                    print(", 보너스 볼 일치 ")
                println("(${it.lottoResult.winningMoney}원)- ${it.count}개")
            }
            println("총 수익률은 ${profitRate}입니다.")
        }
    }
}
