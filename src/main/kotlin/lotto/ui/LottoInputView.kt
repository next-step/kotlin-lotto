package lotto.ui

import lotto.application.WinningNumberParser
import lotto.domain.Lotto

object LottoInputView {
    private const val ONE_LOTTO_PRICE = 1000

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = readln().toIntOrNull() ?: throw RuntimeException("")

        return purchaseAmount / ONE_LOTTO_PRICE
    }

    fun getWinningLotteryNumber(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotteryNumber = readln()

        return Lotto(WinningNumberParser.parse(winningLotteryNumber))
    }
}
