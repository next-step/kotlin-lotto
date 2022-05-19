package stringaddcalculator.lotto

class Lotto(
    _numbers: Collection<LottoNumber>
) {
    val numbers: Set<LottoNumber> = _numbers.toSortedSet()

    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS) { "로또 번호의 개수는 반드시 $SIZE_OF_LOTTO_NUMBERS 개 이어야 합니다" }
    }

    fun getMatchingNumbers(other: Lotto): Int {
        return numbers.intersect(other.numbers).size
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6
    }
}
