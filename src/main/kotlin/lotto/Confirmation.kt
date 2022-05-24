package lotto

class Confirmation(winningValue: String, lotto: Lotto) {
    val winningNumbers = winningValue
        .replace(" ", "")
        .split(",")
        .map { it.toInt() }
        .intersect(lotto.numbers)
}
