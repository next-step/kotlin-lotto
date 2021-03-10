package lotto

class LottoAgent(val exchange: Exchange<LottoNumbers>) {
    constructor(lottoExchange: LottoDrawMachine) : this(Exchange.Lotto(lottoExchange))
}
