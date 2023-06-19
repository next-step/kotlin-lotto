package lotto.view

import lotto.LottoNumber

object InputView {
    fun purchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun lastWeekLottoNumber(): LottoNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val defaultNumbers = readln()
            .split(DELIMITER)
            .map { it.trim().toInt() }
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()

        return LottoNumber.from(
            defaultNumbers = defaultNumbers,
            bonusNumber = bonusNumber,
        )
    }

    private const val DELIMITER = ","
}
