package lotto.domain

class Lotto(candidateNumbers: List<String>, correctNumber: Int = 0) {
    val numbers = sortList(makeList(candidateNumbers))
    var correctNumber = correctNumber
        private set

    private fun sortList(list: List<Number>): List<Number> {
        return list.sortedBy { it.number }
    }

    private fun makeList(candidateNumbers: List<String>): List<Number> = candidateNumbers.take(6).map { Number(it) }


    fun checkCorrect(number: Number) {
        if (numbers.contains(number)) {
            correctNumber += 1
        }
    }
}
