package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.WinningNumber

object InputView {
    fun readPayment(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun readWinningNumber(): WinningNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return WinningNumber(
            readln().split(",")
                .map { Integer.parseInt(it.trim()) }
                .map { LottoNumber(it) }
                .toSet()
        )
    }
}
