package lotto

import lotto.enums.LottoReturn

class ResultLotto private constructor(
    val lotto: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!this.lotto.numbers.contains(bonusNumber)) { "보너스 번호는 로또 번호와 중복될 수 없습니다." }
    }

    fun decideReturn(defaultNumber: Lotto): LottoReturn {
        return LottoReturn.from(
            matchCount = this.lotto.countMatch(defaultNumber),
            bonusMatch = defaultNumber.numbers.contains(this.bonusNumber),
        )
    }

    companion object {
        fun from(lotto: Lotto, bonusNumber: LottoNumber): ResultLotto {
            return ResultLotto(
                lotto = lotto,
                bonusNumber = bonusNumber,
            )
        }
    }
}
