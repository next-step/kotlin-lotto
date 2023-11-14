package lotto.domain

class Lotto(numbers: List<LottoNumber>) {
    private val lottoNumbers: List<LottoNumber> = numbers.sortedBy { it.number }

    init {
        require(numbers.size == 6) { INIT_ERROR_MESSAGE }
    }

    fun getSize(): Int {
        return lottoNumbers.size
    }

    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers
    }

    companion object {
        private const val INIT_ERROR_MESSAGE: String = "로또 번호는 6개여야 합니다."
    }
}
