package lotto.view

import lotto.domain.Money
import lotto.dto.LottoNumbers

object InputView {
    private const val REGEX = ","

    fun inputMoney(): Money {
        println("구입 금액을 입력해주세요.")
        val input: Int = readln().toInt()
        return Money(input)
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLottoNumbers(count: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) { inputLottoNumbers() }
    }

    fun inputWinNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return inputLottoNumbers()
    }

    private fun inputLottoNumbers(): LottoNumbers {
        val input: String = readln().replace(" ", "")
        val inputStrings = input.split(REGEX)
            .dropLastWhile { it.isEmpty() }
            .map { it.toInt() }
        return LottoNumbers(inputStrings)
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
