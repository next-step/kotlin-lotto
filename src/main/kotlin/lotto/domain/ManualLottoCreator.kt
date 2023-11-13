package lotto.domain

class ManualLottoCreator(private val lottoNumbers: LottoNumbers) : LottoCreator {
    override fun createLotto(): Lotto = ManualLotto(lottoNumbers)

    companion object {
        fun createLottoList(vararg lottoNumbers: LottoNumbers): LottoList {
            val list = mutableListOf<Lotto>()
            for (numbers in lottoNumbers) {
                list.add(ManualLotto(numbers))
            }
            return LottoList(list)
        }
    }
}
