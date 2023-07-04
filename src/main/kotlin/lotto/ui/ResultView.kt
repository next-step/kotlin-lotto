package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.PrizeLevel
import lotto.dto.PurchasedLotteryPapers

class ResultView {
    fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        val lotteryPaperList = purchasedLotteryPapers.lotteryPaperList
        lotteryPaperList.forEach {
            printSingleLottoNumber(it.getLottoNumbers())
        }
        println()
    }

    private fun printSingleLottoNumber(lottoNumbers: List<LottoNumber>) {
        print("[")
        lottoNumbers.forEachIndexed { index, lottoNumber ->
            print(lottoNumber.lottoNumber)
            printIfNotLastIndex(index, lottoNumbers)
        }
        println("]")
    }

    private fun printIfNotLastIndex(index: Int, lottoNumber: List<LottoNumber>) {
        if (index != lottoNumber.lastIndex) {
            print(", ")
        }
    }

    fun printNumberOfLottoTicket(numberOfLottoTicket: Int) {
        println("${numberOfLottoTicket}개를 구매했습니다.")
    }

    fun printMatchLottoNumber(matchLottoNumber: Map<PrizeLevel, Int>) {
        println()
        println("당첨 통계")
        println("---------")

        PrizeLevel.values()
            .filter { it != PrizeLevel.NONE }
            .forEach { prizeLevel ->
                val count = matchLottoNumber.getOrDefault(prizeLevel, 0)
                printEachPrizeLevel(prizeLevel, count)
            }
    }

    private fun printEachPrizeLevel(prizeLevel: PrizeLevel, count: Int) {
        var outputString = "${prizeLevel.numberOfHit}개 일치"
        if (prizeLevel == PrizeLevel.SECOND) {
            outputString += ", 보너스 볼 일치"
        }
        outputString += " (${prizeLevel.prizeMoney}원) - ${count}개"
        println(outputString)
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${yield}입니다.")
    }

    fun printNextLine() {
        println()
    }
}
