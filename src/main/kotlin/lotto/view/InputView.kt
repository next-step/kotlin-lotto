package lotto.view

import lotto.domain.ArgumentValidator
import lotto.domain.ArgumentValidator.Companion.BLANK_ERROR_MESSAGE
import lotto.domain.InputPrice
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object InputView {

    fun inputPrice(): InputPrice {
        println(INPUT_PRICE_MESSAGE)
        return InputPrice(ArgumentValidator(readln()).intValue)
    }

    fun inputManualLottoCount(): Int {
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
        return ArgumentValidator(readln()).intValue
    }

    fun inputManualLotto(manualCount: Int): List<LottoNumbers> {
        println(INPUT_MANUAL_LOTTO_MESSAGE)

        return List(manualCount) {
            LottoNumbers(parseLottoNumber(readln()))
        }
    }

    fun inputWinningLotto(): List<LottoNumber> {
        println(INPUT_WINNING_LOTTO_MESSAGE)
        return parseLottoNumber(readln())
    }

    fun inputBonusBall(): LottoNumber {
        println(INPUT_BONUS_BALL_MESSAGE)
        val bonusBall = readln()
        return LottoNumber(ArgumentValidator(bonusBall).intValue)
    }

    private fun parseLottoNumber(input: String): List<LottoNumber> {
        require(input.isNotBlank()) { println(BLANK_ERROR_MESSAGE) }
        return input.split(DELIMITER).map { LottoNumber(ArgumentValidator(it.trim()).intValue) }
    }

    private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."
    private const val DELIMITER = ","
}
