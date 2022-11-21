package lotto.model

class Lotto constructor(val lottoNumber: LottoNumber) {
    fun scratch(winningNumber: LottoNumber): LottoGrade {
        winningNumber.number
        val intersect = lottoNumber.number intersect winningNumber.number.toSet()
        return LottoGrade.find(intersect.size)
    }
}
