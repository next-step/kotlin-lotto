package lotto.data

import lotto.enums.LotteryMatchType

class WinningNumbers(
    lottoNumbers: List<Int>,
    bonusNumber: Int
) {
    private val lottoNumbers: LottoNumbers = LottoNumbers(lottoNumbers)
    private val bonusNumber: LottoNumber = LottoNumber.from(bonusNumber)

    init {
        require(!lottoNumbers.contains(bonusNumber)) { "보너스 숫자가 로또 숫자와 중복되었습니다." }
    }

    fun findWinningType(targetLottoNumbers: LottoNumbers): LotteryMatchType {
        val matchCount = lottoNumbers.countMatchedNumber(targetLottoNumbers)
        val hasBonusNumber = targetLottoNumbers.contains(bonusNumber)
        return LotteryMatchType.findByMatchCount(matchCount, hasBonusNumber)
    }
}
