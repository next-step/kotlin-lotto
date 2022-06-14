package lotto.domain

class LottoNumbers constructor(
    val values: Set<LottoNumber>,
) {
    init {
        require(this.values.size == NUMBERS_COUNT) {
            "로또의 번호 개수는 $NUMBERS_COUNT 여야 합니다."
        }
    }

    fun matchedNumberCount(other: LottoNumbers): Int {
        return values.intersect(other = other.values)
            .size
    }

    companion object {
        private const val NUMBERS_COUNT = 6

        fun random(): LottoNumbers = LottoNumbers(
            LottoNumber.cachedLottoNumbers()
                .asSequence()
                .shuffled()
                .take(NUMBERS_COUNT)
                .sortedBy { it.value }
                .toSet()
        )
    }
}
