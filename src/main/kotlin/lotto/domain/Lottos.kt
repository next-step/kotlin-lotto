package lotto.domain

import lotto.exception.IllegalLottosException

open class Lottos(val lottos: List<Lotto>) {
    fun countMatches(winningLotto: WinningLotto): Map<Match, Int> {
        return lottos.map { winningLotto.checkMatch(it) }
            .groupingBy { it }
            .eachCount()
    }

    fun size(): Int {
        return lottos.size
    }

    fun merge(lottos: Lottos): Lottos {
        return Lottos(this.lottos + lottos.lottos)
    }

    companion object {
        fun of(quantity: Int, generatorFactory: GeneratorFactory): Lottos {
            if (quantity < 0) {
                throw IllegalLottosException("로또의 수량은 음수일 수 없습니다.")
            }
            val lottoList = (1..quantity).map { generatorFactory.createNumberGenerator() }
                .map { Lotto.from((1..Lotto.SIZE).map { it() }) }
            return Lottos(lottoList)
        }
    }
}
