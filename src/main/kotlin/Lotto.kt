
class Lotto(lottoNumbers: List<LottoNumber>) {
    val lottoNumbers: List<LottoNumber>

    init {
        require(lottoNumbers.size == LOTTO_SIZE)
        hasNoDuplicatedNumbers(lottoNumbers)

        this.lottoNumbers = lottoNumbers.sortedBy { it.number }
    }

    private fun hasNoDuplicatedNumbers(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.toSet().size == LOTTO_SIZE)
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}

data class LottoNumber(val number: Int) {
    init {
        require(MIN_LOTTO_NUMBER <= number)
        require(number <= MAX_LOTTO_NUMBER)
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
