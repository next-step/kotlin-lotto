package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {
    fun contains(number: Int) = lotto.numbers.contains(number)
}
