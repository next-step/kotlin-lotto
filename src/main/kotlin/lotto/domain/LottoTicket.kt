package lotto.domain

class LottoTicket(numbers: List<Int>) {
    val lottoNumbers: Set<Int> = numbers.sorted().toSet()

    init {
        require(lottoNumbers.count() == SIZE)
        if (!lottoNumbers.all { it in MIN..MAX }) {
            throw IllegalArgumentException("로또 번호는 1~45까지 입력 가능합니다.")
        }
    }

    fun getWinResult(winTicket: LottoTicket): WinResult {
        val matchCount = winTicket.lottoNumbers.count { i -> lottoNumbers.contains(i) }
        return WinResult.valueOfMatchCount(matchCount)
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val SIZE = 6
    }
}
