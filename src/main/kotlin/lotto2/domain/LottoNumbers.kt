package lotto2.domain

data class LottoNumbers(private val numbers: List<LottoNumber>) : Collection<LottoNumber> by numbers {
    init {
        validateSize()
        validateDuplicate()
    }

    private fun validateSize() {
        require(numbers.size == MAIN_LOTTO_NUMBERS_COUNT) { "로또 번호는 총 6개여야 합니다." }
    }

    private fun validateDuplicate() {
        require(numbers.size == numbers.toSet().size) { "로또 번호들은 서로 중복될 수 없습니다." }
    }

    fun contains(number: Int): Boolean {
        return numbers.map { it.number }
            .contains(number)
    }

    fun countMatchingNumbers(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers.toSet()).size
    }

    override fun toString(): String {
        return numbers.map { it.number }.toString()
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        const val MAIN_LOTTO_NUMBERS_COUNT = 6
        val FULL_NUMBER_RANGE = (MINIMUM_NUMBER..MAXIMUM_NUMBER).map { LottoNumber(it) }.toList()
    }
}
