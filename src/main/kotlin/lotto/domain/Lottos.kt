package lotto.domain

class Lottos(money: Money) {
    val lottoList: List<Lotto>
    val buyCount: Long

    init {
        buyCount = money.buy(Lotto.PRICE)
        lottoList = buildList {
            repeat((0 .. 2).count()) {
                add(Lotto())
            }
        }
    }

}
