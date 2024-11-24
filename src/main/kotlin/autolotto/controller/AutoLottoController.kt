package autolotto.controller

import autolotto.entity.Lotto
import autolotto.service.LottoService

class AutoLottoController(private val lottoService: LottoService) {
    fun start(gameCount: Int): List<Lotto> {
        return lottoService.start(gameCount)
    }

    fun getWinnerInfo(winnersNumbers: List<Int>): Map<Int, Int> {
        return lottoService.getWinnerInfo(winnersNumbers)
    }
}
