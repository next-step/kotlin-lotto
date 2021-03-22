package lotto.view

import lotto.view.input.ManualLottoInputs
import lotto.view.input.AmountInput
import lotto.view.input.ManualLottoInput
import lotto.view.input.ManualCountInput
import lotto.view.input.BonusInput
import lotto.view.input.LottoWonInput

class InputView {
    fun input(): AmountInput {
        println("구입금액을 입력해 주세요.")

        val input = AmountInput(readLine())

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

    fun inputManualCount(): ManualCountInput {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return ManualCountInput(readLine())
    }

    fun inputManualLottoTickets(count: Int): ManualLottoInputs {
        if (count == 0) return ManualLottoInputs()
        println("수동으로 구매할 번호를 입력해 주세요.")

        val lottoTickets = mutableListOf<ManualLottoInput>()

        repeat(count) {
            lottoTickets.add(ManualLottoInput(readLine()))
        }

        return ManualLottoInputs(lottoTickets)
    }
}
