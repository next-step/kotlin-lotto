package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun pay(cash: Cash): Pair<Lottos, Cash> {
        val lottoCount = cash.amount / Lotto.PRICE
        val totalLottoNumbers = (1..lottoCount).map { lottoGenerator.generateLottoNumbers() }

        return pay(cash, totalLottoNumbers)
    }

    fun pay(cash: Cash, lottoNumbers: List<Set<LottoNumber>>): Pair<Lottos, Cash> {
        require(cash.amount >= Lotto.PRICE)

        val lottoList = Lottos.of(lottoNumbers)
        val changes = cash.play(Lotto.PRICE * lottoList.lottoList.size)

        return lottoList to changes
    }
}
