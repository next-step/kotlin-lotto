package lotto.domain

class LottoWonNumbers(val lottoNumber: Set<LottoNumber>, val bonusNumber: LottoNumber) {
    init {
        require(lottoNumber.size == 6) { "당첨 로또 번호는 6개여야 합니다" }
        require(!lottoNumber.contains(bonusNumber)) { "당첨 로또 번호에는 보너스 당첨번호가 존재해서는 안됩니다." }
    }

    constructor(lottoNumber: Set<Int>, bonusNumber: Int) : this(
        lottoNumber.map(::LottoNumber).toSet(),
        LottoNumber(bonusNumber)
    )
}
