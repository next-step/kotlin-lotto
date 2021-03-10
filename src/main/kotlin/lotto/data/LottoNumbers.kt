package lotto.data

data class LottoNumbers(
    val lottoNumbers: List<Int>
) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
    }

    fun findMatchCount(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.count { otherNumbers.contains(it) }
    }

    private fun contains(number: Int): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
