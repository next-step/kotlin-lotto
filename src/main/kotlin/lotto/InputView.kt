package lotto

import lotto.store.PurchaseRequest
import lotto.ticket.WinningTicket

private fun input(): String = readLine() ?: throw IllegalArgumentException("값을 제대로 입력해주세요")

fun inputPrice(): PurchaseRequest {
    println("구매금액을 입력해주세요.")
    val txAmount = input()
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    val txManualLottoCount = input()
    println("수동으로 구매할 번호를 입력해 주세요.")
    return PurchaseRequest.ofTxAmount(
        txAmount = txAmount,
        txManualLottoTickets = (0 until txManualLottoCount.toInt())
            .map { input() }
    )
}

fun inputWinningTicket(): WinningTicket {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val txNumbers = input()

    println("보너스 볼을 입력해 주세요.")
    val bonusBall = input()

    return WinningTicket.ofTxNumbers(txNumbers = txNumbers, txBonusBall = bonusBall)
}
