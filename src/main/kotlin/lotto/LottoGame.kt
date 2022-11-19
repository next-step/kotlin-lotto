package lotto

private const val LOTTO_PER_AMOUNT = 1000

class LottoGame(
    private val lottoAmount: Int,
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {

    lateinit var winningNumber: List<Int>
    var lottos: MutableList<Lotto> = mutableListOf()
        private set

    init {
        repeat(lottoAmount / LOTTO_PER_AMOUNT) {
            lottos.add(Lotto(lottoNumberGenerator))
        }
    }

    fun winningRate(): Double {
        val sumLottoReward = lottos.sumOf { it.grade(winningNumber).reward }

        return sumLottoReward.toDouble() / lottoAmount
    }
}
