package lotto.domain

import lotto.domain.lotto.LottoNumber
import lotto.utils.Validation

class WinningNumber(numberOfLastWeek: String) {

    var winnerNumber: Lotto
        private set

    init {
        require(Validation.isNotBlank(numberOfLastWeek)) { "공백 값이 들어왔습니다." }

        val number = numberOfLastWeek.split(",")
            .map { it.trim() }
        require(Validation.isSameNumberOfArraysAndReferenceValue(number.size, 6)) { "당첨번호의 수가 적거나 많습니다." }

        number.forEach {
            require(Validation.isNumeric(it)) { "숫자이외의 값이 입력되었습니다." }
            require(Validation.isWithInRange(it, 1..45)) { "범위를 벗어난 숫자입니다." }
        }

        winnerNumber = stringArrayToLotto(number)
    }

    private fun stringArrayToLotto(numbers: List<String>) =
        Lotto(numbers.map { LottoNumber(it.toInt()) })
}
