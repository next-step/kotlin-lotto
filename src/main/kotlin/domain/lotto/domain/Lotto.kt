package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberSizeException
import domain.lotto.strategy.LottoShuffleStrategy
import global.strategy.split.SplitStrategy

@JvmInline
value class Lotto private constructor(val lotto: Set<LottoNumber>) {

    fun match(other: Lotto): Int = other.lotto.count { lotto.contains(it) }

    fun contains(bonusBall: LottoNumber): Boolean = lotto.contains(bonusBall)

    companion object {
        const val PRICE = 1_000
        const val MINIMUM_SIZE = 0
        const val MAXIMUM_SIZE = 6

        fun of(shuffleStrategy: LottoShuffleStrategy): Lotto {
            val lottoNumbers = LottoNumber.values()
            val shuffledLottoNumbers = shuffleStrategy.shuffle(lottoNumbers)
            val selectedLottoNumbers = shuffledLottoNumbers.subList(MINIMUM_SIZE, MAXIMUM_SIZE)
            return of(selectedLottoNumbers.toSortedSet())
        }

        fun of(lotto: String, splitStrategy: SplitStrategy): Lotto =
            of(
                splitStrategy.split(lotto)
                    .map { LottoNumber.of(it.toInt()) }
                    .toSortedSet()
            )

        fun of(lotto: Set<LottoNumber>): Lotto {
            if ((MAXIMUM_SIZE..MAXIMUM_SIZE).contains(lotto.size)) {
                return Lotto(lotto.toSortedSet())
            }
            throw InvalidLottoNumberSizeException(lotto.size)
        }
    }
}
