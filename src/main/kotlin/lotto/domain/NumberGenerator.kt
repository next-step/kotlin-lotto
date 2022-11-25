package lotto.domain

interface NumberGenerator {
    fun generateLottoNumbers(
        possibleNumbers: List<LottoNumber>,
        numberCount: Int
    ): List<LottoNumber>
}
