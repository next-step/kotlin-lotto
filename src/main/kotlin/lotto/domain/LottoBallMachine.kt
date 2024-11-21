package lotto.domain

fun interface LottoBallMachine {
    fun generate(): LottoLine
}
