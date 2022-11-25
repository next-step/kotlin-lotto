package lotto.domain

object AutoLotto : LottoFactory {

    override fun create() =
        Lotto(
            NUMBER_RANGE.shuffled()
                .take(DRAWING_QUANTITY)
                .sorted()
        )
}
