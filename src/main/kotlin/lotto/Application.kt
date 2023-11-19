package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    try {
        val inputPrice = readPrice()
        val price = Price(inputPrice)

        val inputLottoManualCount = readManualLottoCount()
        val lottoManualCount = LottoCount(inputLottoManualCount)

        val count = confirmCount(price)
        val lottoList = LottoFactory.generateLottoList(count)
        printLottoList(lottoList)

        val winningNumbers = WinningNumbers(
            LottoNumbers(readWinningNumbers().map { LottoNumber(it) }.toSet()),
            LottoNumber(readBonusNumber())
        )
        val lottoGame = LottoGame(lottoList)
        val lottoGameResult = lottoGame.getResult(winningNumbers)
        printLottoGameResult(lottoGameResult)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

