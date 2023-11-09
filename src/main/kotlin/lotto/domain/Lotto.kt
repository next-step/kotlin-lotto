package lotto.domain

class Lotto(private val lottoNumberList: LottoNumberList) {

    fun getNumberList(): List<Int> = this.lottoNumberList.numberList

    fun getMatchCount(lotto: Lotto): Int = getNumberList().intersect(lotto.getNumberList().toSet()).size

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val LOTTO_NUMBER_MIN: Int = 1
        const val LOTTO_NUMBER_MAX: Int = 45
        const val NUMBER_COUNT_MIN: Int = 0
        const val NUMBER_COUNT_MAX: Int = 6
    }
}
