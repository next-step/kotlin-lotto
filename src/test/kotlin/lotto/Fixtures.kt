package lotto

object Fixtures {
    fun createSixLottoNumber(numbers: List<Int>): List<LottoNumber> {
        return numbers.map { LottoNumber.from(it) }
            .toList()
    }
}
