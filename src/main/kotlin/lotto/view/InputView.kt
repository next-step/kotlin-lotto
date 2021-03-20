package lotto.view

import lotto.supportdata.PurchaseInfo
import lotto.supportdata.WinLottoInfo

object InputView {
    private tailrec fun purchaseMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: purchaseMoney()
    }

    private tailrec fun purchaseManualNumber(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: purchaseManualNumber()
    }

    private fun purchaseManualTickets(number: Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(number) { readLine() ?: "" }
    }

    private tailrec fun winNumbers(): String {
        println("지난주 당첨 번호를 입력해주세요")
        return readLine() ?: winNumbers()
    }

    private tailrec fun bonusBall(): Int {
        println("보너스 볼을 입력해주세요")
        return readLine()?.toIntOrNull() ?: bonusBall()
    }

    fun makePurchaseInfo(): PurchaseInfo {
        val purchaseMoney = purchaseMoney()
        val manualNumber = purchaseManualNumber()
        val purchaseManualTickets = purchaseManualTickets(manualNumber)
        return PurchaseInfo(purchaseMoney, purchaseManualTickets)
    }

    fun makeWinLottoInfo(): WinLottoInfo {
        val winNumber = winNumbers()
        val bonusBall = bonusBall()
        return WinLottoInfo(winNumber, bonusBall)
    }
}
