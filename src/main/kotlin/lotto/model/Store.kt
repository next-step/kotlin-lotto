package lotto.model

class Store(private val buyer: Buyer) {

    fun winLotto(lottoNumbers: List<Int>): List<Prize> {
        return listOf(Prize.NO_THREE)
    }
}
