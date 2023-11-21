package lotto.domain

class ManualLottoGenerator(private vararg val manualNumbers: List<Int>) : LottoGenerator {
    override fun generateLotto(lottoCount: Int): Lottos {
        require(lottoCount == manualNumbers.size) { "수동 구매 개수와 로또 넘버 꾸러미의 개수는 같아야 합니다." }
        val lottos = manualNumbers.take(lottoCount).map {
            Lotto.fromInts(it)
        }
        return Lottos(lottos)
    }
}
