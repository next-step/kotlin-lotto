package lotto.model

import lotto.model.strategy.LottoNumberStrategy

@JvmInline
value class Game(
    val lottoNumbers: LottoNumbers,
) {
    companion object {
        fun of(strategy: LottoNumberStrategy): Game {
            return Game(LottoNumbers(strategy))
        }
    }
}
