package lotto.domain

class Lotto(numbers: List<LottoNumber> = LottoNumbers.getNumbers()) {
    val numbers: List<LottoNumber> = numbers

    companion object {
        val PRICE = Money(1000)
    }
}
