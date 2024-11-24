package lotto.domain

@JvmInline
value class BonusNumber private constructor(val value: Int) {
    init {
        LottoRule.validate(value)
    }

    companion object {
        fun create(
            value: Int,
            winningNumbers: Lotto,
        ): BonusNumber {
            require(value !in winningNumbers.numbers) {
                "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            }
            return BonusNumber(value)
        }
    }
}
