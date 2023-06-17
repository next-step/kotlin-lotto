package lotto.domain

data class LottoTicket(val numbers: List<Int>) {
    val lottoNumbers: Set<Int> = numbers.map { it }.sorted().toSet()

    fun getWinResult(winTicket: LottoTicket): WinResult {
        val matchCount = winTicket.lottoNumbers.count { i -> lottoNumbers.contains(i) }
        return WinResult.valueOfMatchCount(matchCount)
    }

    init {
        require(lottoNumbers.count() == SIZE)
        lottoNumbers.forEach {
            require(it in MIN..MAX) { "로또 번호는 1~45까지 입력 가능합니다." }
        }
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val SIZE = 6
    }
}
