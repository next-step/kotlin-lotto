package lotto.domain

class Lottos(
    private val _lottos: List<Lotto>,
) {
    val lottos: List<Lotto>
        get() = _lottos.toList()

    companion object {
        fun generateAutoLottos(lottoNumber: Int, autoLottoPublishStrategy: () -> Lotto): Lottos {
            return mutableListOf<Lotto>().apply {
                repeat(lottoNumber) { add(autoLottoPublishStrategy.invoke()) }
            }.let { Lottos(it.toList()) }
        }
    }
}
