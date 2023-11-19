package lotto.presentation.view

object InputView {
    fun getPurchaseInput(): String {
        println("구입 금액을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")
    }

    fun getWinningNumbersInput(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")
    }

    fun getBounsNumberInput(): String {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("콘솔 입력을 확인해 주세요.")
    }
}
