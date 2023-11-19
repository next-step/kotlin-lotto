package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    try {
        val price = Price(readPrice())

        val totalLottoCount = LottoCount(price)
        val lottoManualCount = LottoCount(readManualLottoCount())
        val lottoAutoCount = totalLottoCount - lottoManualCount

        val lottoList = LottoFactory.generateLottoList(lottoAutoCount)
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

