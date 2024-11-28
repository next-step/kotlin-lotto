package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE

data class Lotto private constructor(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE) { "로또 번호는 ${SIZE}개여야 합니다." }
    }

    companion object {
        const val SIZE = 6

        fun create(numbers: List<Int>): Lotto {
            val lottoNumbers =
                numbers.map { LottoNumber.from(it) }
                    .sortedBy { it.value }
                    .toSet()
            return Lotto(lottoNumbers)
        }

        fun createWinningLotto(winningLotto: String): Lotto {
            val numbers =
                winningLotto.split(",")
                    .map {
                        LottoNumber.from(
                            it.trim()
                                .toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 문자를 입력했습니다. 입력값 : '$it'"),
                        )
                    }
                    .toSet()
            return Lotto(numbers)
        }

        fun generateAuto(): Lotto {
            val randomNumbers =
                LOTTO_NUMBER_RANGE.shuffled()
                    .take(SIZE)

            return create(randomNumbers)
        }
    }
}
