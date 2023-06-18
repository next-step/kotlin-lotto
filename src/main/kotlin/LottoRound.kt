
class LottoRound(private val lottoGenerator: LottoGenerator) {
    constructor(lottoRoundElements: LottoRoundElements) : this(lottoRoundElements.lottoGenerator)

    private val lottos: MutableList<Lotto> = mutableListOf()

    fun addNewLottos(newLottoSize: Int) {
        repeat(newLottoSize) {
            lottos.add(newLotto())
        }
    }

    fun getLottos(): List<Lotto> = lottos.toList()

    fun lotteryDraw(winningLotto: Lotto): LottoRoundStatistics {
        return LottoRoundStatistics(lottos, winningLotto)
    }

    private fun newLotto() = lottoGenerator.generate()
}

data class LottoRoundElements(
    val lottoGenerator: LottoGenerator = RandomLottoGenerator()
)
