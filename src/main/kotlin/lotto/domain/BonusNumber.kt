package lotto.domain

@JvmInline
value class BonusNumber(val value: Int) {
    init {
        LottoRule.validate(value)
    }
}
