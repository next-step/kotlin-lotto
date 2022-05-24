package lotto

class Confirmation(winningValue: String, lotto: Lotto) {
    val winningNumbers = winningValue
        .replace(" ", "")
        .split(",")
        .map { it.toInt() }
        .intersect(lotto.numbers)

    val price = when (this.winningNumbers.size) {
        3 -> 5000
        4 -> 50000
        5 -> 1500000
        6 -> 2000000000
        else -> 0
    }
}
