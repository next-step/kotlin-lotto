package lotto.domain

class BonusBall private constructor(val lottoNumber: LottoNumber) {

    constructor(bonusNumber: String, winningLotto: Lotto) : this(LottoNumber.of(bonusNumber)) {
        require(!winningLotto.contains(LottoNumber.of(bonusNumber))) {
            WINNING_LOTTO_CONTAIN_BONUS_NUMBER_EXCEPTION
        }
    }

    companion object {
        const val WINNING_LOTTO_CONTAIN_BONUS_NUMBER_EXCEPTION = "지난주 당첨 로또번호에 보너스 넘버가 포함되어 있습니다."
    }
}
