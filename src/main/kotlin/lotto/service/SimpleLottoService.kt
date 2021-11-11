package lotto.service

import lotto.domain.*

class SimpleLottoService: LottoService {
    override fun randomLottos(input: String?): Lottos = Lottos.from(Money.of(input))

    override fun scoreboard(lottos: Lottos, input: String?): Scoreboard {
        val winningLotto = Lotto.of(input)
        return Scoreboard.of(lottos, winningLotto)
    }
}
