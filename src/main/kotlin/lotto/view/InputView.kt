package lotto.view

import lotto.model.WinningNumbers
import lotto.service.LottoStringParser
import java.math.BigDecimal

object InputView {
    fun readMoney(): BigDecimal {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toBigDecimal()
    }

    fun readWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해주세요.")
        val input = readLine()!!
        return WinningNumbers.of(LottoStringParser.parse(input))
    }
}
