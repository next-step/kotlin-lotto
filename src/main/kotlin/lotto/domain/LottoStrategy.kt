package lotto.domain

interface LottoStrategy {
    fun generateLotto(money: Money): Lottoes
}
