package lotto.view

import lotto.InputParser
import lotto.domain.BonusNumber
import lotto.domain.LottoNumber

object InputView {

    fun inputBuyAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return InputParser.getBuyAmount(inputData)
    }

    fun inputWinNumber(): LottoNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return LottoNumber(InputParser.parseWinNumbers(inputData))
    }

    fun inputBonusNumber(winNumber: LottoNumber): BonusNumber {
        println("보너스 볼을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        val bonusNumber = InputParser.parseBonus(inputData)
        return BonusNumber(winNumber, bonusNumber)
    }
}
