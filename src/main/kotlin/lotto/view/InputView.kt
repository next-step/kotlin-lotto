package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningNumber(): LottoTicket {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")

        val tokens = readln().split(", ")

        return LottoTicket(
            tokens.map { LottoNumber.of(it.toInt()) }
        )
    }
}
