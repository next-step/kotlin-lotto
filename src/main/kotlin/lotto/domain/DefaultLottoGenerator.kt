package lotto.domain

object DefaultLottoGenerator : LottoGenerator {
    override fun generate(size: Int): Lotto = Lotto((Number.NUMBER_RANGE).shuffled().take(size).sorted().map { Number(it) })
}
