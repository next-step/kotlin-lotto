package lotto.domain

class WinningTicket private constructor(
    private val lottoNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber,
) {
    init {
        require(lottoNumbers.notContains(bonusNumber)) {
            "보너스 번호는 당첨 번호들과 중복될 수 없습니다."
        }
    }

    fun matchResult(lottoTicket: LottoTicket): WinningAmount {
        val matchCount = lottoNumbers.matchedNumberCount(other = lottoTicket.lottoNumbers)
        val matchBonus = bonusNumber in lottoTicket.lottoNumbers

        return when {
            matchCount == 5 && matchBonus -> WinningAmount.SECOND
            matchCount == 5 && !matchBonus -> WinningAmount.THIRD
            else -> WinningAmount.findByMatchCount(matchCount = matchCount)
        }
    }

    companion object {
        fun of(lottoNumbers: List<Int>, bonusNumber: Int): WinningTicket = WinningTicket(
            lottoNumbers = LottoNumbers.createWithSort(convertToLottoNumberSet(lottoNumbers)),
            bonusNumber = LottoNumber.from(bonusNumber)
        )

        private fun convertToLottoNumberSet(numbers: List<Int>) =
            numbers.map { LottoNumber.from(it) }
                .toSet()
    }
}
