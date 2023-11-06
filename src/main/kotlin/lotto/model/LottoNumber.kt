package lotto.model

class LottoNumber(
    private val numbers: List<Int>
) {

    fun match(target: LottoNumber): Int {
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
