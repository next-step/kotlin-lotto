package lotto.domain

class LottoResult(usedMoney: Money, grades: List<Grade>) {
    private val countingGrade: Map<Grade, Int> = grades.groupBy { it }.mapValues { (_, value) ->
        value.count()
    }

    val totalReward: Int = countingGrade.entries.sumOf { (grade, count) ->
        grade.reward * count
    }

    val revenueRate = totalReward / usedMoney.amount.toFloat()

    fun getMatchedCount(grades: Grade): Int = countingGrade.getOrDefault(grades, 0)
}
