package lotto.model

fun buyLotto(money: Money): List<Lotto> {
    require(money.canBuyLotto()) { "돈이 부족합니다." }

    val lottoCount = money.purchasableLotto()

    return MutableList(lottoCount) { LottoMaker().make() }
}
