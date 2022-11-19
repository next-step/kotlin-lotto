package nextstep.mission.lotto

private const val LOTTO_PRICE = 1000

class Lottos(val lottos: List<Lotto>) {

    constructor(lottoPrice: Int) : this(createLottos(lottoPrice / LOTTO_PRICE))

    companion object {
        private fun createLottos(count: Int, lottos: List<Lotto> = emptyList()): List<Lotto> = when (lottos.size) {
            count -> lottos
            else -> {
                try {
                    val numbers: List<Int> = NumberFactory.create()
                    createLottos(count, lottos + Lotto(numbers))
                } catch (e: Exception) {
                    createLottos(count, lottos)
                }
            }
        }
    }
}
