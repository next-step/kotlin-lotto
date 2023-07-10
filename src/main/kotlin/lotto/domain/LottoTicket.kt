package lotto.domain

import lotto.dto.LottoNumbers

class LottoTicket(numbers: LottoNumbers) {
    val lottoNumbers: Set<LottoNumber> = numbers.lottoNumbers.sortedBy { it.number }.toSet()

    init {
        require(lottoNumbers.count() == SIZE)
    }

    fun getWinResult(winTicket: LottoTicket, bonus: Int): WinResult {
        val matchCount = winTicket.lottoNumbers.count { i -> lottoNumbers.contains(i) }
        return WinResult.valueOf(matchCount, lottoNumbers.contains(LottoNumber(bonus)))
    }

    companion object {
        private const val SIZE = 6
    }
}
