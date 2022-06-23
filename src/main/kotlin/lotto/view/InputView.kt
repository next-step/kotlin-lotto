package lotto.view

import java.math.BigDecimal

class InputView {

    fun inputBigDecimal(): BigDecimal {
        println("구입금액을 입력해 주세요.")
        return readln().toBigDecimal()
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
