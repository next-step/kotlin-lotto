package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber

object InputView {
    private const val DELIMITER = ","
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLottoWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto(readln().split(DELIMITER).map { LottoNumber(it.toInt()) }.toSet())
    }
}
