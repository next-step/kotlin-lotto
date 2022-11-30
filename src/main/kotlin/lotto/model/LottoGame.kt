package lotto.model

private const val LOTTO_PER_AMOUNT = 1000

class LottoGame(
    private val lottoAmount: PurchaseAmount,
    private val directNumbers: List<LottoNumbers> = listOf(),
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {
    constructor(lottoAmount: Int) : this(PurchaseAmount(lottoAmount))

    private lateinit var lottos: List<LottoNumbers>

    init {
        createLotto(lottoNumberGenerator)
    }

    private fun createLotto(lottoNumberGenerator: LottoNumberGenerator) {
        var result = mutableListOf<LottoNumbers>()
        repeat(lottoAmount.amount / LOTTO_PER_AMOUNT - directNumbers.size) {
            result.add(lottoNumberGenerator.pick())
        }

        lottos = directNumbers + result
    }

    fun draw(winningNumber: LottoNumbers, plusNumber: LottoNumber): List<LottoGrade> {
        return lottos.map { it.scratch(winningNumber, plusNumber) }.toList()
    }

    fun getLottos() = lottos.toList()
    fun getDirectLottoCount() = directNumbers.size
}
