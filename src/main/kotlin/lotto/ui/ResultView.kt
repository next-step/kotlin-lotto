package lotto.ui

import lotto.domain.PrizeLevel
import lotto.dto.PurchasedLotteryPapers

class ResultView {
    fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        val lotteryPaperList = purchasedLotteryPapers.lotteryPaperList
        for (lotteryPaper in lotteryPaperList) {
            print("[")
            lotteryPaper.getLottoNumber().forEachIndexed { index, ints ->
                print(ints)
                if (index != lotteryPaper.getLottoNumber().lastIndex) {
                    print(", ")
                }
            }
            println("]")
        }
        println()
    }

    fun printNumberOfLottoTicket(numberOfLottoTicket: Int) {
        println("${numberOfLottoTicket}개를 구매했습니다.")
    }

    fun printMatchLottoNumber(matchLottoNumber: Map<PrizeLevel, Int>) {
        println("당첨 통계")
        println("---------")

        PrizeLevel.values()
            .filter { it != PrizeLevel.NONE }
            .forEach { prizeLevel ->
                val count = matchLottoNumber.getValue(prizeLevel)
                println("${prizeLevel.numberOfHit}개 일치 (${prizeLevel.prizeMoney}원)- ${count}개")
            }
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${yield}입니다.")
    }
}
