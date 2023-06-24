package lotto.ui

import lotto.domain.PrizeLevel
import lotto.dto.LottoResponse

class ResultView {
    fun printLottoNumbers(lottoResponse: LottoResponse) {
        val lottoNumbers = lottoResponse.lottoNumbers
        for (lottoNumber in lottoNumbers) {
            print("[")
            lottoNumber.forEachIndexed { index, ints ->
                print(ints)
                if (index != lottoNumber.lastIndex) {
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
