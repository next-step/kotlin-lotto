package lotto

class Lotto(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.toSet().size == NUMBER_COUNT) { ERROR_COUNT }
    }

    companion object {
        private const val NUMBER_COUNT = 6
        private const val ERROR_COUNT = "Lotto should have only 6 numbers"
    }
}
