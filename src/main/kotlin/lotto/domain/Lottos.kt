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
        fun from(quantity: Int, numberGenerator: NumberGenerator): Lottos {
            val lottoList = (1..quantity).map { Lotto.from((1..Lotto.SIZE).map { numberGenerator.getNumber() }) }
            return Lottos(lottoList)
        }
    }
}
