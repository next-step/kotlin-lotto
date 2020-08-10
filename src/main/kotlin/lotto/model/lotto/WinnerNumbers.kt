package lotto.model.lotto

import lotto.model.prize.Prize

class WinnerNumbers(
    private val numbers: Numbers,
    private val bonusBall: LottoNumber
) {
    init {
        validationBonusNumber()
    }

    fun match(lottoNumbers: Numbers) =
        Prize.getPrize(
            lottoNumbers.getMatchingCounts(numbers),
            lottoNumbers.isMatch(bonusBall)
        )

    private fun validationBonusNumber() {
        require(numbers.isMatch(bonusBall).not()) { "보너스 번호와 중복될순 없습니다." }
    }
}
