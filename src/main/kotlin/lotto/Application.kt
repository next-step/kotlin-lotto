package lotto

import lotto.domain.LottoFactory
import lotto.domain.LottoGame
import lotto.domain.LottoNumbers
import lotto.view.*

fun main() {
    val price = readPrice()
    val count = confirmCount(price)
    val lottoList = LottoFactory.generateLottoList(count)
    printLottoList(lottoList)

    val winningNumbers = LottoNumbers(readWinningNumbers())
    val lottoGame = LottoGame(lottoList, winningNumbers)
    val lottoGameResult = lottoGame.getResult()
    printLottoGameResult(lottoGameResult)
}
