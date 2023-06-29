package lotto.ui

import lotto.domain.PrizeLevel
import lotto.dto.PurchasedLotteryPapers

class ResultView {
    fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        val lotteryPaperList = purchasedLotteryPapers.lotteryPaperList
        lotteryPaperList.forEach {
            printSingleLottoNumber(it.getLottoNumber())
        }
        println()
    }

    private fun printSingleLottoNumber(lottoNumber: List<Int>) {
        print("[")
        lottoNumber.forEachIndexed { index, ints ->
            print(ints)
            printIfNotLastIndex(index, lottoNumber)
        }
        println("]")
    }

    private fun printIfNotLastIndex(index: Int, lottoNumber: List<Int>) {
        if (index != lottoNumber.lastIndex) {
            print(", ")
        }
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
                val count = matchLottoNumber.getOrDefault(prizeLevel, 0)
                println("${prizeLevel.numberOfHit}개 일치 (${prizeLevel.prizeMoney}원)- ${count}개")
            }
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${yield}입니다.")
    }
}
