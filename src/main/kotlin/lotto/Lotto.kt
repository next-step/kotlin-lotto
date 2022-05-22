package lotto

class Lotto {
    val numbers: List<Int> = List(LOTTO_NUMBER_COUNT) { generate() }
    private fun generate() = (1..45).random()

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
