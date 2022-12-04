package lotto.domain

import lotto.domain.lotto.LottoNumber
import lotto.utils.Validation

class BonusNumber(bonusNumberOfLastWeek: String, winnerNumber: WinningNumber) {

    var bonusNumber: LottoNumber
        private set

    init {
        require(Validation.isNotBlank(bonusNumberOfLastWeek)) { "공백 값이 들어왔습니다." }
        require(Validation.isNumeric(bonusNumberOfLastWeek)) { "보너스 번호가 숫자이외의 값이 입력되었습니다." }

        val bonusNumberToInt = LottoNumber(bonusNumberOfLastWeek.toInt())
        require(!winnerNumber.winnerNumber.numbers.contains(bonusNumberToInt)) { "보너스 번호가 지난 주 당첨번호에 포함되어 있습니다." }
        require(Validation.isWithInRange(bonusNumberOfLastWeek.toInt(), 1..45)) { "보너스 번호가 범위를 벗어난 숫자입니다." }

        bonusNumber = bonusNumberToInt
    }
}
