package lotto.numbers

object RandomNumbersGenerator : LottoNumbersGenerator() {
    override fun generate(): List<Int> = lottoNumberPool.shuffled().take(lottoNumberSize)
}
