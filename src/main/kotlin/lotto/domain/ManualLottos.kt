package lotto.domain

import lotto.exception.IllegalLottosException

class ManualLottos(lottos: List<Lotto>, val quantity: Int) : Lottos(lottos) {
    init {
        if (quantity < lottos.size) {
            throw IllegalLottosException("수동로또로 구매한 수량은 구매가능한 수량보다 작아야 합니다.")
        }
    }

    fun generateAutoLottos(generatorFactory: GeneratorFactory): Lottos {
        return Lottos.of(quantity - lottos.size, generatorFactory)
    }
}
