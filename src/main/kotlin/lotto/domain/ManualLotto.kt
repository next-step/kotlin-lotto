package lotto.domain

class ManualLotto(manual: LottoNumbers) : Lotto() {
    override val lottoNumbers: LottoNumbers = manual
}
