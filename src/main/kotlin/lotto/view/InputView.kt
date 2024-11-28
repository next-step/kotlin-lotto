package lotto.view

import lotto.util.NumberSplitter

object InputView {
    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return getNumberInput()
    }

    fun getWinNumberInput(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return NumberSplitter.splitInput(readln())
            .map { it.toIntOrNull() }
            .requireNoNulls()
            .toSet()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return getNumberInput()
    }

    private fun getNumberInput(): Int {
        return requireNotNull(readln().toIntOrNull()) { "숫자를 입력해주세요." }
    }
}
