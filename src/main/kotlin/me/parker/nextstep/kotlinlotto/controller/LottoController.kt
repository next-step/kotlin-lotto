package me.parker.nextstep.kotlinlotto.controller

import me.parker.nextstep.kotlinlotto.domain.LottoNumber
import me.parker.nextstep.kotlinlotto.domain.LottoTicket
import me.parker.nextstep.kotlinlotto.domain.LottoTicketMachine
import me.parker.nextstep.kotlinlotto.domain.LottoWinningMachine
import me.parker.nextstep.kotlinlotto.view.ConsoleInput
import me.parker.nextstep.kotlinlotto.view.ConsoleResult

fun main() {
    val amountOfPurchase: Int = ConsoleInput.inputAmountOfPurchaseLotto()
    val sizeOfManual: Int = ConsoleInput.inputSizeOfManualLotto()

    ConsoleInput.inputManualLottoNumbers()
    val manualLottoNumbers: List<List<Int>> = List(sizeOfManual) {
        ConsoleInput.inputLottoNumbers()
    }

    val lottoTicketMachine = LottoTicketMachine(amountOfPurchase, manualLottoNumbers)
    val purchasedLottoTickets = lottoTicketMachine.purchase()

    ConsoleResult.outputPurchasedLottoTickets(sizeOfManual, purchasedLottoTickets)

    val lastWonLottoNumbers: List<Int> = ConsoleInput.inputLastWonLottoNumbers()
    val wonLottoTicket = LottoTicket.manual(lastWonLottoNumbers)

    val bonusLottoNumber: Int = ConsoleInput.inputBonusLottoNumber()

    val lottoResult = LottoWinningMachine(wonLottoTicket, purchasedLottoTickets, LottoNumber(bonusLottoNumber))
        .result()

    ConsoleResult.outputLottoResult(lottoResult)
}
