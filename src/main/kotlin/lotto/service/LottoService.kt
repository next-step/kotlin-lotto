package lotto.service

import lotto.domain.Scoreboard
import lotto.domain.Lottos

interface LottoService {
    fun randomLottos(input: String?): Lottos
    fun scoreboard(lottos: Lottos, input: String?): Scoreboard
}
