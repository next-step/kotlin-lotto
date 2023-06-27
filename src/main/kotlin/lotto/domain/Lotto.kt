package lotto.domain

class Lotto(lottoNumbers: List<LottoNumber>) : Iterable<LottoNumber> {

    private val numbers: List<LottoNumber>

    init {
        require(lottoNumbers.size == 6) { "서로 다른 6개의 숫자를 입력해야 합니다." }
        require(lottoNumbers.distinct().size == 6) { "서로 다른 6개의 숫자를 입력해야 합니다." }
        numbers = lottoNumbers.sorted()
    }

    fun matchCount(other: Lotto): Int {
        val difference = this.numbers - other.numbers.toSet()
        return MAX_MATCH_COUNT - difference.size
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    override fun iterator(): Iterator<LottoNumber> {
        return numbers.iterator()
    }

    companion object {
        private const val MAX_MATCH_COUNT = 6
        fun of(lottoNumbers: List<Int>) = Lotto(lottoNumbers.map { LottoNumber.of(it) })
    }
}
