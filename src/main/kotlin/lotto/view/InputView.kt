package lotto.view

import lotto.domain.value.LottoNumber
import lotto.domain.value.Money

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."

    private const val ERROR_NOT_INTEGER = "숫자만 넣어 주세요"
    private const val ERROR_INVALID = "콤마(,)로 연결된 6자리 숫자를 입력하세요."

    fun inputMoney(): Money {
        println(INPUT_MONEY)
        val won = readLine()?.toBigInteger() ?: throw IllegalArgumentException(ERROR_NOT_INTEGER)
        return Money(won)
    }

    fun inputWinningNumber(): List<LottoNumber> {
        println(INPUT_WINNING_NUMBER)
        return readLine()?.split(",")?.map {
            LottoNumber(it.toInt())
        } ?: throw IllegalArgumentException(ERROR_INVALID)
    }

    // fun getBuyCount(inputMoney: Money) = inputMoney.won() / PRICE_PER_UNIT
}
