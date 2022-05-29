package lotto.view

object InputView {
    fun readLottoPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return readInput(readLine())
    }

    private fun readInput(readLine: String?): Long {
        require(!readLine.isNullOrBlank()) { "입력값이 비어있어요." }
        requireNotNull(readLine.toIntOrNull()) { "숫자만 입력해주세요." }
        return readLine.toLong()
    }
}
