package lotto.domain

class FakeLottoGenerator : LottoGenerator {
    override fun generate(size: Int): Lotto = Lotto(List(size) { 1 }.map { Number(it) })
}
