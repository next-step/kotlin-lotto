package domain.lotto.service

import domain.lotto.domain.Lotto
import domain.lotto.domain.Lottos
import domain.lotto.domain.MatchResult
import domain.lotto.domain.Money
import domain.lotto.strategy.LottoShuffleStrategy

object LottoService {
    fun lottos(money: Money, shuffleStrategy: LottoShuffleStrategy) =
        Lottos.from(money.numberOfPurchases(Lotto.PRICE), shuffleStrategy)

    fun match(lottos: Lottos, winningLotto: Lotto): MatchResult =
        MatchResult.of(lottos.match(winningLotto))
}
