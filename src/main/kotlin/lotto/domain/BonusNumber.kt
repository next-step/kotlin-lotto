package lotto.domain

class BonusNumber(winNumber :LottoNumber, bonusNumber : Int) {
    init {
        val isDuplicated = winNumber.lottoNumber.any {
            it == bonusNumber
        }
        if(isDuplicated) throw IllegalArgumentException("보너스볼은 중복된 숫자가 오면 안됨")
        require(bonusNumber >= LottoMachine.MINIMIUM_LOTTO_NUMBER &&  bonusNumber <= LottoMachine.MAXIMIUM_LOTTO_NUMBER) {
            "보너스볼은 1보다 작고 45보다 크면 안됨"
        }
    }
}