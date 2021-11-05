package domain.lotto.service

import domain.lotto.domain.Lottos
import domain.lotto.domain.MatchResult
import domain.lotto.domain.WinningLotto
import domain.lotto.strategy.LottoShuffleStrategy

object LottoService {
    fun automaticallyGenerateLottos(lottoGenerateCount: Int, shuffleStrategy: LottoShuffleStrategy) =
        Lottos.from(lottoGenerateCount, shuffleStrategy)

    fun match(lottos: Lottos, winningLotto: WinningLotto): MatchResult =
        MatchResult.of(lottos.match(winningLotto))
}
