package lotto.domain

class LottoNumbers private constructor(
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
        const val NUMBERS_COUNT = 6

        fun createWithSort(values: Set<LottoNumber>): LottoNumbers =
            LottoNumbers(values = values.sortedBy { it.value }.toSet())
    }
}
