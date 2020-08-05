package lotto.domain

data class Lotto(private val generator: LottoGenerator = AutoLottoGenerator) {
    val numbers = generator.execute().sorted()

    override fun toString() = "[${numbers.joinToString()}]"
}
