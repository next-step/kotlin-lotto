package lotto.domain

class LottoResult(usedMoney: Money, grades: List<Grade>) {
    private val countingGrade = grades.groupBy { it }.mapValues { (_, value) ->
        value.count()
    }

    val totalReward = countingGrade.entries.sumOf { (grade, count) ->
        grade.reward * count
    }

    val revenueRate = totalReward / usedMoney.amount.toFloat()

    fun getMatchedCount(grades: Grade) = countingGrade.getOrDefault(grades, 0)
}
