package lotto.domain

data class WinningNumbers(
    val lotto: Lotto
) {
    companion object {
        fun of(numbers: Set<Int>): WinningNumbers {
            return try {
                WinningNumbers(Lotto.of(numbers))
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("당첨 번호가 유효하지 않습니다. $numbers")
            }
        }
    }
}
