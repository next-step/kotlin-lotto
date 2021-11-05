package lotto.domain

data class Lotto(private val lottoNumbers: LottoNumbers) {

    fun getLottoNumbers(): List<Int> = lottoNumbers.getNumbers()

    fun matchingWinningNumber(winningNumber: List<Int>, bonusNumber: Int): Pair<Int, Boolean> =
        Pair(
            lottoNumbers.getNumbers().intersect(winningNumber).count(),
            lottoNumbers.getNumbers().contains(bonusNumber)
        )

    companion object {
        const val PRICE = 1000
        fun generate(): Lotto {
            return Lotto(LottoNumbers.generateLottoNumbers())
        }

        fun from(lottoNumbers: LottoNumbers): Lotto {
            return Lotto(lottoNumbers)
        }
    }
}
