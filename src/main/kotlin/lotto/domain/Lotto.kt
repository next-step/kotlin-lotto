package lotto.domain

class Lotto(money: Int, candidateNumbers: List<String>) {
    val list = makeList(money, candidateNumbers)

    private fun makeList(money: Int, candidateNumbers: List<String>): List<SixNumbers> {
        val list = mutableListOf<SixNumbers>()
        val amount = money / 1000
        for (time in 1..amount) {
            val shuffleNumbers = candidateNumbers.shuffled()
            list.add(SixNumbers(shuffleNumbers))
        }
        return list
    }

    fun checkCorrect(corrects: SixNumbers) {
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
}
