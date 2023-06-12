package lotto.domain

class WinningNumbers(val values: LinkedHashSet<LottoNumber>) : Set<LottoNumber> by values {
    init {
        require(values.size == VALID_LENGTH) {
            "Require number size: ${Lotto.VALID_LENGTH}, Input: $values"
        }
    }

    fun matches(lotto: Lotto): Rank = values.count { it in lotto }
        .run(Rank::valueOf)

    companion object {
        const val VALID_LENGTH = 6
    }
}
