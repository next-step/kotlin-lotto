package lotto.view

import lotto.view.input.AmountInput
import lotto.view.input.BonusInput
import lotto.view.input.LottoWonInput

class InputView {
    fun input(): AmountInput {
        println("구입금액을 입력해 주세요.")

        val input = AmountInput(readLine())

        println("${input.lottoCount}개를 구매했습니다.")

        return input
    }

    fun inputWonNumber(): LottoWonInput {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return LottoWonInput(readLine())
    }

    fun inputBonusNumber(): BonusInput {

        println("보너스 번호를 입력해 주세요")

        return BonusInput(readLine())
    }
}
