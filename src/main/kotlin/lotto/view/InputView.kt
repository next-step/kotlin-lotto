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
        val amount = readLine()
        require(!amount.isNullOrBlank()) { "구입금액은 공백이거나 null일수 없습니다" }

        return amount.toInt()
    }

    fun inputWonNumber(): LottoWonNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val lottoNumbers = readLine()!!.split(",")
            .map { LottoNumber(it.trim().toInt()) }
            .toSet()

        println("보너스 번호를 입력해 주세요")

        val bonusNumber = LottoNumber(readLine()!!.toInt())

        return LottoWonNumbers(lottoNumbers, bonusNumber)
    }
}
