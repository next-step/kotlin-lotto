package lotto.model

class RandomNumbersGenerator : NumbersGenerator {
    override fun getNumbers(candidateSize: Int, resultSize: Int): List<Int> {
        return List(candidateSize) { i -> i + 1 }.shuffled().subList(0, resultSize)
    }
}
