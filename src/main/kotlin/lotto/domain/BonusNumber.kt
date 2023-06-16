package lotto.domain

class BonusNumber(winNumber :LottoNumber, val bonusNumber : Int) {
    init {
        val isDuplicated = winNumber.lottoNumber.any {
            it == bonusNumber
        }
        if(isDuplicated) throw IllegalArgumentException("보너스볼은 중복된 숫자가 오면 안됨")
        require(bonusNumber >= LottoMachine.MINIMIUM_LOTTO_NUMBER &&  bonusNumber <= LottoMachine.MAXIMIUM_LOTTO_NUMBER) {
            "보너스볼은 ${LottoMachine.MINIMIUM_LOTTO_NUMBER }보다 작고 ${LottoMachine.MAXIMIUM_LOTTO_NUMBER}보다 크면 안됨"
        }
    }
}