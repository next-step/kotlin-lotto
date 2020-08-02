package lotto.view

import lotto.domain.value.LottoNumber

object InputView {
    const val INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_NOT_INTEGER_ERROR_MESSAGE = "숫자만 넣어 주세요"
    const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    const val INPUT_NOT_VALID_ERROR_MESSAGE = "콤마(,)로 연결된 6자리 숫자를 입력하세요."

    fun inputMoney(): Int {
        println(INPUT_MONEY_MESSAGE)
        return readLine()?.toInt() ?: throw IllegalArgumentException(INPUT_NOT_INTEGER_ERROR_MESSAGE)
    }

    fun inputWinningNumber(): List<LottoNumber> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return readLine()?.split(",")?.map {
            LottoNumber(it.toInt())
        } ?: throw IllegalArgumentException(INPUT_NOT_VALID_ERROR_MESSAGE)
    }
}
