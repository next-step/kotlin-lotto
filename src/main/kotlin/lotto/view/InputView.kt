package lotto.view

import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object InputView {

    private const val WINNING_NUMBER_DELIMITER = ","

    fun readPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return Amount(readln().toInt())
    }

    fun readWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(WINNING_NUMBER_DELIMITER)
            .map { LottoNumber(it.trim().toInt()) }
            .let { LottoNumbers(it.toSet()) }
    }

    fun readBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }
}
