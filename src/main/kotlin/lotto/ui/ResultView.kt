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

        for ((prizeLevel, count) in matchLottoNumber) {
            val numberOfHits = prizeLevel.numberOfHit
            val prizeMoney = prizeLevel.prizeMoney
            println("${numberOfHits}개 일치 (${prizeMoney}원)- ${count}개")
        }
    }
}
