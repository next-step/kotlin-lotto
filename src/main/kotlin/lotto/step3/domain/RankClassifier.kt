package lotto.step3.domain

object RankClassifier {
    fun classify(
        lottos: List<Lotto>,
        winningNumbers: Set<Int>,
        bonusNumber: Int,
    ): Map<Rank, Int> {
        return lottos.groupBy { lotto ->
            val matchCount = lotto.numbers.intersect(winningNumbers).size
            val hasBonusNumber = lotto.numbers.contains(bonusNumber) && matchCount == 5 // 보너스 번호는 2등 조건에만 적용
            Rank.valueOf(matchCount, hasBonusNumber)
        }.mapValues { it.value.size }
    }
}
