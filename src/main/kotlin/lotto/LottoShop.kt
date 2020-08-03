package lotto

import lotto.LottoUtils.provideNumbers

class LottoShop(payment: Int) {
    private var amount: Int = payment / LOTTO_PRICE

    fun makeLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(amount) { lottos.add(Lotto(provideNumbers())) }
        return lottos
    }

    override fun toString(): String {
        return "${amount}개를 구매했습니다."
    }
}
