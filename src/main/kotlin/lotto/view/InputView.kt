package lotto.view

import lotto.domain.LottoNumberParser

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoNumberParser.parse(readlnOrNull() ?: throw IllegalArgumentException("Invalid input"))
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
    }
}
