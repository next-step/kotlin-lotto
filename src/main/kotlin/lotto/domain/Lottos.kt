package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    val buyCount: Long
        get() = lottoList.size.toLong()

    companion object {
        fun from(money: Money): Lottos {
            val buyCount = money.buy(Lotto.PRICE)
            val lottoList = buildList {
                repeat((0..buyCount).count()) {
                    add(Lotto())
                }
            }
            return Lottos(lottoList)
        }
    }
}
