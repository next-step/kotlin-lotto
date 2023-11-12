package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val price = readPrice()
    val count = confirmCount(price)
    val lottoList = LottoFactory.generateLottoList(count)
    printLottoList(lottoList)

    val winningNumbers = WinningNumbers(LottoNumbers(readWinningNumbers()), BonusNumber(readBonusNumber()))
    val lottoGame = LottoGame(lottoList)
    val lottoGameResult = lottoGame.getResult(winningNumbers)
    printLottoGameResult(lottoGameResult)
}
