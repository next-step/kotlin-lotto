package lotto.domain

class Lotto(val lottoNumbers: LinkedHashSet<LottoNumber>) {

    operator fun contains(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

    init {
        require(lottoNumbers.size == VALID_LENGTH) {
            "Require number size: $VALID_LENGTH, Input: $lottoNumbers"
        }

        val sortedNumbers = lottoNumbers.sortedBy(LottoNumber::number)

        lottoNumbers.clear()
        lottoNumbers.addAll(sortedNumbers)
    }

    companion object {
        val PRICE = Money(1_000)
        const val VALID_LENGTH = 6
    }
}
