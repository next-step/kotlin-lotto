package lotto.domain

class Lottos(val value: List<Lotto>) {

    fun matchWinningNumbers(winningNumbers: List<Int>): Map<Ranking, Int> {
        return value.groupBy { lottoNumber ->
            lottoNumber.value.count {
                winningNumbers.contains(it)
            }
        }
            .map { Pair(Ranking.valueOf(it.key), it.value.size) }
            .toMap()
    }
}
