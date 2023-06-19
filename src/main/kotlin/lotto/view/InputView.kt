package lotto.view

import lotto.LottoNumber

object InputView {
    fun purchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun lastWeekLottoNumber(): LottoNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln()
            .split(DELIMITER)
            .map { it.trim().toInt() }
        return LottoNumber.from(numbers)
    }

    private const val DELIMITER = ","
}
