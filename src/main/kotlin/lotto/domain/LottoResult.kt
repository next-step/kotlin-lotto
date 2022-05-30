package lotto.domain

class LottoResult(grades: List<Grade>) {
    private val gradeInfos = listOf(
        GradeInfo(Grade.First, grades.count { it == Grade.First }),
        GradeInfo(Grade.Second, grades.count { it == Grade.Second }),
        GradeInfo(Grade.Third, grades.count { it == Grade.Third }),
        GradeInfo(Grade.Fourth, grades.count { it == Grade.Fourth })
    )

    val totalLottoCount = grades.count()

    val totalReward = gradeInfos.sumOf {
        it.grade.reward * it.count
    }

    val revenueRate = totalReward / (totalLottoCount * LottoMachine.LottoCost).toFloat()

    fun forEach(action: (Grade, Int) -> Unit) {
        gradeInfos.forEach {
            action(it.grade, it.count)
        }
    }
}
