package nextstep.mission.lotto

private const val LOTTO_PRICE = 1000

object LottoShop {

    fun purchaseBy(totalPrice: Int): Lotto = (1..totalPrice / LOTTO_PRICE)
        .map { LottoMachine.create() }
        .let { Lotto(it) }
}
