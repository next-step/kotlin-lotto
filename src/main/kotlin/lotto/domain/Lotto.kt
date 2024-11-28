package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE

data class Lotto private constructor(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE) { "로또 번호는 ${SIZE}개여야 합니다." }
        require(numbers.distinct().size == SIZE) { "로또 번호는 중복될 수 없습니다." }
    }

    companion object {
        const val SIZE = 6

        fun create(numbers: List<Int>): Lotto {
            val lottoNumbers =
                numbers.map { LottoNumber.from(it) }
                    .toSet()
            return Lotto(lottoNumbers)
        }

        fun generateAuto(): Lotto {
            val randomNumbers =
                LOTTO_NUMBER_RANGE.shuffled()
                    .take(SIZE)

            return create(randomNumbers)
        }
    }
}
