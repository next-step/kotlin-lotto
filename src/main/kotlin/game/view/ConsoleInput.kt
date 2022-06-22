package game.view

import game.domain.lotto.LottoNumber
import game.domain.lotto.LottoTicket
import game.domain.purchase.PurchaseMoney
import game.domain.result.WinningNumber

class ConsoleInput : Input {
    override fun askLottoPurchaseMoney(): PurchaseMoney {
        return try {
            println("구입 금액을 입력해주세요.")
            PurchaseMoney(readln().toLong())
        } catch (e: RuntimeException) {
            println(e.message)
            askLottoPurchaseMoney()
        }
    }

    override fun askWinningNumber(): WinningNumber {
        return try {
            println("지난주 당첨 번호를 입력해주세요")
            val numbers = readln().split(",").map { it.trim().toInt() }
            println("보너스 볼을 입력해주세요")
            val bonusBall = LottoNumber.from(readln().trim().toInt())
            WinningNumber(LottoTicket.from(numbers), bonusBall)
        } catch (e: RuntimeException) {
            println(e.message)
            askWinningNumber()
        }
    }
}
