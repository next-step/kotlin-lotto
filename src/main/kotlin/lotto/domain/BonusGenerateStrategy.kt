package lotto.domain

interface BonusGenerateStrategy {
    fun generate(): LottoNumber
}
