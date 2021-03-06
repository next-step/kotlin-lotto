package lotto.model

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) {"로또 번호는 6개여야만 합니다."}
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
