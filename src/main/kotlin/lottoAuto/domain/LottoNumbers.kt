package lottoAuto.domain

class LottoNumbers(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.size == NUM_OF_LOTTO) { "로또 번호는 ${NUM_OF_LOTTO}개여야 합니다." }
    }

    companion object {
        const val NUM_OF_LOTTO = 6
    }
}
