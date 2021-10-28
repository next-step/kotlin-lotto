package lotto.domain

class Lottos(quantity: Int, numberGenerator: NumberGenerator) {
    val lottos = (1..quantity).map {
        Lotto.from((1..Lotto.SIZE).map { numberGenerator.getNumber() })
    }

    fun exportLottos(): List<List<Int>> {
        return lottos.map { it.numbers.map { it.value } }
    }
}
