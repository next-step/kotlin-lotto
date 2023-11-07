package lotto.model

class LottoNumbers(
    private val numbers: List<Int>
) {

    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = this.getNumbers()
        val targetLottoNumbers = target.getNumbers().toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }

    private fun getNumbers(): List<Int> {
        return numbers
    }
}
