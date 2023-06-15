package lotto.domain

class Lotto(numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {
    val lottoNumbers = numbers.sortedBy(LottoNumber::number).toSet()

    init {
        require(lottoNumbers.size == VALID_LENGTH) {
            "Require number size: $VALID_LENGTH, Input: $lottoNumbers"
        }
    }

    companion object {
        val PRICE = Money(1_000)
        const val VALID_LENGTH = 6
    }
}
