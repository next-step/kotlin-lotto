package lotto.domain

class WinningLotto(val winningNumbers: Lotto) {
    fun getMatchesCount(lotto: Lotto) = lotto.numbers.count { num -> winningNumbers.numbers.contains(num) }
    fun getMatchesCount(lottos: List<Lotto>) = lottos.map { lotto -> getMatchesCount(lotto) }
}
