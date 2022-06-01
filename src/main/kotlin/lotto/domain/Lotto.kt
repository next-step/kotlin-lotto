package lotto.domain

class Lotto private constructor(
    val lottoNumbers: Set<LottoNumber>,
) {
    init {
        require(this.lottoNumbers.size == NUMBERS_COUNT) {
            "로또의 번호 개수는 $NUMBERS_COUNT 여야 합니다."
        }
    }

    companion object {
        private const val NUMBERS_COUNT = 6

        fun autoCreate(): Lotto {
            return Lotto(
                LottoNumber.lottoNumbers()
                    .asSequence()
                    .shuffled()
                    .take(NUMBERS_COUNT)
                    .sortedBy { it.value }
                    .toSet()
            )
        }
    }
}
