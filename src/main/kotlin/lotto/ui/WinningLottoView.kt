package lotto.ui

import lotto.domain.WinningLotto

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(inputWinningNumber())
    }

    private fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException() }
        println()
        return numbers
    }
}
