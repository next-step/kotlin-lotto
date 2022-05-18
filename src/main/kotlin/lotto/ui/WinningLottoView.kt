package lotto.ui

import lotto.domain.WinningLotto

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(inputWinningNumber())
    }

    private fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readLine()!!.split(",")
            .map {
                it.trim().toIntOrNull()
                    ?.takeIf { number -> number in 1..45 }
                    ?: throw IllegalArgumentException()
            }
        require(numbers.size == 6) { "당첨번호 입력이 잘못 되었습니다." }
        println()
        return numbers
    }
}
