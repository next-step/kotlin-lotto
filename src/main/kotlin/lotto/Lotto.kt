package lotto

class Lotto {

    fun generateNumbers(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        do {
            numberSet.add(LottoNumber().getLottoNumber())
        } while (numberSet.size < NUMBER_COUNT)
        return numberSet.sorted()
    }

    companion object {
        const val ONE_PRICE: Int = 1000
        const val NUMBER_COUNT: Int = 6
    }
}
