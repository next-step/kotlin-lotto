package lotto.domain

object AutoLotto : LottoFactory {

    override fun create() =
        NUMBER_RANGE.shuffled()
            .slice(0..DRAWING_QUANTITY)
            .sorted()
}
