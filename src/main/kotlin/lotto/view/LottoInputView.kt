package lotto.view

import lotto.model.LottoNumbers

class LottoInputView {
    fun getPurchasePrice(): String? {
        return getInput("구입 금액을 입력해주세요.")
    }

    fun getWinningNumbers(): String? {
        return getInput("지난 주 당첨 번호를 입력해 주세요.")
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        println("${lottoNumbers.size}개의 로또를 구매했습니다.")
        lottoNumbers.forEach { println(it) }
        println()
    }
}
