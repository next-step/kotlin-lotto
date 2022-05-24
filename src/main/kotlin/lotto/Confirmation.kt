package lotto

class Confirmation(private val winningValue: String, lotto: Lotto) {
    val winningNumbers = winningValue
        .replace(" ", "")
        .split(",")
        .map { it.toInt() }
        .intersect(lotto.numbers)
}
