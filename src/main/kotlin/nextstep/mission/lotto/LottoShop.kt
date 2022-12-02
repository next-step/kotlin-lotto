package nextstep.mission.lotto

const val LOTTO_PRICE = 1000

object LottoShop {

    fun purchaseAutoLottoBy(totalPrice: Int): Lotto = (1..totalPrice / LOTTO_PRICE)
        .map { LottoMachine.create() }
        .let { Lotto(it) }
}
