package lotto.ui

import lotto.domain.LottoNumbers
import lotto.domain.WinningLotto
import lotto.domain.WinningLotto.Companion.winningLottoOf

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        return winningLottoOf(winningNumbers).bonus(bonusNumber)
    }

    private fun inputWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException() }
            .let { LottoNumbers(*it.toIntArray()) }
    }

    private fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumbers = readln().toIntOrNull() ?: throw IllegalArgumentException()
        println()
        return bonusNumbers
    }
}
