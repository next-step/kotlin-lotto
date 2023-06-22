package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoCount
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningLotto

object LottoInputView {
    private const val WINNING_LOTTO_DELIMITER = ","

    fun inputMoney(): Money {
        return Money(readLineWithMessage("구입금액을 입력해 주세요.").trim().toInt())
    }

    fun inputManualLottos(): Lottos {
        val manualLottoCount = inputManualLottoCount()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return Lottos(
            (1..manualLottoCount.value).map {
                Lotto(readln().toLottoNumbers())
            },
        )
    }

    private fun inputManualLottoCount(): LottoCount {
        return LottoCount(readLineWithMessage("수동으로 구매할 로또 수를 입력해 주세요.").trim().toInt())
    }

    fun inputWinningLotto(): WinningLotto {
        val winningLottoNumbers = inputWinningLottoNumbers()
        val bonusNumber = inputBonusNumber()
        return WinningLotto(
            numbers = winningLottoNumbers,
            bonusNumber = bonusNumber,
        )
    }

    private fun inputWinningLottoNumbers(): LottoNumbers {
        return readLineWithMessage("지난 주 당첨 번호를 입력해 주세요.").toLottoNumbers()
    }

    private fun inputBonusNumber(): LottoNumber {
        return LottoNumber(readLineWithMessage("보너스 볼을 입력해 주세요.").trim().toInt())
    }

    private fun readLineWithMessage(message: String): String {
        println(message)
        return readln()
    }

    private fun readln(): String {
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }

    private fun String.toLottoNumbers(): LottoNumbers {
        return this.split(WINNING_LOTTO_DELIMITER)
            .map { it.trim().toInt() }
            .let { LottoNumbers.from(it.toSet()) }
    }
}
