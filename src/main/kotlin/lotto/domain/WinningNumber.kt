package lotto.domain

import lotto.domain.model.BonusNumber
import lotto.domain.model.WinningNumbers

class WinningNumber(
    val numbers: WinningNumbers,
    val bonusNumber: BonusNumber,
) {
    init {
        require(!numbers.contains(bonusNumber.number)) { "보너스 번호와 당첨번호는 중복될 수 없습니다." }
    }
}
