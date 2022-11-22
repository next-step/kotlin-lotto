package lotto.domain

object AutoLotto : LottoFactory {

    override fun create() =
        Lotto(
            NUMBER_RANGE.shuffled()
                .subList(0, DRAWING_QUANTITY)
                .sorted()
        )
}
