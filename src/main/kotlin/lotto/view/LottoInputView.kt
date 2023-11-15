package lotto.view

import lotto.model.LottoNumbers

class LottoInputView {
    fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        println("${lottoNumbers.size}개의 로또를 구매했습니다.")
        lottoNumbers.forEach { println(it) }
        println()
    }
}
