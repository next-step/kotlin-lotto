package lotto.domain

data class Lotto(private val generator: LottoGenerator = AutoLottoGenerator) {
    val numbers = generator.execute()

    override fun toString() = "[${numbers.joinToString()}]"
}
