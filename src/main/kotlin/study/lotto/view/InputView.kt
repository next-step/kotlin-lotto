package study.lotto.view

import study.lotto.domain.Amount

class InputView {
    fun getPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
            ?.toIntOrNull()
            ?.let(::Amount)
            ?: Amount.ZERO
    }

    fun getLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
            ?.split(',')
            ?.mapNotNull { it.trim().toIntOrNull() }
            ?: emptyList()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()
            ?.trim()
            ?.toIntOrNull()
            ?: 0
    }
}
