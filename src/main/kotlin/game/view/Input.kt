package game.view

import game.domain.purchase.PurchaseMoney
import game.domain.result.WinningNumber

interface Input {
    fun askLottoPurchaseMoney(): PurchaseMoney
    fun askWinningNumber(): WinningNumber
}
