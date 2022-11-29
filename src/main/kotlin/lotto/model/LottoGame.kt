package lotto.model

private const val LOTTO_PER_AMOUNT = 1000

class LottoGame(
    private val lottoAmount: Int,
    private val directNumbers: List<LottoNumbers> = listOf(),
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {

    private var lottos: MutableList<LottoNumbers> = mutableListOf()

    init {
        createLotto(lottoNumberGenerator)
    }

    private fun createLotto(lottoNumberGenerator: LottoNumberGenerator) {
        lottos.addAll(directNumbers)
        repeat(lottoAmount / LOTTO_PER_AMOUNT - directNumbers.size) {
            lottos.add(lottoNumberGenerator.pick())
        }
    }

    fun draw(winningNumber: LottoNumbers, plusNumber: LottoNumber): List<LottoGrade> {
        return lottos.map { it.scratch(winningNumber, plusNumber) }.toList()
    }

    fun getLottos() = lottos.toList()
    fun getDirectLottoCount() = directNumbers.size
}
