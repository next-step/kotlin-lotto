package lotto.domain

class Lotto(numbers: List<LottoNumber> = LottoNumbers.getNumbers()) {
    val numbers: List<LottoNumber> = numbers

    constructor(text: String) : this(text.split(",").map { LottoNumber.from(it.toInt()) })

    companion object {
        val PRICE = Money(1000)
    }
}
