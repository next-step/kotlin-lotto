package lotto.domain

import lotto.constant.WinningInfo

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 6개로 구성되어야 해요" }
    }
    fun matchCount(winningNumber: WinningNumber): Int {
        return lottoNumbers.count { lottoNumber ->
            winningNumber.winningNumbers.contains(lottoNumber)
        }
    }
    companion object {
        const val LOTTO_SIZE = 6
    }
}

data class LottoTickets(
    val lottoCount: Int,
    val lottoTickets: List<LottoTicket>
) {
    init {
        require(lottoCount == lottoTickets.size) { "로또 수와 실제 로또 티켓 수가 달라요" }
    }
    fun match(winningNumbers: WinningNumber): Map<WinningInfo, Int> {
        return lottoTickets
            .map { lottoTicket -> lottoTicket.matchCount(winningNumbers) }
            .filter { WinningInfo.winningCounts().contains(it) }
            .groupingBy { count -> WinningInfo.findBy(count) }
            .eachCount()
    }
}
