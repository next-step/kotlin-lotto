package lotto

class Lotto(generate: () -> Int) {
    val numbers: List<Int> = List(LOTTO_NUMBER_COUNT) { generate() }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}

fun generate(): Int = (1..45).random()
