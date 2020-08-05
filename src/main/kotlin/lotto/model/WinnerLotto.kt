package lotto.model

data class WinnerLotto(val numbers: Lotto, val bonusNumber: Int) {
    fun contains(checkNumbers: List<Int>): Int {
        return checkNumbers.filter { it in numbers.numbers }.map { it }.size
    }

    fun containsBonus(checkNumbers: List<Int>): Boolean {
        return checkNumbers.filter { it == this.bonusNumber }.map { it }.isNotEmpty()
    }
}
