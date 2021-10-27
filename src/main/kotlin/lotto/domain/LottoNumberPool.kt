package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import java.util.stream.Collectors

class LottoNumberPool {
    companion object {
        private val numberPool = IntRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .map { LottoNumber(it) }
            .toList()

        operator fun get(index: Int): LottoNumber = numberPool[index - 1]

        fun getShuffledLottoNumbers(): Set<LottoNumber> {
            return numberPool.shuffled()
                .stream()
                .limit(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT.toLong())
                .sorted(Comparator.comparing { it.value })
                .collect(Collectors.toSet())
        }
    }
}
