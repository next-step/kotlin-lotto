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
}
