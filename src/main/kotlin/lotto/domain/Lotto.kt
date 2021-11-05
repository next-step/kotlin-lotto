package lotto.domain

data class Lotto(private val lottoNumbers: LottoNumbers) {

    fun getLottoNumbers(): List<Int> = lottoNumbers.getNumbers()

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
