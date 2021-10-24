package lotto.domain

data class Lotto(private val lottoNumbers: List<LottoNumber>) {

    init {
        require(lottoNumbers.toSet().size == LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(LOTTO_SIZE)
        }
    }

    fun getLottoNumbers(): List<LottoNumber> {
        return lottoNumbers.sorted().toList()
    }

    fun countMatchedNumbers(lotto: Lotto): Int {
        val matched = lottoNumbers.intersect(lotto.lottoNumbers)
        return matched.size
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_SIZE = "로또 번호의 갯수가 올바르지 않습니다"
    }
}
