package lotto.domain

class LottoDispenser(private val amount: Int) {

    val list: List<Lotto> = makeLottoList()

    init {
        if (amount <= 0) {
            throw IllegalArgumentException("구입 금액은 0원 이하가 될 수 없습니다")
        }
    }

    private fun makeLottoList(): List<Lotto> {
        return List(amount / BASIC_PRICE) {
            Lotto()
        }
    }
}
