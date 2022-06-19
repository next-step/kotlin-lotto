package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumber.Companion.toLottoNumbers
import camp.nextstep.lotto.number.LottoNumbers
import camp.nextstep.lotto.number.WinnerNumbers

object WinnerNumbersReader {

    fun read(): WinnerNumbers {
        val winnerNumbers = readWinnerNumbers()
        val bonusNumber = readBonusNumber()
        return WinnerNumbers(winnerNumbers, bonusNumber)
    }

    private fun readWinnerNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val readLine = requireNotNull(readLine())
        return readLine.split(",").map { it.trim().toInt() }.toLottoNumbers()
    }

    private fun readBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val readLine = requireNotNull(readLine())
        val bonusNumber = readLine.toInt()
        return LottoNumber.of(bonusNumber)
    }
}
