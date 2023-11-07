package lotto.domain

class WinningNumbers(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == Lotto.NUMBER_COUNT) { "Winning numbers should be ${Lotto.NUMBER_COUNT} numbers." }
    }
}
