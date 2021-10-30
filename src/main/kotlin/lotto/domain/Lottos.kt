package lotto.domain

class Lottos(val lottos: List<Lotto>) {
    fun countMatches(winningLotto: Lotto, bonus: LottoNumber): Map<Match, Int> {
        return lottos.map { it.checkMatch(winningLotto, bonus) }
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        fun of(quantity: Int, generatorFactory: GeneratorFactory): Lottos {
            val lottoList = (1..quantity).map { generatorFactory.createNumberGenerator() }
                .map { Lotto.from((1..Lotto.SIZE).map { it() }) }
            return Lottos(lottoList)
        }
    }
}
