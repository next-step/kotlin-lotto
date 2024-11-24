package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        if (numbers.size != 6) {
            throw InvalidLottoNumberCountException(numbers)
        }

        val invalidNumberCount = numbers.count { number -> number < 1 || number > 45 }
        if (invalidNumberCount != 0) {
            throw InvalidLottoNumberException(numbers)
        }
    }
}
