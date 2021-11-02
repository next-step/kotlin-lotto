package lotto.domain

data class Lotto(private val lottoNumbers: LottoNumbers) {

    fun toNumberList(): List<Int> = lottoNumbers.toNumbers()

    companion object {
        const val PRICE = 1000
        fun generate(): Lotto = Lotto(LottoNumbers.generateLottoNumbers())
    }
}
