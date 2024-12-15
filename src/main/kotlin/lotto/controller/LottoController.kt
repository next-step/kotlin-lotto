package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import lotto.entity.Lotto
import lotto.enums.prize.Prize
import lotto.service.LottoService

class LottoController(private val lottoService: LottoService) {
    fun start(
        amount: Amount,
        lottoManualNumbers: List<LottoNumber>,
    ): Lotto {
        return lottoService.start(amount, lottoManualNumbers)
    }

    fun getResult(winningLottoNumber: WinningLottoNumber): Map<Prize, Int> {
        return lottoService.getResult(winningLottoNumber)
    }
}
