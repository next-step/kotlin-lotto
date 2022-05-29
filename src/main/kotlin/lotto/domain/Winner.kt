package lotto.domain

class Winner(val lottoNumbers: List<LottoNumber>, val bonusNumber: LottoNumber) {
    init {
        require(lottoNumbers.size == Lotto.LOTTO_NUMBER_COUNT)
    }
}
