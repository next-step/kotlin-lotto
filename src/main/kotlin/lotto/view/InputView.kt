package lotto.view

import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoWinningNumber

object InputView {

    private const val WINNING_NUMBER_DELIMITER = ","

    fun readPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return Amount(readln().toInt())
    }

    fun readWinningNumber(): LottoWinningNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(WINNING_NUMBER_DELIMITER)
            .map { LottoNumber(it.trim().toInt()) }
            .let { LottoWinningNumber(LottoNumbers(it.toSet())) }
    }
}
