package lotto

class Lotto(numbers: List<LottoNumber>) {
    val lottoNumbers: List<LottoNumber> = numbers.map { it.copy() }.sortedBy { it.getNumber() }

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
