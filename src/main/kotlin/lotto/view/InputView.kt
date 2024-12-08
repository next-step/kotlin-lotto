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

    fun readBonusLotto(promptMessage: String): Int {
        println(promptMessage)
        val bonusLottoNumber = readlnOrNull()?.trim()?.toIntOrNull() ?: 0 // single number
        return bonusLottoNumber
    }

    const val ENTER_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요."
    private const val LOTTO_SIZE = 6
}
