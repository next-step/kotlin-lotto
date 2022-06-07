package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoNumber

class LottoService {

    fun buy(n: Int): List<Lotto> {
        return (1..n).map { buy() }
    }

    fun createGame(lottos: List<Lotto>, winningLotto: Lotto): LottoGame {
        return LottoGame(lottos, winningLotto)
    }

    private fun buy(): Lotto {
        return Lotto(LottoNumber.numbers.shuffled().take(Lotto.LOTTO_NUMBERS).sortedBy { it.value })
    }
}
