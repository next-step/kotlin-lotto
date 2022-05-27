package lotto

class AutoLottoMaker : LottoMaker {

    override fun make(): Lotto {
        return Lotto(CachedLotto.get())
    }
}
