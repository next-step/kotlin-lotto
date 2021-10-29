package lotto.domain

class Lottos(val list: List<Lotto>) {
    fun exportLottos(): List<List<Int>> {
        return list.map { it.numbers.map { it.value } }
    }

    fun countMatches(winningLotto: Lotto): Map<Match, Int> {
        return list.map { it.checkMatch(winningLotto) }
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        fun from(quantity: Int, generatorFactory: GeneratorFactory): Lottos {
            val lottoList = (1..quantity).map { generatorFactory.createNumberGenerator() }
                .map { Lotto.from((1..Lotto.SIZE).map { it() }) }
            return Lottos(lottoList)
        }
    }
}
