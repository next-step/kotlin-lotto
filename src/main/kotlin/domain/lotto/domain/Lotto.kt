package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberSizeException
import domain.lotto.strategy.LottoShuffleStrategy

@JvmInline
value class Lotto private constructor(private val lotto: Set<LottoNumber>) {

    companion object {
        const val PRICE = 1_000
        private const val FROM_INDEX = 0
        private const val TO_INDEX = 6

        fun of(strategy: LottoShuffleStrategy): Lotto {
            val lottoNumbers = LottoNumber.values()
            val shuffledLottoNumbers = strategy.shuffle(lottoNumbers)
            val selectedLottoNumbers = shuffledLottoNumbers.subList(FROM_INDEX, TO_INDEX)
            return of(selectedLottoNumbers.toSortedSet())
        }

        fun of(lotto: Set<LottoNumber>): Lotto =
            if (lotto.size == TO_INDEX) Lotto(lotto.toSortedSet())
            else throw InvalidLottoNumberSizeException(lotto.size)
    }
}
