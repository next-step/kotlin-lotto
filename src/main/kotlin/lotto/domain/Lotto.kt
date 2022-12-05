package lotto.domain

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { "로또는 6개의 숫자로 구성되어야 합니다." }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
