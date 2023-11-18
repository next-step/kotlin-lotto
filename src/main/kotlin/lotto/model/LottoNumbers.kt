package lotto.model

class LottoNumbers(
    val numbers: List<Int>
) {
    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = numbers
        val targetLottoNumbers = target.numbers.toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }
}
