package lotto.domain

object LottoNumbersMatcher {
    fun calculateMatchCount(ticketingLotto: Lotto, winningLotto: Lotto): Int {
        return ticketingLotto.lottoNumbers.intersect(winningLotto.lottoNumbers.toSet()).size
    }
}
