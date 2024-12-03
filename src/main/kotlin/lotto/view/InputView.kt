package lotto.view

import java.math.BigDecimal

object InputView {
    fun readTotalPurchaseAmountAsBigDecimal(): BigDecimal {
        return readlnOrNull()?.trim()?.toBigDecimalOrNull() ?: BigDecimal.ZERO
    }

    fun readWinningLotto(promptMessage: String): List<Int> {
        println(promptMessage)
        val winningLotto = readlnOrNull()?.split(",")?.map { it.trim().toIntOrNull() ?: 0 }
        require(winningLotto?.size == LOTTO_SIZE) { "Lotto size must be 6" }
        return winningLotto ?: throw IllegalStateException("Separate Lotto numbers by comma (,)")
    }

    const val ENTER_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val LOTTO_SIZE = 6
}
