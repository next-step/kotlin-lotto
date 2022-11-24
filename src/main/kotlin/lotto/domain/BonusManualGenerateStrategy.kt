package lotto.domain

class BonusManualGenerateStrategy : BonusGenerateStrategy {
    override fun generate(): LottoNumber {
        throw Exception()
    }
}
