package lotto.domain

class BonusBall private constructor(val lottoNumber: LottoNumber) {

    companion object {
        const val WINNING_LOTTO_CONTAIN_BONUS_NUMBER_EXCEPTION = "지난주 당첨 로또번호에 보너스 넘버가 포함되어 있습니다."

        fun of(bonusNumber: String, winningLotto: Lotto): BonusBall {
            require(LottoNumber.from(bonusNumber) !in winningLotto) {
                WINNING_LOTTO_CONTAIN_BONUS_NUMBER_EXCEPTION
            }
            return BonusBall(LottoNumber.from(bonusNumber))
        }
    }
}
