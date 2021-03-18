package lotto.domain

class LottoWonNumbers(val lottoNumber: Set<LottoNumber>, val bonusNUmber: LottoNumber) {
    init {
        require(lottoNumber.size >= 6)
        require(!lottoNumber.contains(bonusNUmber))
    }
}
