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

    fun readManualLottoCount(promptMessage: String): Int {
        println(promptMessage)
        val manualLottoCount = readlnOrNull()?.trim()?.toIntOrNull() ?: 0
        return manualLottoCount
    }

    fun readManualLottoList(
        promptMessage: String,
        count: Int,
    ): List<List<Int>> {
        val manualLottoNumberList = mutableListOf<List<Int>>()
        println(promptMessage)
        repeat(count) {
            manualLottoNumberList.add(readManualLotto())
        }
        return manualLottoNumberList
    }

    private fun readManualLotto(): List<Int> {
        val input =
            readlnOrNull()?.trim()
                ?.split(",")
                ?.map { it.trim().toIntOrNull() ?: 0 }
                ?: throw IllegalStateException("Separate Lotto numbers by comma (,)")
        return input
    }

    const val ENTER_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요."
    const val ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    const val ENTER_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요. (예: 8, 21, 23, 41, 42, 43)"
    private const val LOTTO_SIZE = 6
}
