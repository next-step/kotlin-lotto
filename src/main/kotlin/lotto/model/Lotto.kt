package lotto.model

data class Lotto(var numbers: MutableList<Int>) {
    var matchNumberCount = 0
    var prize = 0

    fun add(number: Int) {
        if (numbers.none { it == number }) {
            numbers.add(number)
            numbers.sort()
        }
    }

    fun checkWinningResult(winner: Lotto) {
        checkMatchNumber(winner)
        checkPrize()
    }

    private fun checkMatchNumber(winner: Lotto) {
        winner.numbers.forEach {
            if (numbers.contains(it)) {
                matchNumberCount++
            }
        }
    }

    private fun checkPrize() {
        val win = Win.values().filter { it.matchNumber == matchNumberCount }

        prize = if (win.isEmpty()) 0 else win[0].prize
    }

    enum class Win(val matchNumber: Int, val prize: Int) {
        FOURTH(3, 5000),
        THIRD(4, 50000),
        SECOND(5, 1500000),
        FIRST(6, 2000000000)
    }
}
