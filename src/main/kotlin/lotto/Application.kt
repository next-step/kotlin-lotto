package lotto

import lotto.domain.LottoGame
import lotto.domain.generateLottoList
import lotto.view.*

fun main() {
    val price = readPrice()
    val count = confirmCount(price)
    val lottoList = generateLottoList(count)
    printLottoList(lottoList)

    val winningNumbers = readWinningNumbers()
    val lottoGame = LottoGame(lottoList, winningNumbers)
    val lottoGameResult = lottoGame.getResult()
    printLottoGameResult(lottoGameResult)
}
