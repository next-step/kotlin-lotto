package lotto.service

import lotto.domain.Lottos
import lotto.domain.Scoreboard

interface LottoService {
    fun randomLottos(input: String?): Lottos
    fun scoreboard(lottos: Lottos, input: String?): Scoreboard
}
