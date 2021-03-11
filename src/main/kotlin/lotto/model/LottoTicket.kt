package lotto.model

data class LottoTicket(val numbers: LottoNumbers = LottoNumbers.autoCreate()) {

    constructor(numbers: List<Int>) : this(LottoNumbers(numbers))

    fun countMatch(winningNumbers: WinningNumbers): Int {
        return winningNumbers.count {
            numbers.contains(it)
        }
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}
