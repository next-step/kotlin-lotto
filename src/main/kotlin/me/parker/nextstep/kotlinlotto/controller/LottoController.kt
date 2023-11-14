package me.parker.nextstep.kotlinlotto.controller

import me.parker.nextstep.kotlinlotto.domain.LottoNumber
import me.parker.nextstep.kotlinlotto.domain.LottoTicket
import me.parker.nextstep.kotlinlotto.domain.LottoWinningMachine
import me.parker.nextstep.kotlinlotto.view.ConsoleInput
import me.parker.nextstep.kotlinlotto.view.ConsoleResult

fun main() {
    val amountOfPurchase: Int = ConsoleInput.inputAmountOfPurchaseLotto()

    val purchasedLottoTickets: List<LottoTicket> = List(amountOfPurchase / LottoTicket.PRICE) {
        LottoTicket.automatic()
    }

    ConsoleResult.outputPurchasedLottoTickets(purchasedLottoTickets)

    val lastWonLottoNumbers: List<Int> = ConsoleInput.inputLastWonLottoNumbers()
    val wonLottoTicket = LottoTicket.manual(lastWonLottoNumbers)

    val bonusLottoNumber: Int = ConsoleInput.inputBonusLottoNumber()

    val lottoResult = LottoWinningMachine(wonLottoTicket, purchasedLottoTickets, LottoNumber(bonusLottoNumber))
        .result()

    ConsoleResult.outputLottoResult(lottoResult)
}