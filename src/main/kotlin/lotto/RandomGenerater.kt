package lotto

class RandomGenerater : Generatable {
    override fun generate(count: Int, minNumber: Int, maxNumber: Int): Lotto {
        val numbers = (minNumber..maxNumber).shuffled()
            .subList(0, count)
            .toSet()
        return Lotto(numbers)
    }
}
