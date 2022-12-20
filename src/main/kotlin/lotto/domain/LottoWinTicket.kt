package lotto.domain

import lotto.argumentError

class LottoWinTicket(
    private val winNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {

    fun matches(inputNumbers: LottoNumbers): LottoReward {
        val matchCount = inputNumbers.matches(winNumbers)
        val matchBonus = inputNumbers.matches(bonusNumber)
        return LottoReward.from(matchCount, matchBonus)
    }

    companion object {
        fun from(winNumberString: String, bonusString: String): LottoWinTicket {
            val winLottoNumbers = LottoNumbers.from(winNumberString)
            val bonusLottoNumber = LottoNumber(bonusString)

            if (winLottoNumbers.matches(bonusLottoNumber)) {
                argumentError("보너스 숫자는 당첨 번호와 중복될 수 없습니다.")
            }

            return LottoWinTicket(
                winLottoNumbers,
                bonusLottoNumber
            )
        }
    }
}
