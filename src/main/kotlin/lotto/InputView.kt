package lotto

import lotto.store.PurchaseRequest
import lotto.ticket.WinningTicket

fun inputPrice(): PurchaseRequest {
    println("구매금액을 입력해주세요.")

    return PurchaseRequest.ofTxAmount(readLine()!!)
}

fun inputWinningTicket(): WinningTicket {

    println("지난 주 당첨 번호를 입력해 주세요.")
    val txNumbers = readLine()!!

    println("보너스 볼을 입력해 주세요.")
    val bonusBall = readLine()!!

    return WinningTicket.ofTxNumbers(txNumbers = txNumbers, txBonusBall = bonusBall)
}
