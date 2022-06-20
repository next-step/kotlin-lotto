package lotto.domain

import java.math.BigDecimal

class LottoTicket constructor(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {
    init {
        require(lottoNumbers.notContain(bonusNumber)) {
            "보너스 번호는 당첨 번호들과 중복될 수 없습니다."
        }
    }

    companion object {
        val PRICE: Money = Money(BigDecimal.valueOf(1_000))
    }
}
