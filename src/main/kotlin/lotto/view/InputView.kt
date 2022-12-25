package lotto.view

import lotto.domain.Cash
import lotto.domain.LottoWinTicket

object InputView {

    fun readCash(): Cash {
        println("구입금액을 입력해 주세요.")
        val input = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            error("현금은 숫자여야합니다.")
        }
        return Cash(input)
    }

    fun readWinNumber(): LottoWinTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winNumberString = readln()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberString = readln()
        return LottoWinTicket.of(winNumberString, bonusNumberString)
    }
}
