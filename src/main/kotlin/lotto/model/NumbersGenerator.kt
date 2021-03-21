package lotto.model

interface NumbersGenerator {
    fun getNumbers(candidateSize: Int, resultSize: Int): List<Int>
}
