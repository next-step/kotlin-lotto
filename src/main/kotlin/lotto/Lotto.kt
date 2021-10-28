package lotto

data class Lotto(val lottoNumbers: List<Int> = LottoNumberGenerator().generateNumber(), val price: Int = LOTTO_PRICE) {
    init {
        val size = lottoNumbers.size
        require(size == 6) { "숫자가 6개가 들어와야 합니다." }
        require(lottoNumbers.distinct().size == size) { "중복 된 숫자는 들어올 수 없습니다." }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
