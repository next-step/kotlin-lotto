package lotto.domain

class WinningNumbers(winningNumbersText: String) {
    private val winningNumbers: Set<LottoNumber>

    init {
        winningNumbers = winningNumbersText.split(TEXT_WINNING_NUMBERS_DELIMITER)
            .map { LottoNumber.from(it.toInt()) }
            .toSet()
        require(winningNumbers.size == LottoNumbers.LOTTO_NUMBER_COUNT)
    }

    fun rank(lotto: Lotto): Rank {
        return Rank.from(lotto.numbers.count {
            winningNumbers.contains(it)
        })
    }

    companion object {
        private const val TEXT_WINNING_NUMBERS_DELIMITER = ","
    }
}
