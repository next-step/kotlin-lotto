package lotto.domain

class ManualLottoGenerator(private val manualNumbers: List<List<Int>>) : LottoGenerator {
    override fun generateLotto(lottoCount: Int): Lottos {
        require(lottoCount == manualNumbers.size) { "수동 구매 개수와 수동 구매 번호의 총 개수는 같아야 합니다." }
        return Lottos(manualNumbers.map { Lotto.fromInts(it) })
    }
}
