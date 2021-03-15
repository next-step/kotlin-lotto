package lotto.model.number

class BonusNumber private constructor(bonusNumber: Int) : LottoNumber(bonusNumber) {
    companion object {
        private val BONUS_NUMBERS = (MINIMUM..MAXIMUM).map { BonusNumber(it) }

        fun get(bonusNumber: Int): BonusNumber {
            validate(bonusNumber)

            return BONUS_NUMBERS[bonusNumber - 1]
        }
    }
}
