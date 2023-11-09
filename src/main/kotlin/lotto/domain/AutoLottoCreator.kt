package lotto.domain

class AutoLottoCreator : LottoCreator {
    override fun createLotto(): Lotto = AutoLotto()
}
