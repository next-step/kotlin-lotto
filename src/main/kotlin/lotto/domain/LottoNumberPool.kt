package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import java.util.stream.Collectors

class LottoNumberPool {
    companion object {
        private val numberPool = IntRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .map { it }
            .toList()

        fun getShuffledLottoNumbers(): Set<LottoNumber> {
            return numberPool.shuffled()
                .stream()
                .limit(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT.toLong())
                .sorted()
                .map { LottoNumber(it) }
                .collect(Collectors.toSet())
        }
    }
}
