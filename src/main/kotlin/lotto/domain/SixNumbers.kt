package lotto.domain

class SixNumbers(candidateNumbers: List<String>) {
    val list = makeList(candidateNumbers)

    private fun makeList(candidateNumbers: List<String>): List<Number> {
        val list = mutableListOf<Number>()
        for (position in 0..5) {
            list.add(Number(candidateNumbers[position]))
        }
        return list
    }
}
