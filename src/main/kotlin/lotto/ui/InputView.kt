package lotto.ui

import lotto.domain.LottoNumber

class InputView {

    fun getPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumber(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputText = readln()
        return parseWinningNumberText(inputText)
    }

    private fun parseWinningNumberText(inputText: String): List<LottoNumber> {
        return inputText.split(", ").map { LottoNumber(it.toInt()) }
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }
}
