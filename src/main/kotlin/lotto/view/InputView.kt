package lotto.view

import java.math.BigDecimal

class InputView {

    fun inputMoney(): BigDecimal {
        println("구입금액을 입력해 주세요.")
        return readln().toBigDecimal()
    }

    fun inputManualLottoTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLottoTicketNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) { readln().split(DELIMITER).map { it.toInt() } }
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(DELIMITER)
            .map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    companion object {
        private const val DELIMITER = ", "
    }
}
