package lotto.domain

fun interface LottoNumbersGenerateStrategy {
    fun generate(): LottoNumbers
}
