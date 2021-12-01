package lotto.domain

interface LottoNumberFactory {
    fun createLottoNumberList(count: Int): List<LottoNumber>
}
