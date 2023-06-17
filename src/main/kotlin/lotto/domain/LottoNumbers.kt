package lotto.domain

@JvmInline
value class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {

    init {
        val distinctLottoNumbers = lottoNumbers.distinct()
        require(distinctLottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "로또 번호 $LOTTO_NUMBER_SIZE 개는 중복이 없어야 합니다."
        }

        lottoNumbers.sortedBy { it.number }
    }
    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
