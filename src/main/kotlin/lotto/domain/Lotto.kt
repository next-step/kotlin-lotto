package lotto.domain

class Lotto {
    val numbers = (MIN..MAX).shuffled().take(COUNT)

    companion object {
        private const val COUNT = 6
        private const val MIN = 1
        private const val MAX = 45
    }
}
