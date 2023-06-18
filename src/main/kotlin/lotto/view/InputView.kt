package lotto.view

import lotto.InputParser
import lotto.domain.BonusBall
import lotto.domain.Lotto

object InputView {

    private const val EMPTY_STRING = "입력값이 없습니다"

    fun getBuyAmount(): Int? {
        println("구입금액을 입력해 주세요.")
        val inputData = readlnOrNull()
        return InputParser.parseInputStringToInt(inputData)
    }

    fun getLottoBuyCount(): Int? {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val inputData = readlnOrNull()
        return InputParser.parseInputStringToInt(inputData)
    }

    fun getWinLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException(EMPTY_STRING)
        return Lotto(InputParser.parseWinNumbers(inputData))
    }

    fun getBonusBall(): BonusBall {
        println("보너스 볼을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException(EMPTY_STRING)
        val bonusNumber = InputParser.parseBonus(inputData)
        return BonusBall(bonusNumber)
    }
}
