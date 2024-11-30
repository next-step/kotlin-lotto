package lotto.model

class Lotto(val numbers: List<Int> = generateNumbers()) {
    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        var matchCount = 0
        for (number in winningNumbers) {
            if (numbers.contains(number)) {
                matchCount++
            }
        }
        return matchCount
    }

    private companion object {
        fun generateNumbers(): List<Int> = (1..45).shuffled().take(6).sorted()
    }
}
