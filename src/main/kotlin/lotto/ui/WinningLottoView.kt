package lotto.ui

import lotto.domain.LottoNumbers
import lotto.domain.WinningLotto

object WinningLottoView {
    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(inputWinningNumber())
    }

    private fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(",")
            .map {
                it.trim().toIntOrNull()
                    ?.takeIf { number -> number in LottoNumbers.LOTTO_MIN_NUMBER..LottoNumbers.LOTTO_MAX_NUMBER }
                    ?: throw IllegalArgumentException()
            }
        require(numbers.size == LottoNumbers.LOTTO_NUMBER_SIZE) { "당첨번호 입력이 잘못 되었습니다." }
        println()
        return numbers
    }
}
