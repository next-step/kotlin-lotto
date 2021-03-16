package lotto.view

import lotto.supportdata.PurchaseInfo
import lotto.supportdata.WinLottoInfo
import java.lang.IllegalArgumentException

object InputView {
    private tailrec fun purchase(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: purchase()
    }

    private tailrec fun winNumbers(): String {
        println("지난주 당첨 번호를 입력해주세요")
        return readLine() ?: winNumbers()
    }

    private tailrec fun bonusBall(): Int {
        println("보너스 볼을 입력해주세요")
        return readLine()?.toIntOrNull() ?: bonusBall()
    }

    fun makePurchaseInfo(): PurchaseInfo = PurchaseInfo(purchase())

    fun makeWinLottoInfo(): WinLottoInfo {
        val winNumber = winNumbers()
        val bonusBall = bonusBall()
        return try {
            WinLottoInfo(winNumber, bonusBall)
        } catch (e: IllegalArgumentException) {
            println("다시 입력해주세요 \nㄴ사유 : ${e.message} \n")
            makeWinLottoInfo()
        }
    }
}
