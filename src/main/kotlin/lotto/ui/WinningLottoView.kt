package lotto.ui

import lotto.domain.WinningLotto

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        return WinningLotto(*winningNumbers) { bonusNumber }
    }

    private fun inputWinningNumbers(): IntArray {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException() }
            .toIntArray()
    }

    private fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumbers = readln().toIntOrNull() ?: throw IllegalArgumentException()
        println()
        return bonusNumbers
    }
}
