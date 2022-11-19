package lotto.model

import lotto.model.LottoNumberValidator.validNumber


class Lotto(val number: List<Int>) {
    init {
        validNumber(number)
    }


    fun scratch(winningNumber: List<Int>): LottoGrade {
        val intersect = number intersect winningNumber.toSet()
        return LottoGrade.find(intersect.size)
    }
}
