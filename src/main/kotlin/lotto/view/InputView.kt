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

    fun inputAdditionalMoney(): BigDecimal {
        println("수동 로또 구매 가능 금액이 부족합니다. 금액을 더 입력해주세요.")
        return readln().toBigDecimal()
    }

    companion object {
        private const val DELIMITER = ", "
    }
}
