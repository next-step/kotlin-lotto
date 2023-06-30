package lotto

import lotto.enums.LottoReturn

class ResultLottoNumber private constructor(
    val lotto: Lotto,
    val bonusNumber: Int,
) {
    init {
        require(bonusNumber in Lotto.LOTTO_NUMBER_RANGE) { "범위를 벗어난 숫자가 있습니다." }
        require(!this.lotto.numbers.contains(bonusNumber)) { "보너스 번호는 로또 번호와 중복될 수 없습니다." }
    }

    fun decideReturn(defaultNumber: Lotto): LottoReturn {
        return LottoReturn.from(
            matchCount = this.lotto.countMatch(defaultNumber),
            bonusMatch = defaultNumber.numbers.contains(this.bonusNumber),
        )
    }

    companion object {
        fun from(defaultNumbers: Set<Int>, bonusNumber: Int): ResultLottoNumber {
            return ResultLottoNumber(
                lotto = Lotto.from(defaultNumbers),
                bonusNumber = bonusNumber,
            )
        }
    }
}
