package lotto.domain

object LottoStore {
    fun purchase(totalMoney: Int, manualLottos: Lottos, lottoGenerator: LottoGenerator): Lottos {
        val count = totalMoney / Lotto.LOTTO_PRICE
        val manualLottoCount = manualLottos.size
        require(count >= manualLottoCount) { "수동 구매 개수는 전체 로또 구매 개수보다 클 수 없습니다." }
        val automaticLottos = lottoGenerator.generateLotto(count - manualLottoCount)
        return manualLottos + automaticLottos
    }
}
