package lotto.ui

import lotto.domain.LotteryPapers

class ResultView {
    fun printLottoNumbers(lotteryPapers: LotteryPapers) {
        val lottoResponse = lotteryPapers.getLottoResponse()
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
    }

    fun printNumberOfLottoTicket(numberOfLottoTicket: Int) {
        println("${numberOfLottoTicket}개를 구매했습니다.")
    }
}