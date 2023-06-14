package lotto.domain

class Lotto(numbers: Set<LottoNumber>) {
    val lottoNumbers = numbers.sortedBy(LottoNumber::number).toSet()

    operator fun contains(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

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
