package lotto.domain

data class LottoGame(private val numbers: List<Int>) {
    fun getNumbers(): List<Int> = numbers.toList()
}
