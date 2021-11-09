package lotto.domain

@JvmInline
value class BonusBall private constructor(val value: LottoNumber) {

    fun isIn(lottoNumbers: LottoNumbers): Boolean {
        return lottoNumbers.isContainLottoNumber(value)
    }

    companion object {
        fun of(bonusBall: Int): BonusBall {
            return of(LottoNumber.of(bonusBall))
        }

        fun of(bonusBall: LottoNumber): BonusBall {
            return BonusBall(bonusBall)
        }
    }
}
