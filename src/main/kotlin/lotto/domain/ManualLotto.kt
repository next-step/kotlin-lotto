package lotto.domain

class ManualLotto(manualNumbers: LottoNumbers) : Lotto {
    override val lottoNumbers: LottoNumbers = LottoNumbers.manual(manualNumbers)
}
