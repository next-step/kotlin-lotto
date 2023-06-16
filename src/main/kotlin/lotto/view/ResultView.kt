package lotto.view

import lotto.LottoGame
import lotto.LottoNumbers

object ResultView {
    fun printAllLottoNumbers(lottoGame: LottoGame) {
        lottoGame.lottoNumbers.forEach { printLottoNumbers(it) }
    }

    private fun printLottoNumbers(lottoNumbers: LottoNumbers) {
        println("[${lottoNumbers.numbers.map { it.number }.joinToString(", ")}]")
    }
}