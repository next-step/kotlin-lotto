package lotto.model

fun buyLotto(money: Int): List<Lotto> {
    require(money > LOTTO_PRICE) { "돈이 부족합니다." }

    val lottoCount = Math.floorDiv(money, LOTTO_PRICE)

    return MutableList(lottoCount) { LottoMaker().make() }
}
