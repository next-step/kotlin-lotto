package lotto.domain

class Lotto(private val money: Int, candidateNumbers: List<String>) {
    val amount = money / 1000
    val list = makeList(candidateNumbers)

    private fun makeList(candidateNumbers: List<String>): List<SixNumbers> {
        val list = mutableListOf<SixNumbers>()
        for (time in 1..amount) {
            val shuffleNumbers = candidateNumbers.shuffled()
            list.add(SixNumbers(shuffleNumbers))
        }
        return list
    }

    fun result(corrects: SixNumbers): List<Double> {
        checkCorrect(corrects)
        val threeMatch = list.filter { it.correctNumber == 3 }.size.toDouble()
        val fourMatch = list.filter { it.correctNumber == 4 }.size.toDouble()
        val fiveMatch = list.filter { it.correctNumber == 5 }.size.toDouble()
        val sixMatch = list.filter { it.correctNumber == 6 }.size.toDouble()
        val rateOfReturn =
            (threeMatch * THREE_MONEY + fourMatch * FOUR_MONEY + fiveMatch * FIVE_MONEY + sixMatch * SIX_MONEY) / money.toDouble()
        return listOf(threeMatch, fourMatch, fiveMatch, sixMatch, rateOfReturn)
    }

    private fun checkCorrect(corrects: SixNumbers) {
        list.forEach { giveCorrectNumber(corrects, it) }
    }

    private fun giveCorrectNumber(corrects: SixNumbers, sixNumbers: SixNumbers) {
        corrects.list.forEach { addSixNumbersCorrectNumber(sixNumbers, it) }
    }

    private fun addSixNumbersCorrectNumber(sixNumbers: SixNumbers, number: Number) {
        if (sixNumbers.list.contains(number)) {
            sixNumbers.addCorrectNumber()
        }
    }

    companion object {
        private const val THREE_MONEY = 5000
        private const val FOUR_MONEY = 50000
        private const val FIVE_MONEY = 1500000
        private const val SIX_MONEY = 2000000000
    }
}
