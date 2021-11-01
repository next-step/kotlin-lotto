package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberSizeException
import domain.lotto.strategy.LottoShuffleStrategy
import global.strategy.split.SplitStrategy

@JvmInline
value class Lotto private constructor(val lotto: Set<LottoNumber>) {

    fun match(other: Lotto): Int = other.lotto.count { lotto.contains(it) }

    companion object {
        const val PRICE = 1_000
        private const val FROM_INDEX = 0
        private const val TO_INDEX = 6

        fun of(shuffleStrategy: LottoShuffleStrategy): Lotto {
            val lottoNumbers = LottoNumber.values()
            val shuffledLottoNumbers = shuffleStrategy.shuffle(lottoNumbers)
            val selectedLottoNumbers = shuffledLottoNumbers.subList(FROM_INDEX, TO_INDEX)
            return of(selectedLottoNumbers.toSortedSet())
        }

        fun of(lotto: String, splitStrategy: SplitStrategy): Lotto =
            of(
                splitStrategy.split(lotto)
                    .map { LottoNumber.of(it.toInt()) }
                    .toSortedSet()
            )

        fun of(lotto: Set<LottoNumber>): Lotto {
            if (lotto.size < TO_INDEX || lotto.size > TO_INDEX) {
                throw InvalidLottoNumberSizeException(lotto.size)
            }
            return Lotto(lotto.toSortedSet())
        }
    }
}
