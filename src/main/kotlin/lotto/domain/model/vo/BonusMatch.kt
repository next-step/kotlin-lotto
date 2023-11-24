package lotto.domain.model.vo

@JvmInline
value class BonusMatch constructor(val bonusMatch: Boolean?) {
    companion object {
        fun from(bonusMatch: Boolean): BonusMatch = BonusMatch(bonusMatch)
        fun empty(): BonusMatch = BonusMatch(null)
    }
}
