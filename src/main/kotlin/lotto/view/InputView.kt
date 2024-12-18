package lotto.view

import lotto.util.NumberSplitter

object InputView {
    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return getNumberInput()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return getNumberInput()
    }

    fun getManualLottoNumbers(count: Int): List<Set<Int>> {
        return (1..count).map { getLottoNumbers() }
    }

    fun getWinNumberInput(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getLottoNumbers()
    }

    private fun getLottoNumbers(): Set<Int> {
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
