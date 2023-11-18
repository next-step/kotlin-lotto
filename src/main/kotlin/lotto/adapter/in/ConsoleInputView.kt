package lotto.adapter.`in`

class ConsoleInputView {
    fun getPurchaseAmountInput(): PurchaseRequest {
        println("구입금액을 입력해 주세요.")
        return PurchaseRequest.from(readInput())
    }

    fun getWinningNumbersInput(): WinningNumbersRequest {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return WinningNumbersRequest.from(readInput())
    }

    private fun readInput(): String = readlnOrNull()
        ?: throw IllegalArgumentException("입력 값이 없습니다.")
}