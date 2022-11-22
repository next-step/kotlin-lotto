package lotto.domain

class LottoAutoGenerateStrategy : LottoGenerateStrategy {
    override fun generate(): Set<LottoNumber> {
        throw Exception()
    }
}
