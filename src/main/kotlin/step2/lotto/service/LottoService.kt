package step2.lotto.service

import step2.lotto.domain.Lotto
import step2.lotto.domain.Lottos
import step2.lotto.domain.PlayInfo
import step2.lotto.domain.PlayResults

class LottoService(private val lottoGenerator: LottoGenerator) {
    fun play(playInfo: PlayInfo): PlayResults {
        val randomLottos = List(playInfo.tryCount) {
            Lotto.of(lottoGenerator.generate())
        }
        return Lottos.of(randomLottos)
            .match(playInfo.winningNumber)
    }
}
