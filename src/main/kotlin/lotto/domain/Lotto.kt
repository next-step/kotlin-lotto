package lotto.domain

class Lotto(candidateNumbers: List<String>) {
    val numbers = sortList(makeList(candidateNumbers))

    private fun sortList(list: List<Number>): List<Number> = list.sortedBy { it.number }

    private fun makeList(candidateNumbers: List<String>): List<Number> = candidateNumbers.take(6).map { Number(it) }

    fun getRank(numbers: List<Number>, bonusNumber: Number): String = checkRank(numbers.filter { isCorrect(it) }.size, isCorrect(bonusNumber))

    private fun isCorrect(number: Number): Boolean = numbers.contains(number)

    private fun checkRank(matchNumber: Int, isBonus: Boolean): String {
        return when {
            matchNumber == 6 -> "1등"

            matchNumber == 5 && isBonus -> "2등"

            matchNumber == 5 -> "3등"

            matchNumber == 4 -> "4등"

            matchNumber == 3 -> "5등"

            else -> "No Rank"
        }
    }
}
