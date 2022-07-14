package lotto.domain.lotto

import lotto.domain.lottonumber.LottoNumber

class BonusNumber(val bonusNumber: LottoNumber) {
    constructor(number: Int) : this(
        LottoNumber.from(number)
    )
}
