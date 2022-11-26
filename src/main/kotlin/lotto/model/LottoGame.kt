package lotto.model

private const val LOTTO_PER_AMOUNT = 1000

class LottoGame(
    private val lottoAmount: Int,
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {

    private var lottos: MutableList<Lotto> = mutableListOf()

    init {
        createLotto(lottoNumberGenerator)
    }

    private fun createLotto(lottoNumberGenerator: LottoNumberGenerator) {
        repeat(lottoAmount / LOTTO_PER_AMOUNT) {
            lottos.add(Lotto(lottoNumberGenerator.pick()))
        }
    }

    fun draw(winningNumber: LottoNumbers, plusNumber: LottoNumber): List<LottoGrade> {
        return lottos.map { it.scratch(winningNumber, plusNumber) }.toList()
    }

    fun getLottos() = lottos.toList()
}
