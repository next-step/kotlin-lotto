package lotto.domain

class AutoLottoCreator(private val count: Int) : LottoCreator {
    override fun createLottoList(): LottoList = LottoList(List(count) { AutoLotto() })
}
