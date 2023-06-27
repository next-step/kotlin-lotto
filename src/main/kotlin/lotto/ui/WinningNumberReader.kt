package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

object WinningNumberReader {

    const val DELIMITER = ","
    fun read(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbersAsCommaSeparatedString = readln()
        val winningNumbers = winningNumbersAsCommaSeparatedString.split(DELIMITER)
            .map { it.trim() }
            .map { it.toInt() }
            .map { LottoNumber(it) }
        val winningLotto = Lotto.from(winningNumbers)

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()
        return WinningLotto(winningLotto, LottoNumber(bonusNumber))
    }
}
