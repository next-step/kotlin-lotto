package lotto.domain

class BonusNumber(val bonusNumber: LottoNumber) {
    companion object {
        fun from(number: Int): BonusNumber =
            BonusNumber(
                LottoNumber.from(number)
            )
    }
}
