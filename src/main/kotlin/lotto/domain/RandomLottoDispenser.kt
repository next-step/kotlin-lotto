package lotto.domain

class RandomLottoDispenser: LottoDispenser {

    override fun issue(money: Int): List<Lotto> {
        return (0 until issuedLottoSize(money))
            .map { Lotto.random() }
            .toList()
    }

    private fun issuedLottoSize(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
