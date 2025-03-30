package lotto

class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.toSet().size == NUMBER_COUNT) { ERROR_COUNT }
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        private const val NUMBER_COUNT = 6
        private const val ERROR_COUNT = "Lotto should have only 6 numbers"
    }
}
