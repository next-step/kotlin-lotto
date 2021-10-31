package lotto.domain

data class Lotto(private val lottoNumber: LottoNumber) {

    fun toNumberList(): List<Int> = lottoNumber.toList()

    companion object {
        val PRICE = 1000
        fun generate(): Lotto = Lotto(LottoNumber())
    }
}
