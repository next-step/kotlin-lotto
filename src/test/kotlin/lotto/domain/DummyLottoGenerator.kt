package lotto.domain

class DummyLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        throw UnsupportedOperationException("dummy 구현체에서 구현되지 않은 메서드")
    }
}
