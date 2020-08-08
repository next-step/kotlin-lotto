package lotto.model

fun getAutoLotto(money: Money): LottoPaper {
    val lottoCount = money.buyMaxLottoCount()

    return LottoPaper(List(lottoCount) { LottoMaker().make() })
}
