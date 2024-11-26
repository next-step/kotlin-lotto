package lotto.view

object InputView {
    fun readTotalPurchaseAmountAsInt(): Int {
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    fun readWinningLotto(promptMessage: String): List<Int> {
        println(promptMessage)
        val winningLotto = readlnOrNull()?.split(",")?.map { it.trim().toIntOrNull() ?: 0 }
        return winningLotto ?: throw IllegalStateException("Separate Lotto numbers by comma (,)")
    }

    const val ENTER_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
}
