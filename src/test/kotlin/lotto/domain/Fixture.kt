package lotto.domain

object Fixture {
    val lottos = Lottos(
        listOf(
            createLotto(1, 2, 3, 4, 5, 6),
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

    val winningLotto = createLotto(1, 2, 3, 4, 5, 6)

    val statistics = Statistics(lottos.countMatches(winningLotto))

    private fun createLotto(vararg numbers: Int): Lotto {
        return Lotto.from(numbers.toList())
    }
}
