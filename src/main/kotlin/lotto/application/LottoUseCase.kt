package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResult

interface LottoUseCase {
    fun buy(price: Int): List<Lotto>
    fun matchWinningLotto(command: MatchWinningLottoCommand): List<LottoResult>
    fun calculateProfitRate(lottos: List<LottoResult>): Double
}