package lotto.view.util

import lotto.domain.LottoNumbers
import lotto.domain.LottoTicket
import lotto.domain.LottoTicket2
import lotto.domain.LottoTickets
import lotto.view.WinnerLottoNumberView

object ManualLottoView {
    fun inputManualLottoCount(maxPurchaseLottoCount: Int): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val inputManualLottoCountCommand: String? = readlnOrNull()
        requireNotNull(inputManualLottoCountCommand) { "입력된 수동 로또 개수가 없습니다." }

        val inputManualLottoCount = inputManualLottoCountCommand.toIntOrNull()
        requireNotNull(inputManualLottoCount) { "구입금액이 올바르게 입력되지 않았습니다." }
        require(inputManualLottoCount >= 0) { "수동 로또 개수는 0개부터 입력 가능합니다." }
        require(inputManualLottoCount <= maxPurchaseLottoCount) { "구입 가능한 수동 로또 개수를 초과했습니다." }

        return inputManualLottoCount
    }

    fun repeatInputManualLottoNumbers(manualLottoCount: Int): LottoTickets {
        println("\n수동으로 구매할 번호를 입력해 주세요.")

        val lottoNumbersList = mutableListOf<LottoNumbers>()
        repeat(manualLottoCount) { lottoNumbersList.add(inputManualLottoNumbers()) }

        val lottoTickets = lottoNumbersList.map { LottoTicket2(it) }

        return LottoTickets(lottoTickets)
    }

    private fun inputManualLottoNumbers(): LottoNumbers {
        val inputManualNumbersCommand: String? = readlnOrNull()

        requireNotNull(inputManualNumbersCommand) { "입력된 수동 번호가 없습니다." }

        return splitInputNumbersCommand(inputManualNumbersCommand)
    }
}
