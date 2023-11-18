package lotto.model

import lotto.model.strategy.LottoNumberStrategy

data class Game(
    val lottoNumbers: LottoNumbers,
) {
    companion object {
        fun of(strategy: LottoNumberStrategy): Game {
            return Game(LottoNumbers(strategy))
        }
    }
}
