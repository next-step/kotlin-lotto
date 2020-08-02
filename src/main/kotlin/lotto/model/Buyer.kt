package lotto.model

private const val LOTTO_PRICE = 1000

fun buyLotto(money: Int): List<Lotto> {
    require(money > LOTTO_PRICE) { "돈이 부족합니다." }

    val lottoCount = Math.floorDiv(money, LOTTO_PRICE)

    return MutableList(lottoCount) { LottoMaker().make() }
}
