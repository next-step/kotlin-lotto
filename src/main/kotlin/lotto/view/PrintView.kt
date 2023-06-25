package lotto.view

import lotto.domain.LottoNumbers

fun printBuyCount(price: Int) {
    print("${(price / 1000)}개를 구매했습니다.")
    println()
}

fun printLottoNumbers(lottoNumbers: List<LottoNumbers>) {
    lottoNumbers.forEach {
        println(it.lottoNumbers)
    }
    println()
}
