package lotto.model

class LottoGame(
    private val lottoAmount: PurchaseAmount,
    private val directNumbers: List<LottoNumbers> = listOf(),
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {
    constructor(lottoAmount: Int) : this(PurchaseAmount(lottoAmount))

    private val lottos: List<LottoNumbers>

    init {
        lottos = createLotto(lottoNumberGenerator)
    }

    private fun createLotto(lottoNumberGenerator: LottoNumberGenerator): List<LottoNumbers> {
        val result = mutableListOf<LottoNumbers>()
        repeat(lottoAmount.count() - directNumbers.size) {
            result.add(lottoNumberGenerator.pick())
        }

        return directNumbers + result
    }

    fun draw(winningNumber: LottoNumbers, plusNumber: LottoNumber): List<LottoGrade> {
        return lottos.map { it.scratch(winningNumber, plusNumber) }.toList()
    }

    fun getLottos() = lottos.toList()
    fun getDirectLottoCount() = directNumbers.size
}
