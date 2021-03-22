package lotto.domain

class LottoCollection(val lotto: List<Lotto>) : List<Lotto> by lotto {
    init {
        require(lotto.isNotEmpty()) { "로또는 1개 이상을 갖고있어야 합니다." }
    }

    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count,
            generator
        )
    )

    companion object {
        private fun createLotto(count: Int, generator: LottoNumberGenerator): List<Lotto> {
            val lotto: MutableList<Lotto> = mutableListOf()

            repeat(count) {
                lotto.add(Lotto(generator))
            }

            return lotto.toList()
        }
    }
}
