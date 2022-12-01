package lotto.domain

object AutoLottoSelector : LottoSelector {
    override fun select(): Lotto {
        return Lotto(
            LottoNumber.values()
                .shuffled()
                .take(Lotto.SIZE)
                .toSet()
        )
    }
}
