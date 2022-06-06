package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoNumber

class LottoGameService {

    private val lottoNumbers = (1..45).map { LottoNumber.of(it) }

    val lottoGame = LottoGame(lottoNumbers)

    fun buy(n: Int): List<Lotto> {
        return lottoGame.buy(n)
    }
}
