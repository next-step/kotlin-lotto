package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningLotto

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        val winningNumbers = inputWinningLottoNumbers()
        val bonusNumber = inputWinningLottoBonusNumber()
        return WinningLotto.of(winningNumbers, bonusNumber)
    }

    private fun inputWinningLottoNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException() }
            .map { LottoNumber.of(it) }
            .let { LottoNumbers.of(it) }
    }

    private fun inputWinningLottoBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumbers = readln().toIntOrNull() ?: throw IllegalArgumentException()
        println()
        return LottoNumber.of(bonusNumbers)
    }
}
