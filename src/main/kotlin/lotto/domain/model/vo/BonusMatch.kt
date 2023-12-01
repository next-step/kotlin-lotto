package lotto.domain.model.vo

@JvmInline
value class BonusMatch(val value: Boolean) {
    companion object {
        fun from(bonusMatch: Boolean): BonusMatch = BonusMatch(bonusMatch)
    }
}
