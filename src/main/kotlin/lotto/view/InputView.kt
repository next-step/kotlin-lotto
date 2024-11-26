package lotto.view

class InputView {
    fun readTotalPurchaseAmount() : String {
        val totalAmount = readlnOrNull()
        return totalAmount ?: "0"
    }

    fun readWinningLotto() : List<Int> {
        val winningLotto = readlnOrNull()?.split(",")?.map { it.toInt() }
        return winningLotto ?: throw IllegalStateException("Separate Lotto numbers by comma (,)")
    }
}