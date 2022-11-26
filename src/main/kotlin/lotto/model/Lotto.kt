package lotto.model

private const val PLUS_MATCH_COUNT = 5

class Lotto(val lottoNumbers: LottoNumbers) {
    fun scratch(winningNumber: LottoNumbers, plusNumber: LottoNumber): LottoGrade {
        val matchCount = lottoNumbers.numbers intersect winningNumber.numbers.toSet()
        val matchPlus = matchCount.size == PLUS_MATCH_COUNT && plusNumber in lottoNumbers.numbers
        return LottoGrade.find(matchCount.size, matchPlus)
    }
}
