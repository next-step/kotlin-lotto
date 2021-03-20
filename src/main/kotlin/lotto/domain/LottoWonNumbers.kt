package lotto.domain

class LottoWonNumbers(val lottoNumber: Set<LottoNumber>, val bonusNUmber: LottoNumber) {
    init {
        require(lottoNumber.size == 6) { "당첨 로또 번호는 6개여야 합니다" }
        require(!lottoNumber.contains(bonusNUmber)) { "당첨 로또 번호에는 보너스 당첨번호가 존재해서는 안됩니다." }
    }
}
