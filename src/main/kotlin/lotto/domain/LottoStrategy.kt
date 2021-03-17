package lotto.domain

interface LottoStrategy {
    fun generateLotto(quantity: Int): Lottoes
}
