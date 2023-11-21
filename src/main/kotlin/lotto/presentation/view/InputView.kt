package lotto.presentation.view

object InputView {
    fun getPurchaseInput(): Int {
        println("구입 금액을 입력해 주세요.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")

        return input.toIntOrNull() ?: throw IllegalArgumentException("구입 금액은 정수여야 합니다")
    }

    fun getWinningNumbersInput(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")

        return input.replace(" ", "")
            .split(",")
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("우승자 번호는 숫자여야 합니다.") }
    }

    fun getBonusNumberInput(): Int {
        println("보너스 볼을 입력해 주세요.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")

        return input.toIntOrNull() ?: throw IllegalArgumentException("보너스볼 번호는 숫자여야 합니다.")
    }
}
