package lotto

class Lotto {
    val numbers: List<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().subList(0, NUMBER_COUNT)

    companion object {
        private const val FIRST_NUMBER = 1
        private const val LAST_NUMBER = 45
        private const val NUMBER_COUNT = 6
    }
}
