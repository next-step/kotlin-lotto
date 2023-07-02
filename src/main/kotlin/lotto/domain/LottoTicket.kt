package lotto.domain

import lotto.dto.LottoNumbers

class LottoTicket(numbers: LottoNumbers) {
    val lottoNumbers: Set<Int> = numbers.lottoNumbers.sorted().toSet()

    init {
        require(lottoNumbers.count() == SIZE)
        if (!lottoNumbers.all { it in MIN..MAX }) {
            throw IllegalArgumentException("로또 번호는 1~45까지 입력 가능합니다.")
        }
    }

    fun getWinResult(winTicket: LottoTicket, bonus: Int): WinResult {
        val matchCount = winTicket.lottoNumbers.count { i -> lottoNumbers.contains(i) }
        return WinResult.valueOf(matchCount, lottoNumbers.contains(bonus))
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val SIZE = 6
    }
}
