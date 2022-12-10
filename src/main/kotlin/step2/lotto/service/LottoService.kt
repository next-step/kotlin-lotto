package step2.lotto.service

import step2.lotto.domain.Lotto
import step2.lotto.domain.Lottos
import step2.lotto.domain.MatchResults
import step2.lotto.domain.PlayInfo

class LottoService(private val lottoGenerator: LottoGenerator) {
    fun play(playInfo: PlayInfo): MatchResults {
        val randomLottos = List(playInfo.tryCount) {
            Lotto.of(lottoGenerator.generate())
        }
        return Lottos.of(randomLottos).match(playInfo.winningNumber)
    }
}
