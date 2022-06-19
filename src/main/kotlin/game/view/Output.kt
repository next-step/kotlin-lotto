package game.view

import game.domain.lotto.Lotto
import game.domain.result.LottoResult

interface Output {
    fun printPurchaseList(lotto: Lotto)

    fun printStatistics(result: LottoResult)
}
