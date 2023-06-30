package lotto.view

import lotto.Lotto
import lotto.LottoNumber

object InputView {
    fun purchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun lastWeekLottoNumber(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln()
            .split(DELIMITER)
            .map { it.trim().toInt() }

        return Lotto.from(
            numbers = numbers.toSet(),
        )
    }

    fun lastWeekBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.build(readln().toInt())
    }

    private const val DELIMITER = ","
}
