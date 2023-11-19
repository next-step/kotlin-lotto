package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResultMap
import lotto.domain.ProfitRate

interface LottoUseCase {
    fun buy(price: Int): List<Lotto>
    fun matchWinningLotto(command: MatchWinningLottoCommand): LottoResultMap
    fun calculateProfitRate(lottoResultMap: LottoResultMap): ProfitRate
}
