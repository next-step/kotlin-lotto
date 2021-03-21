package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoWonNumbers

class InputView {
    fun input(): Input {
        println("구입금액을 입력해 주세요.")
        val amount = inputAmount()
        val input = Input(amount)

        println("${input.lottoCount}개를 구매했습니다.")

        return input
    }

    private fun inputAmount(): Int {
        val inputAmount = readLine()
        require(!inputAmount.isNullOrBlank()) { "구입금액은 공백이거나 null일수 없습니다" }

        return inputAmount.toIntOrNull() ?: throw IllegalArgumentException("구임금액은 숫자여야 합니다.")
    }

    fun inputWonNumber(): LottoWonNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readLine()
        require(!numbers.isNullOrBlank()) { "당첨 번호의 입력은 필수입니다. " }

        val lottoNumbers = numbers.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨번호는 숫자여야 합니다.") }
            .map(::LottoNumber)
            .toSet()

        println("보너스 번호를 입력해 주세요")

        val inputBonusNumber = readLine()
        require(!inputBonusNumber.isNullOrBlank()) { "보너스 번호는 필수입니다." }

        val bonusNumber = inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자여야 합니다.")

        return LottoWonNumbers(lottoNumbers, LottoNumber(bonusNumber))
    }
}
