package lotto.domain

class Lotto(val numbers: List<LottoNumber> = LottoNumbers.getNumbers()) {
    init {
        require(numbers.distinct().size == LottoNumbers.LOTTO_NUMBER_COUNT)
    }

    constructor(text: String) : this(
        text.filter { !it.isWhitespace() }
            .split(TEXT_LOTTO_DELIMITER)
            .map { LottoNumber.from(it.toInt()) }
    )

    companion object {
        val PRICE = Money(1000)
        private const val TEXT_LOTTO_DELIMITER = ","
    }
}
