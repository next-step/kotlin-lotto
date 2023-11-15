package lotto.domain

class ManualLottoCreator(private vararg val lottoNumbers: LottoNumbers) : LottoCreator {
    override fun createLottoList(): LottoList = LottoList(
        buildList {
            for (numbers in lottoNumbers) {
                add(ManualLotto(numbers))
            }
        }
    )
}
