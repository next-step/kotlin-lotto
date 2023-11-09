package lotto.domain

class ManualLottoCreator(private val lottoNumbers: LottoNumbers) : LottoCreator {
    override fun createLotto(): Lotto = ManualLotto(lottoNumbers)
}
