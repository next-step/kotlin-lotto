package lotto.view

import lotto.view.input.ManualLottoInputs
import lotto.view.input.AmountInput
import lotto.view.input.ManualLottoInput
import lotto.view.input.ManualCountInput
import lotto.view.input.BonusInput
import lotto.view.input.LottoWonInput

class InputView {
    tailrec fun amoutInput(): AmountInput {
        println("구입금액을 입력해 주세요.")

        val readLine = readLine()
        if (readLine.isNullOrEmpty()) {
            return amoutInput()
        }

        return AmountInput(readLine)
    }

    tailrec fun inputWonNumber(): LottoWonInput {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val readLine = readLine()
        if (readLine.isNullOrEmpty()) {
            return inputWonNumber()
        }

        return LottoWonInput(readLine)
    }

    tailrec fun inputBonusNumber(): BonusInput {
        println("보너스 번호를 입력해 주세요")

        val readLine = readLine()
        if (readLine.isNullOrEmpty()) {
            return inputBonusNumber()
        }

        return BonusInput(readLine)
    }

    tailrec fun inputManualCount(): ManualCountInput {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val readLine = readLine()
        if (readLine.isNullOrEmpty()) {
            return inputManualCount()
        }

        return ManualCountInput(readLine)
    }

    fun inputManualLottoTickets(manualCountInput: ManualCountInput): ManualLottoInputs {
        val count = manualCountInput.lottoCount

        if (count == 0) return ManualLottoInputs()
        println("수동으로 구매할 번호를 입력해 주세요.")

        val lottoTickets = mutableListOf<ManualLottoInput>()
        repeat(count) { index ->
            lottoTickets.add(inputManualLottoTicket(index))
        }

        return ManualLottoInputs(lottoTickets)
    }

    private tailrec fun inputManualLottoTicket(index: Int): ManualLottoInput {
        println("$index 번 째 번호를 입력해주세요.")

        val readLine = readLine()
        if (readLine.isNullOrBlank()) {
            return inputManualLottoTicket(index)
        }

        return ManualLottoInput(readLine)
    }
}
