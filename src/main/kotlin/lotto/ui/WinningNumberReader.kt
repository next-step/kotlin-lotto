package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

object WinningNumberReader {
    fun read(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbersAsCommaSeparatedString = readln()
        val winningNumbers = winningNumbersAsCommaSeparatedString
            .split(", ")
            .map { it.toInt() }
            .map { LottoNumber(it) }
        val winningLotto = Lotto.of(winningNumbers)
        return WinningLotto(winningLotto)
    }
}
