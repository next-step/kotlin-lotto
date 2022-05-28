package lotto.ui

import lotto.application.WinningNumberParser
import lotto.domain.Lotto
import lotto.domain.Worth

object LottoInputView {

    fun getPurchaseAmount(): Worth {
        println("구입금액을 입력해 주세요.")
        val investment = readln().toIntOrNull() ?: throw RuntimeException("")

        return Worth(investment)
    }

    fun getWinningLotteryNumber(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotteryNumber = readln()

        return Lotto(WinningNumberParser.parse(winningLotteryNumber))
    }
}
