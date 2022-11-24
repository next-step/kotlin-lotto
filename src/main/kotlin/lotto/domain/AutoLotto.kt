package lotto.domain

object AutoLotto : LottoFactory {

    override fun create() =
        Lotto(
            NUMBER_RANGE.shuffled()
                .subList(EXTRACTION_POINT, DRAWING_QUANTITY)
                .sorted()
        )
}
