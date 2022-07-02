package lotto.domain.lottoticket

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

    operator fun contains(lottoNumber: LottoNumber): Boolean = values.contains(lottoNumber)

    fun notContains(lottoNumber: LottoNumber): Boolean = !contains(lottoNumber)

    companion object {
        const val NUMBERS_COUNT = 6

        fun createWithSortByNumbersList(numbersList: List<List<Int>>): List<LottoNumbers> =
            numbersList.map { numbers -> createWithSort(values = numbers.map { LottoNumber.from(value = it) }.toSet()) }

        fun createWithSort(values: Set<LottoNumber>): LottoNumbers =
            LottoNumbers(values = values.sortedBy { it.value }.toSet())
    }
}
