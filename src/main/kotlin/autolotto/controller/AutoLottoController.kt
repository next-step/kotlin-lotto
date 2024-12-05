package autolotto.controller

import autolotto.domain.WinningLottoNumber
import autolotto.entity.Lotto
import autolotto.enums.prize.Prize
import autolotto.service.LottoService

class AutoLottoController(private val lottoService: LottoService) {
    fun start(gameCount: Int): List<Lotto> {
        return lottoService.start(gameCount)
    }

    fun getResult(winningLottoNumber: WinningLottoNumber): Map<Prize, Int> {
        return lottoService.getResult(winningLottoNumber)
    }
}
