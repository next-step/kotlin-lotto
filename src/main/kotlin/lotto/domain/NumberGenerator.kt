package lotto.domain

interface NumberGenerator {
    fun generateLottoFromNumbers(
        possibleNumbers: List<LottoNumber>
    ): Lotto
}
