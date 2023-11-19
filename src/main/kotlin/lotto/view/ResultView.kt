package lotto.view

import lotto.adapter.LottoDto
import lotto.adapter.LottoResultDto
import lotto.adapter.ProfitRateDto

interface ResultView {
    fun printBoughtLotto(lottos: List<LottoDto>)
    fun printLottoResults(results: List<LottoResultDto>)
    fun printProfitRate(profitRate: ProfitRateDto)
}
