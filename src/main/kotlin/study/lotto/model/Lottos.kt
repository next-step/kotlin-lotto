package study.lotto.model

/**
 * @author 이상준
 */
data class Lottos(
    private var lottos: MutableList<Lotto> = mutableListOf(),
) {
    fun addLotto(lotto: Lotto) {
        lottos.add(lotto)
    }

    fun addAllLotto(lottos: Lottos) {
        lottos.lottos.forEach {
            addLotto(it)
        }
    }

    fun lottoCount(): Int {
        return lottos.size
    }

    fun getLottos(): List<Lotto> {
        return lottos.toList()
    }
}
