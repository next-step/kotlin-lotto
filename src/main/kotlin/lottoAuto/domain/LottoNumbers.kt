package lottoAuto.domain

class LottoNumbers(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.size == NUM_OF_LOTTO_NUMBERS) { "로또 번호는 ${NUM_OF_LOTTO_NUMBERS}개여야 합니다." }
    }

    fun getSortedLottoNumbers(): List<LottoNumber> {
        return numbers.sortedBy { it.number }
    }

    fun matchCount(numbers: List<LottoNumber>): Int {
        return this.numbers.intersect(numbers.toSet()).size
    }

    companion object {
        const val NUM_OF_LOTTO_NUMBERS = 6
    }
}
