package lotto.domain

object LottoStore {
    fun purchase(money: Int, lottoGenerator: LottoGenerator): Lottos {
        val count = money / Lotto.LOTTO_PRICE
        return Lottos(List(count) { lottoGenerator.generateLotto() })
    }
}
