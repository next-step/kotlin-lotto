package lotto.view.input

import lotto.domain.LottoNumber

data class BonusInput(val bonusNumber: LottoNumber) {

    constructor(input: String) : this(input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자야여 합니다."))
    constructor(input: Int) : this(LottoNumber.from(input))
}
