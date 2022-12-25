package lotto.views

import lotto.LottoNumbers

object Output {
    fun printBuyAmount(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }
    fun printLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach { println(it) }
    }
}