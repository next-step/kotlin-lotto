package next.step.racing.view

import next.step.lotto.domain.LottoNumber
import next.step.lotto.domain.LottoWinningNumbers
import next.step.lotto.view.LottoNumberParser

object InputView {

    private const val ENTER_PAYMENT = "구입금액을 입력해 주세요."
    private const val ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val ENTER_BONUS_NUBER = "보너스 볼을 입력해 주세요."

    fun readPayment(): Int = read(ENTER_PAYMENT, String::toInt)

    fun readWinningNumbers(): LottoWinningNumbers = read(ENTER_WINNING_NUMBERS, this::parseNumbers)

    private fun parseNumbers(str: String) = LottoWinningNumbers.of(LottoNumberParser.parse(str))

    fun readBonusNumber(): LottoNumber = read(ENTER_BONUS_NUBER, this::parseNumber)

    private fun parseNumber(str: String): LottoNumber = LottoNumber.of(str.toInt())

    private fun <T> read(enterMsg: String, constructor: (String) -> T): T {
        return try {
            println(enterMsg)
            constructor(readln())
        } catch (e: Exception) {
            OutputView.showError(e.message)
            read(enterMsg, constructor)
        }
    }
}
