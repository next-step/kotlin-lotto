package lotto.domain

class FakeLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        return Lotto((11..16).map { LottoNumber(it) })
    }
}
