package lotto.domain

class ManualNumberGenerator : NumberGenerator {
    override fun generateLottoNumbers(possibleNumbers: List<LottoNumber>, numberCount: Int): List<LottoNumber> {
        return possibleNumbers
            .subList(0, numberCount)
            .sortedBy { it.number }
    }
}
