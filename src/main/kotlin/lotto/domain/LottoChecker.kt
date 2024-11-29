package lotto.domain

object LottoChecker {
    fun findMatchingNumbers(
        lottoNumbers: List<Int>,
        winnerNumbers: List<Int>,
    ): Int =
        lottoNumbers.count { number ->
            winnerNumbers.contains(number)
        }
}
