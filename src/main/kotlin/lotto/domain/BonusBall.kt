package lotto.domain

@JvmInline
value class BonusBall private constructor(val value: LottoNumber) {

    companion object {
        fun of(bonusBall: Int): BonusBall {
            return of(LottoNumber.of(bonusBall))
        }

        fun of(bonusBall: LottoNumber): BonusBall {
            return BonusBall(bonusBall)
        }
    }
}
