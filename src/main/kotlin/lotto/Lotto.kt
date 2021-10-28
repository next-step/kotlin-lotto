package lotto

data class Lotto(val lottoNumbers: List<Int> = LottoNumberGenerator().generateNumber(), val price: Int = LOTTO_PRICE) {
    init {
        require(lottoNumbers.size == 6) { "숫자가 6개가 들어와야 합니다." }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
