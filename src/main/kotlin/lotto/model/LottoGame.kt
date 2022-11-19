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
            lottos.add(Lotto(lottoNumberGenerator))
        }
    }

    fun draw(winningNumber: List<Int>) {
        lottos.forEach {
            it.scratch(winningNumber)
        }
    }

    fun winningRate(): Double {
        val sumLottoReward = lottos.sumOf {
            it.grade.reward
        }

        return sumLottoReward.toDouble() / lottoAmount
    }

    fun getLottos() = lottos.toList()
}
