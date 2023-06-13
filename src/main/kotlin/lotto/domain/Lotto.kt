package lotto.domain

class Lotto(val lottoNumbers: LinkedHashSet<LottoNumber>) {

    operator fun contains(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

    init {
        require(lottoNumbers.size == VALID_LENGTH) {
            "Require number size: $VALID_LENGTH, Input: $lottoNumbers"
        }

        if (!isSorted(lottoNumbers)) {
            val sortedNumbers = lottoNumbers.sortedBy { it.number }

            lottoNumbers.clear()
            lottoNumbers.addAll(sortedNumbers)
        }
    }

    private fun isSorted(lottoNumbers: LinkedHashSet<LottoNumber>): Boolean = lottoNumbers.toList().isSorted()

    private fun List<LottoNumber>.isSorted(): Boolean = this == sorted()

    companion object {
        val PRICE = Money(1_000)
        const val VALID_LENGTH = 6
    }
}
