package lotto.domain

class AutoLottoCreator : LottoCreator {
    override fun createLotto(): Lotto = AutoLotto()

    companion object {
        fun createLottoList(count: Int): LottoList {
            val list = mutableListOf<Lotto>()
            repeat(count) {
                list.add(AutoLotto())
            }
            return LottoList(list)
        }
    }
}
