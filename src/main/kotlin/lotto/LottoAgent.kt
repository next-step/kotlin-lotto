package lotto

class LottoAgent(val exchange: Exchange<LottoNumber>) {
    constructor(lottoExchange: LottoDrawMachine) : this(Exchange.Lotto(lottoExchange))
}
