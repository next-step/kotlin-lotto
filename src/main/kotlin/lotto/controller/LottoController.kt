package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import lotto.entity.Lotto

class LottoController(private val lottoGame: LottoGame) {
    fun start(
        amount: Amount,
        lottoManualNumbers: MutableList<LottoNumber>,
    ): Lotto = lottoGame.start(amount, lottoManualNumbers)

    fun getLottoGameResult(
        lottoGameResult: Lotto,
        winnerNumbers: WinningLottoNumber,
    ): LottoGameResult = lottoGame.getLottoGameResult(lottoGameResult, winnerNumbers)
}
