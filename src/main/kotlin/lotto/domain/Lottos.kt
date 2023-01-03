package lotto.domain

class Lottos(val value: List<Lotto>) {

    fun matchWinningNumbers(winningNumbers: List<Int>): Map<Ranking, Int> {
        return value.groupingBy { lottoNumber ->
            Ranking.valueOf(
                lottoNumber.value.count {
                    winningNumbers.contains(it)
                }
            )
        }.eachCount()
    }
}
