package lotto.controller

import lotto.domain.*
import lotto.entity.Lotto

class LottoController(private val lottoGame: LottoGame) {
    fun start(amount: Amount, lottoManualNumbers: MutableList<LottoNumber>): Lotto = lottoGame.start(amount, lottoManualNumbers)
    fun getLottoGameResult(
        lottoGameResult: Lotto,
        winnerNumbers: WinningLottoNumber
    ): LottoGameResult = lottoGame.getLottoGameResult(lottoGameResult, winnerNumbers)
}
