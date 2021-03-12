package lotto.domain

class LottoAgent(val exchange: Exchange<LottoNumbers>) {
    constructor(lottoDrawMachine: LottoDrawMachine) : this(Exchange.Lotto(lottoDrawMachine))
}
