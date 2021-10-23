package lotto.domain

data class Lotto(private val lottoNumbers: List<LottoNumber>) {

    init {
        require(lottoNumbers.toMutableSet().size == LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(LOTTO_SIZE)
        }
    }

    fun getLottoNumbers(): List<LottoNumber> {
        return lottoNumbers.sorted().toList()
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_SIZE = "로또 번호의 갯수가 올바르지 않습니다"
    }
}
