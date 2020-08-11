package lotto.domain

class Lotto(private val lottoNumbers: List<LottoNumber>) {

    init {
        validateSize(lottoNumbers)
        validateDuplication(lottoNumbers)
    }

    fun countOfMatch(winningNumbers: WinningLotto): Int {
        return lottoNumbers.count { winningNumbers.contains(it) }
    }

    fun contains(value: LottoNumber): Boolean {
        return lottoNumbers.contains(value)
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6

        private fun validateSize(numbers: List<LottoNumber>) {
            require(numbers.size == LOTTO_NUMBERS_SIZE) { "Expected size is 6, but was ${numbers.size})" }
        }

        private fun validateDuplication(numbers: List<LottoNumber>) {
            val noDuplicationNumbers = numbers.toSet()
            require(noDuplicationNumbers.size == LOTTO_NUMBERS_SIZE) { "${LOTTO_NUMBERS_SIZE - noDuplicationNumbers.size} duplicate has occurred" }
        }
    }
}
