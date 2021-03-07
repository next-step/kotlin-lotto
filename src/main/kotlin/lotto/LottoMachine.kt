package lotto

class LottoMachine(lottoPrice: Int) {

    init {
        require(lottoPrice > 0) { "로또금액은 0보다 커야합니다" }
    }

    fun sellLottos(money: Int): List<Lotto> {
        return listOf()
    }
}
