package lotto.view

import lotto.domain.WinningLotto
import lotto.domain.validate
import lotto.domain.validateBonusNumber
import lotto.domain.validateWinningNumber

object InputView {

    fun purchasePrice(): Int {

        println("구입금액을 입력해 주세요.")
        val price = validate(readLine())

        return price
    }

    fun lastWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val text = readLine()
        var winningNumbers = validateWinningNumber(text)

        while (winningNumbers == null) {
            println("다시 입력해주세요")
            winningNumbers = validateWinningNumber(readLine())
        }

        println("보너스 볼을 입력해 주세요.")
        val text2 = readLine()
        var bonusNumber = validateBonusNumber(text2)

        while (bonusNumber == 0) {
            println("다시 입력해주세요")
            bonusNumber = validate(readLine())
        }

        return WinningLotto(winningNumbers.map { it.toInt() }.toSet(), bonusNumber)
    }
}
