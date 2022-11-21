package lotto.domain

object AutoLotto : LottoFactory {

    override fun create() =
        NUMBER_RANGE.shuffled()
            .subList(0, DRAWING_QUANTITY)
            .sorted()
}
