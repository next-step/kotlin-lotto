package lotto.controller

import lotto.domain.WinningLottoNumber
import lotto.entity.Lotto
import lotto.enums.prize.Prize
import lotto.service.LottoService

class LottoController(private val lottoService: LottoService) {
    fun start(gameCount: Int): List<Lotto> {
        return lottoService.start(gameCount)
    }

    fun getResult(winningLottoNumber: WinningLottoNumber): Map<Prize, Int> {
        return lottoService.getResult(winningLottoNumber)
    }
}
