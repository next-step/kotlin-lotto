package lotto.domain

class LottoTicket(numbers: LottoNumbers) {
    val lottoNumbers: Set<Int> = numbers.lottoNumbers.sorted().toSet()

    fun getWinResult(winTicket: LottoTicket, bonus: Int): WinResult {
        val matchCount = winTicket.lottoNumbers.count { i -> lottoNumbers.contains(i) }
        return WinResult.valueOf(matchCount, lottoNumbers.contains(bonus))
    }
}
