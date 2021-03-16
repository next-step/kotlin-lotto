package lotto.domain

class LottoWonNumber(val lottoNumber: Set<LottoNumber>) {
    init {
        require(lottoNumber.size >= 6)
    }
}
