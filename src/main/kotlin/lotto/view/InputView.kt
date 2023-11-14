package lotto.view

import lotto.dto.LottoResult
import lotto.dto.PurchaseAmount

object InputView {
    fun readPrice(): PurchaseAmount {

        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                return PurchaseAmount(readln().toInt())
            } catch (e: NumberFormatException) {
                println("숫자만 입력 가능합니다.")
            }
        }
    }

    fun inputWinningNumbers(): LottoResult {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoResult.of(readlnOrNull())
    }
}
