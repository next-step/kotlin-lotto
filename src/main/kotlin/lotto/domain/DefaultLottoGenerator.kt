package lotto.domain

object DefaultLottoGenerator : LottoGenerator {
    override fun generate(size: Int): Lotto = Lotto(Number.cache.shuffled().take(size).sorted())
}
