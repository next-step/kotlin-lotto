package lotto.model

class Lotto(val lottoNumbers: LottoNumbers) {
    fun scratch(winningNumber: LottoNumbers): LottoGrade {
        val intersect = lottoNumbers.numbers intersect winningNumber.numbers.toSet()
        return LottoGrade.find(intersect.size)
    }
}
