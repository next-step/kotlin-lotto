package lotto.domain

object Fixture {
    fun createLotto(vararg numbers: Int = intArrayOf(1, 2, 3, 4, 5, 6)): Lotto {
        return Lotto.from(numbers.toList())
    }

    val manualLottos = Lottos.from(
        listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(2, 3, 4, 5, 6, 7),
            listOf(3, 4, 5, 6, 7, 8),
            listOf(4, 5, 6, 7, 8, 9)
        )
    )
    val lottos = Lottos.from(
        listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 11),
            listOf(1, 2, 3, 4, 5, 12),
            listOf(1, 2, 3, 4, 7, 11),
            listOf(1, 2, 3, 4, 7, 12),
            listOf(1, 2, 3, 4, 7, 13),
            listOf(1, 2, 3, 7, 8, 11),
            listOf(1, 2, 3, 7, 8, 12),
            listOf(1, 2, 3, 7, 8, 13),
            listOf(1, 2, 3, 7, 8, 14),
            listOf(21, 22, 23, 24, 25, 11),
            listOf(21, 22, 23, 24, 25, 12),
            listOf(21, 22, 23, 24, 25, 13),
            listOf(21, 22, 23, 24, 25, 14),
            listOf(21, 22, 23, 24, 25, 15)
        )
    )
    val winningLotto = createLotto()
    val bonus = LottoNumber(7)
    val statistics = Statistics(lottos.countMatches(winningLotto, bonus))
    val generatorFactory = object : GeneratorFactory {
        override fun createNumberGenerator(): () -> Int {
            var number = 1
            return { number++ }
        }
    }
}
