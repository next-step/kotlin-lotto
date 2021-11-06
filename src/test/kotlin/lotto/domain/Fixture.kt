package lotto.domain

object Fixture {
    fun createLotto(vararg numbers: Int = intArrayOf(1, 2, 3, 4, 5, 6)): Lotto {
        return Lotto.from(numbers.toList())
    }

    val manualLottos = Lottos(
        listOf(
            createLotto(1, 2, 3, 4, 5, 6),
            createLotto(2, 3, 4, 5, 6, 7),
            createLotto(3, 4, 5, 6, 7, 8),
            createLotto(4, 5, 6, 7, 8, 9)
        )
    )
    val lottos = Lottos(
        listOf(
            createLotto(1, 2, 3, 4, 5, 6),
            createLotto(1, 2, 3, 4, 5, 7),
            createLotto(1, 2, 3, 4, 5, 11),
            createLotto(1, 2, 3, 4, 5, 12),
            createLotto(1, 2, 3, 4, 7, 11),
            createLotto(1, 2, 3, 4, 7, 12),
            createLotto(1, 2, 3, 4, 7, 13),
            createLotto(1, 2, 3, 7, 8, 11),
            createLotto(1, 2, 3, 7, 8, 12),
            createLotto(1, 2, 3, 7, 8, 13),
            createLotto(1, 2, 3, 7, 8, 14),
            createLotto(21, 22, 23, 24, 25, 11),
            createLotto(21, 22, 23, 24, 25, 12),
            createLotto(21, 22, 23, 24, 25, 13),
            createLotto(21, 22, 23, 24, 25, 14),
            createLotto(21, 22, 23, 24, 25, 15)
        )
    )
    val winningLotto = WinningLotto(createLotto(), LottoNumber(7))
    val statistics = Statistics(lottos.countMatches(winningLotto))
    val generatorFactory = object : GeneratorFactory {
        override fun createNumberGenerator(): () -> Int {
            var number = 1
            return { number++ }
        }
    }
}
