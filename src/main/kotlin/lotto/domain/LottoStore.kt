package lotto.domain

object LottoStore {
    fun purchase(totalMoney: Int, manualLottoNumbers: List<List<Int>>, lottoGenerator: LottoGenerator): Lottos {
        val count = totalMoney / Lotto.LOTTO_PRICE
        val manualLottoCount = manualLottoNumbers.size
        require(count >= manualLottoCount) { "수동 구매 개수는 전체 로또 구매 개수보다 클 수 없습니다." }
        val manualLottos = ManualLottoGenerator(manualLottoNumbers).generateLotto(manualLottoCount)
        val automaticLottos = lottoGenerator.generateLotto(count - manualLottoCount)
        return manualLottos + automaticLottos
    }
}
