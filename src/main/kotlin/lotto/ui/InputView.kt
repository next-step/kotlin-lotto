package lotto.ui

object InputView {

    fun inputLottoAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount: String = readLine() ?: throw IllegalArgumentException("구매금액을 숫자를 입력해야 합니다")

        return amount.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다")
    }

    fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber: String = readLine() ?: throw IllegalArgumentException("당첨 번호는 필수 입력해야 합니다")

        val result = winningNumber.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다") }
            .toList()

        require(result.size == 6){"당첨번호는 6개이어야 합니다"}
        return result
    }
}
