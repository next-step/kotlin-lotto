package com.nextstep.jngcii.lotto.model

object LottoMachine {
    private const val MINIMAL_NUMBER = 1
    private const val MAXIMAL_NUMBER = 45
    private const val LOTTO_COUNT = 6

    private val lottoBox = (MINIMAL_NUMBER..MAXIMAL_NUMBER).toList()

    fun get(count: Int): List<Lotto> {
        return List(count) {
            val numbers = lottoBox.shuffled().take(LOTTO_COUNT)
            Lotto(numbers)
        }
    }
}
