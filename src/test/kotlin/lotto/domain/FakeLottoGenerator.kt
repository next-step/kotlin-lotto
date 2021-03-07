package lotto.domain

class FakeLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
