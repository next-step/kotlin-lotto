package lotto.business

data class LottoWinningNumbers(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { "서로 다른 6개 로또 번호 이여야 합니다." }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
