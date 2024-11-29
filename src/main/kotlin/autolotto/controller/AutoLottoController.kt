package autolotto.controller

import autolotto.dto.LottoResultResponse
import autolotto.entity.Lotto
import autolotto.service.LottoService

class AutoLottoController(private val lottoService: LottoService) {
    fun start(gameCount: Int): List<Lotto> {
        return lottoService.start(gameCount)
    }
    //값 반환시 아예 값을 지정해서 반환하도록
    fun getResult(winnersNumbers: List<Int>, amount: Int): LottoResultResponse {
        return lottoService.getResult(winnersNumbers, amount)
    }
}
